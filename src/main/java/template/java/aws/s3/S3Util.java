package template.java.aws.s3;

import java.io.File;
import java.util.List;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public interface S3Util {

	public List<Bucket> getbucketList();

	public Bucket findBucketbyName(String bucketName);

	public boolean createBucket(String bucketName);

	public boolean deleteBucket(String bucketName);

	public boolean upload(String bucket, String uploadPath, File targetFile);

	public boolean uploadByTM(String uploadPath, File targetFile);

	public boolean uploadFileList(String uploadPath, String keyPrefix, String targetDir, List<File> files);

	public boolean uploadDir(String uploadPath, String keyPrefix, String targetDir, boolean recursive);

	public List<S3ObjectSummary> getFileList(String contentsPath);

	public boolean download(String bucket, String contentsPath, String downloadedPath);

	public boolean delete(String bucket, String contentsPath);

}
