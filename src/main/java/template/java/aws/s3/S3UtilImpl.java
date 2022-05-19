package template.java.aws.s3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

import lombok.extern.slf4j.Slf4j;
import template.java.aws.AwsProp;

@Slf4j
public class S3UtilImpl implements S3Util {

	private AwsProp prop = null;
	private AmazonS3 s3 = null;

	public S3UtilImpl() {
		setProp("src/main/resources/aws.properties");
	}

	public S3UtilImpl(String propFile) {
		setProp(propFile);
	}


	/**
	 * Setting to control AWS S3 using Java library.
	 *
	 * @param propFile
	 */
	public void setProp(String propFile) {
		 prop = AwsProp.getInstance();
		 prop.loadProperties(propFile);

		 String accessKey = prop.getAccessKey();
		 String secretKey = prop.getSecretKey();

		 AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		 s3 = AmazonS3ClientBuilder.standard()
				 .withCredentials(new AWSStaticCredentialsProvider(credentials))
				 .build();

		 log.info("Finish Setting to control AWS S3");
	}

	@Override
	public List<Bucket> getbucketList() {
		return s3.listBuckets();
	}


	@Override
	public Bucket findBucketbyName(String bucketName) {
		log.info("To find bucket [%s] ", bucketName);

		Bucket result = null;
		List<Bucket> buckets = s3.listBuckets();

		for (Bucket bk : buckets) {
			if (bk.getName().equals(bucketName)) {
				result = bk;
				log.info("Exist bucket [%s] ", bucketName);
			}
		}

		return result;
	}

	@Override
	public boolean createBucket(String bucketName) {
		log.info("To create bucket [%s] ", bucketName);

		if (s3.doesBucketExistV2(bucketName)) {
			log.info("Already exist bucket [%s] ", bucketName);
			return false;
		}

		try {

			s3.createBucket(bucketName);
			log.info("Succeed creating bucket [%s] ", bucketName);
			return true;

		} catch (Exception e) {
			log.debug(e.getMessage());
		}

		return false;
	}

	@Override
	public boolean deleteBucket(String bucketName) {
		log.info("To delete bucket [%s] ", bucketName);
		try {

			log.info("Removing objects from bucket[%s]", bucketName);
			ObjectListing objectListing = s3.listObjects(bucketName);

			while (true) {
				for (Iterator<?> iterator = objectListing.getObjectSummaries().iterator(); iterator.hasNext();) {
					S3ObjectSummary summary = (S3ObjectSummary) iterator.next();
					s3.deleteObject(bucketName, summary.getKey());
				}

				if (objectListing.isTruncated()) {
					objectListing = s3.listNextBatchOfObjects(objectListing);
				} else {
					break;
				}
			}

			log.info("Removing versions from bucket[%s]", bucketName);
			VersionListing versionListing = s3.listVersions(new ListVersionsRequest().withBucketName(bucketName));

			while (true) {
				for (Iterator<?> iterator = versionListing.getVersionSummaries().iterator(); iterator.hasNext();) {
					S3VersionSummary vs = (S3VersionSummary) iterator.next();
					s3.deleteVersion(bucketName, vs.getKey(), vs.getVersionId());
				}

				if (versionListing.isTruncated()) {
					versionListing = s3.listNextBatchOfVersions(versionListing);
				} else {
					break;
				}
			}

			s3.deleteBucket(bucketName);
			log.info("Succeed removing bucket[%s]", bucketName);
			return true;

		} catch (AmazonServiceException e) {
			log.error(e.getErrorMessage());
		}

		log.info("Failure to remove bucket[%s]", bucketName);
		return false;
	}


	@Override
	public boolean uploadByTM(String uploadPath, File targetFile) {
		log.info("START Upload_Path[%s], TargetFile[%s]", uploadPath, targetFile);

		File f = targetFile;

		TransferManager xferMgr = TransferManagerBuilder.standard()
				.withS3Client(s3)
				.build();

		try {

			Upload xfer = xferMgr.upload(uploadPath, f.getName(), f);
            xfer.waitForCompletion();

            log.info("Succeed END Upload_Path[%s], TargetFile[%s]", uploadPath, targetFile);
            return true;

		} catch (AmazonServiceException e) {
			log.error(e.getErrorMessage());

		} catch (AmazonClientException | InterruptedException e) {
			log.error(e.getMessage());

		} finally {
			xferMgr.shutdownNow(false);

		}

		log.error("Failure END Upload_Path[%s], TargetFile[%s]", uploadPath, targetFile);
		return false;
	}


