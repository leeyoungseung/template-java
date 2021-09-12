package template.java.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtil {

	public final int PERMISSION_X = 1;
	public final int PERMISSION_W = 2;
	public final int PERMISSION_R = 4;
	public final int PERMISSION_WX = 3;
	public final int PERMISSION_RX = 5;
	public final int PERMISSION_RWX = 7;
	
	public final String NEW_LINE_CODE_LINUX  = "\n";
	public final String NEW_LINE_CODE_WINDOW = "\r\n";
	public final String NEW_LINE_CODE_MAC    = "\r";
	
	public String pathSeparator = "/";
	
	public String getPathSeparator() {
		return pathSeparator;
	}

	public void setPathSeparator(String pathSeparator) {
		this.pathSeparator = pathSeparator;
	}
	
	
	/**
	 * ---------- Java 1.6 version 이하에도 사용가능
	 */
	



	/**
	 * 파일에 줄단위로 데이터를 입력한다. 기본 개행문자는 "\n"(Linux)
	 * 
	 * @param file
	 * @param data
	 * @return
	 */
	public boolean writePerLine(File file , List<String> data) {
		return writePerLine(file, data, "\n", true);
	}
	
	
	/**
	 * 파일에 줄단위로 데이터를 입력한다. 
	 * 
	 * @param file
	 * @param data
	 * @param newLineCode
	 * @param
	 * @return
	 */
	public boolean writePerLine(File file , List<String> data, String newLineCode, boolean override) {
		
		BufferedWriter wr = null;
		
		try {
			wr = new BufferedWriter(override ? new FileWriter(file, true) : new FileWriter(file));
			for (String var : data) {
				wr.append(var);
				wr.append(newLineCode);
			}
			wr.flush();
			
		} catch (IOException ioe) {ioe.printStackTrace(); return false;
		} finally {
			if (wr != null) {
				try {
					wr.close();
					wr = null;
				} catch (IOException ioe) { ioe.printStackTrace(); }
			}
		}
		
		return true;
	}
	
	
	/**
	 * 파일을 줄단위로 읽어오기
	 * 
	 * @param file
	 * @return
	 */
	public List<String> readPerLine(File file) {
		List<String> list = new ArrayList<String>();
		BufferedReader br = null;
		String line = "";
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				list.add(line);
			}
			
		} catch (IOException ioe) { ioe.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException ioe) { ioe.printStackTrace(); }
			}
		}
		
		return list;
	}
	
	
	/**
	 * 파일이나 디렉토리 이름변경 또는 이동
	 * 
	 * @param oldPath
	 * @param newPath
	 * @param override
	 * @return
	 * @throws Exception 
	 */
	public boolean rename(String oldPath, String newPath, boolean override) throws Exception {
		File oldFile = new File(oldPath);
		if (!oldFile.exists()) {
			return false; // 변경할 파일이나 디렉토리가 없다면
		}
		
		File newFile = new File(newPath);
		if ( newFile.exists() && !override ) {
			return false; // 덮어쓰기 금지의 경우
		} else if (newFile.exists() && override) {
			if (!delete(newFile)) {
				throw new Exception("Cause : "+newPath);
			}
		}
		
		return oldFile.renameTo(newFile);
	}
	
	
	/**
	 * 파일 복사
	 * 
	 * @param originPath
	 * @param destPath
	 * @param override
	 * @return
	 * @throws IOException
	 */
	public boolean copy(File originFile, File destFile, boolean override) throws IOException {
		
		if ( !originFile.exists() ) {
			return false; // 복사할 파일
		}
		
		if ( destFile.exists() && !override ) {
			return false; // 결과 파일이 이미 존재하며, 덮어쓰기 플래그가 false라면 
		}
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(originFile);
			os = new FileOutputStream(destFile);
			byte [] buff = new byte[1024];
			int length;
			while ((length = is.read(buff)) > 0) {
				os.write(buff, 0, length);
			}
			
			return true;
		} finally {
			is.close(); is = null;
			os.close(); os = null;
		}
	}
	
	/**
	 * 파일 복사 (파라미터를 문자열로 받기)
	 * 
	 * @param originPath
	 * @param destPath
	 * @param override
	 * @return
	 * @throws IOException
	 */
	public boolean copy(String originPath, String destPath, boolean override) throws IOException {
		return copy(new File(originPath), new File(destPath), override);
	}
	
	
	/**
	 * 디렉토리 만들기. 이미 디렉토리가 존재하면 만들지 않는다.
	 * 
	 * @param path
	 * @return
	 */
	public boolean makeDir(String path) {
		File f = new File(path);
		if ( f.exists() ) {
			return true; // 이미 존재하면 다시 생성할 필요는 없음
		}
		
		return new File(path).mkdirs();
	}
	
	/**
	 * 1. 파라미터를 받아 copys() 실행 :  $1 복사대상 디렉토리, $2 복사결과 디렉토리
	 * 2. 복사대상 디렉토리 또는 파일이 있는지 확인한다. 없다면 false, 있다면 다음처리로
	 * 3. 복사대상 디렉토리의 내용을 확인해서 파일과 디렉토리에 맞게 복사처리
	 *  1) 디렉토리라면 : 
	 *     mkdir $1/확인한 디렉토리 $2/확인한 디렉토리의 복사본
	 *     파라미터를 받아 copys() 실행 : $1 = $1/확인한 디렉토리 $2 = $2/확인한 디렉토리의 복사본
	 *  2) 파일이라면  : 
	 *     cp $1/확인한 파일.txt $2/확인한 파일의 복사본.txt
	 * 4. 처리결과가 성공이면 true, 실패면 false를 리턴
	 * 
	 * @param origin : 복사대상
	 * @param dest   : 복사결과
	 * @param override : 덮어쓰기 플래그
	 * @return
	 * @throws Exception
	 */
	public boolean copys(File origin, File dest, boolean override) throws Exception {
		if (origin.exists()) {
			
			if (origin.isDirectory()) {
				if ( !makeDir(dest.getAbsolutePath())) {
					throw new Exception("Caused by makeDir="+dest.getAbsolutePath());
				}
				
				for (File f : origin.listFiles()) {
					 if ( !copys(f, new File(dest.getAbsolutePath() + this.pathSeparator + f.getName()), override)) {
						 throw new Exception("Caused by copys="+dest.getAbsolutePath());
					 }
				}
				
				return true;

			} else if (origin.isFile()) {
				if (copy(origin, dest, true)) {
					return true;
				} else {
					return false;
				}
			}
		} 
		
		return false;
	}
	
	/**
	 * 파일 또는 디렉터리 복사
	 * 
	 * @param origin
	 * @param dest
	 * @param override
	 * @return
	 * @throws Exception
	 */
	public boolean copys(String origin, String dest, boolean override) throws Exception {
		return copys(new File(origin), new File(dest), override);
	}
	
	
	/**
	 * 파일의 권한을 숫자로 리턴. 실행권한 : 1, 쓰기권한 : 2, 읽기 권한 : 4
	 * 
	 * @param path
	 * @return
	 */
	public Integer checkPermission(String path) {
		File f = new File(path);
		
		if (!f.exists()) {
			return null;
		}
		
		Integer permission = 0;
		permission += (f.canExecute()) ? PERMISSION_X : 0;
		permission += (f.canWrite()) ? PERMISSION_W : 0;
		permission += (f.canRead()) ? PERMISSION_R : 0;
		
		return permission;
	}
	
	
	/**
	 * 파일 또는 디렉토리의 권한을 설정한다. 
	 * 모든권한 : 7, 읽기권한 : 4, 쓰기권한 : 2, 실행권한 : 1
	 * 읽기 + 쓰기 : 6, 읽기 + 실행 : 5, 쓰기+실행 : 3
	 * 
	 * @param target
	 * @param permission
	 * @return
	 */
	public boolean setPermission(String path, Integer permission) {
		File f = new File(path);
		
		if (!f.exists()) {
			return false;
		}
		
		File target = new File(path);
		boolean res = false;
		
		switch (permission) {
		case PERMISSION_X:
			res = setPermission(target,false,false,true);
			break;
		case PERMISSION_W:
			res = setPermission(target,false,true,false);
			break;
		case PERMISSION_R:
			res = setPermission(target,true,false,false);
			break;
		case PERMISSION_WX:
			res = setPermission(target,false,true,true);
			break;
		case PERMISSION_RX:
			res = setPermission(target,true,false,true);
			break;
		case PERMISSION_RWX:
			res = setPermission(target,true,true,true);
			break;
		default:
			res = setPermission(target,false,false,false);
			break;
		}
		
		return res;
	}
	
	
	/**
	 * 파일 권한 설정 서브 메소드
	 * 
	 * @param target
	 * @param read
	 * @param write
	 * @param exe
	 * @return
	 */
	private boolean setPermission(File target , boolean read, boolean write, boolean exe) {
		try {
			target.setReadable(read);
			target.setWritable(write);
			target.setExecutable(exe);
			return true;
			
		} catch (Exception e) { 
			e.printStackTrace(); 
			return false; 
		}
	}
	
	
	/**
	 * 파일의 정보 가져오기
	 * 
	 * @param path
	 * @return
	 */
	public Map<String, String> getFileInfo(String path) {
		File target = new File(path);
		if ( !target.exists() ) {
			return null; // 복사할 파일이나 디렉토리가 없다면
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		try {
			map.put("canonicalPath", target.getCanonicalPath());
			map.put("absolutePath", target.getAbsolutePath());
			String filename = target.getName();
			map.put("name", target.getName());
			map.put("extension", filename.substring(filename.lastIndexOf(".") + 1));
			map.put("parent", target.getParent());
			map.put("path", target.getPath());
			map.put("permission", String.valueOf(checkPermission(path)));
			map.put("lastModified", ""+target.lastModified());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	
	/**
	 * 파일 또는 디렉토리 삭제하기
	 * 
	 * @param path
	 * @return
	 * @throws Exception 
	 */
	public boolean delete(String path) throws Exception {
		return delete(new File(path));
	}
	
	
	/**
	 * 파일 또는 디렉토리 삭제하기
	 * 
	 * @param target
	 * @return
	 * @throws Exception 
	 */
	public boolean delete(File target) throws Exception {
		// 파일또는 디렉토리가 있는지 확인
		if ( target.isFile() || target.isDirectory() ) {
			// 디렉토리 인지 확인
			if (target.isDirectory()) {
				// 디렉토리안에 파일이 존재하면 디렉토리안의 파일을 먼저 삭제해야함
				for (File f : target.listFiles()) {
					// 재귀적으로 파일 삭제
					if ( !delete(f)) {
						 throw new Exception("Caused by delete="+f.getAbsolutePath());
					}
				}	
			}
			
			if (target.delete()) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return true;
		}
	}
	
	
	/**
	 * ---------- Java 1.7 version이후에 사용가능
	 */
	
	
	
	
}
