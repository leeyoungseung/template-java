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

	public final int PERMISSION_E = 1;
	public final int PERMISSION_W = 2;
	public final int PERMISSION_R = 4;
	public final int PERMISSION_WE = 3;
	public final int PERMISSION_RE = 5;
	public final int PERMISSION_RWE = 7;
	
	public final String NEW_LINE_CODE_LINUX  = "\n";
	public final String NEW_LINE_CODE_WINDOW = "\r\n";
	public final String NEW_LINE_CODE_MAC    = "\r";
	
	
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
	 * 파일이나 디렉토리 복사
	 * 
	 * @param originPath
	 * @param destPath
	 * @param rename
	 * @return
	 * @throws IOException
	 */
	public boolean copy(String originPath, String destPath, boolean rename) throws IOException {
		File originFile = new File(originPath);
		if ( !originFile.exists() ) {
			return false; // 복사할 파일이나 디렉토리가 없다면
		}
		
		File destFile = new File(destPath);
		if ( destFile.exists() && !rename ) {
			return false; // 결과 파일이 이미 존재하며, 덮어쓰기 플래그가 false라면 
			
		} else if (destFile.exists() && rename) {
			destPath += "_cp";
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
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
		permission += (f.canExecute()) ? PERMISSION_E : 0;
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
		case PERMISSION_E:
			res = setPermission(target,false,false,true);
			break;
		case PERMISSION_W:
			res = setPermission(target,false,true,false);
			break;
		case PERMISSION_R:
			res = setPermission(target,true,false,false);
			break;
		case PERMISSION_WE:
			res = setPermission(target,false,true,true);
			break;
		case PERMISSION_RE:
			res = setPermission(target,true,false,true);
			break;
		case PERMISSION_RWE:
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
	 * 파일 또는 디렉토리 삭제하기
	 * 
	 * @param path
	 * @return
	 */
	public boolean delete(String path) {
		return delete(new File(path));
	}
	
	/**
	 * 파일 또는 디렉토리 삭제하기
	 * 
	 * @param target
	 * @return
	 */
	public boolean delete(File target) {
		// 파일또는 디렉토리가 있는지 확인
		if ( target.isFile() || target.isDirectory() ) {
			// 디렉토리 인지 확인
			if (target.isDirectory()) {
				// 디렉토리안에 파일이 존재하면 디렉토리안의 파일을 먼저 삭제해야함
				for (File f : target.listFiles()) {
					delete(f); // 재귀적으로 파일 삭제
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