	@Override
	public boolean uploadFileList(String uploadPath, String keyPrefix, String targetDir, List<File> files) {

		StringBuilder sb = new StringBuilder();
		sb.append(targetDir+"\n");

		for (File f : files) {
			sb.append(f.getName()+",");
		}

		log.info("START uploadPath[%s], keyPrefix[%s], targetDir[%s], files[%s]", uploadPath, keyPrefix, targetDir, sb.toString());

		TransferManager xferMgr = TransferManagerBuilder.standard().withS3Client(s3).build();
		try {
			MultipleFileUpload xfer = xferMgr.uploadFileList(uploadPath, keyPrefix, new File(targetDir), files);
			xfer.waitForCompletion();

            log.info("Succeed uploadPath[%s], keyPrefix[%s], targetDir[%s], files[%s]", uploadPath, keyPrefix, targetDir, sb.toString());
            return true;

		} catch (AmazonServiceException e) {
			log.error(e.getErrorMessage());

		} catch (AmazonClientException | InterruptedException e) {
			log.error(e.getMessage());

		} finally {
			xferMgr.shutdownNow(false);
			sb = null;
		}

		log.error("Failure uploadPath[%s], keyPrefix[%s], targetDir[%s], files[%s]", uploadPath, keyPrefix, targetDir, sb.toString());
		return false;
	}


	@Override
	public boolean uploadDir(String uploadPath, String keyPrefix, String targetDir, boolean recursive) {
		log.info("START uploadPath[%s], keyPrefix[%s], targetDir[%s], recursive[%s]", uploadPath, keyPrefix, targetDir, recursive);

		TransferManager xferMgr = TransferManagerBuilder.standard().withS3Client(s3).build();

		try {
			MultipleFileUpload xfer = xferMgr.uploadDirectory(uploadPath, keyPrefix, new File(targetDir), recursive);
			xfer.waitForCompletion();

            log.info("Succeed uploadPath[%s], keyPrefix[%s], targetDir[%s], recursive[%s]", uploadPath, keyPrefix, targetDir, recursive);
            return true;

		} catch (AmazonServiceException e) {
			log.error(e.getErrorMessage());

		} catch (AmazonClientException | InterruptedException e) {
			log.error(e.getMessage());

		} finally {
			xferMgr.shutdownNow(false);
		}

		log.error("Failure uploadPath[%s], keyPrefix[%s], targetDir[%s], recursive[%s]", uploadPath, keyPrefix, targetDir, recursive);
		return false;
	}


	@Override
	public List<S3ObjectSummary> getFileList(String contentsPath) {
		ListObjectsV2Result result = s3.listObjectsV2(contentsPath);
		return result.getObjectSummaries();
	}


	@Override
	public boolean download(String bucket, String contentsPath, String downloadedPath) {
		log.info("START bucket[%s], contentsPath[%s], downloadedPath[%s]", bucket, contentsPath, downloadedPath);

		try {

			S3ObjectInputStream inputStream = s3.getObject(bucket, contentsPath).getObjectContent();
			File f = new File(downloadedPath);
		    Files.copy(inputStream, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
		    log.info("Succeed bucket[%s], contentsPath[%s], downloadedPath[%s]", bucket, contentsPath, downloadedPath);
		    return true;

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		log.error("Failure bucket[%s], contentsPath[%s], downloadedPath[%s]", bucket, contentsPath, downloadedPath);
		return false;
	}


	@Override
	public boolean delete(String bucket, String contentsPath) {
		log.info("START bucket[%s], contentsPath[%s] ", bucket, contentsPath);
		try {

			s3.deleteObject(bucket, contentsPath);
			log.info("Succeed bucket[%s], contentsPath[%s] ", bucket, contentsPath);
			return true;

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		log.error("Failure bucket[%s], contentsPath[%s] ", bucket, contentsPath);
		return false;
	}


	@Override
	public boolean upload(String bucket, String uploadPath, File targetFile) {
		log.info("START bucket[%s], uploadPath[%s], targetFile[%s] ", bucket, uploadPath, targetFile.getName());
		try {

			s3.putObject(bucket, uploadPath, targetFile);
			log.info("Succeed bucket[%s], uploadPath[%s], targetFile[%s] ", bucket, uploadPath, targetFile.getCanonicalPath());
			return true;

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		log.error("Failure bucket[%s], uploadPath[%s], targetFile[%s] ", bucket, uploadPath, targetFile.getName());
		return false;
	}


}
