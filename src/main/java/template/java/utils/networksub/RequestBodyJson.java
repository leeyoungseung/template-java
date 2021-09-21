package template.java.utils.networksub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class RequestBodyJson implements RequestBody {

	public RequestBodyJson() {}
	
	public RequestBodyJson(Object data) throws UnsupportedEncodingException {
		this.data = ((String)data).getBytes("UTF-8");
	}
	
	private byte[] data;
	

	@Override
	public void setData(Object data) throws UnsupportedEncodingException {
		this.data = ((String)data).getBytes("UTF-8");
	}



	@Override
	public void setData(Object data, String originEncoding, String newEncoding) throws UnsupportedEncodingException {
		this.data = translatorStr(((String)data), originEncoding, newEncoding).getBytes(newEncoding);
	}



	@Override
	public void setData(File target) throws UnsupportedEncodingException, IOException {
		this.data = readFileToStr(target).getBytes("UTF-8");
		
	}


	@Override
	public void setData(File target, String originEncoding, String newEncoding)
			throws UnsupportedEncodingException, IOException {
		this.data = translatorStr(readFileToStr(target), originEncoding, newEncoding).getBytes(newEncoding);
	}
	

	@Override
	public byte[] getData() {
		return data;
	}
	
	
	public String readFileToStr(File file) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		String line;
		try {
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			while((line = br.readLine()) != null) {
				sb.append(line);
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
		
		return sb.toString();
	}


	/**
	 * 문자열의 인코딩을 지정한 방식으로 변환한다.
	 * @param target : 인코딩을 변환하려는 문자열
	 * @param oldEncodingType : 현재의 인코딩 타입
	 * @param newEncodingType : 변환할 인코딩 타입
	 * @return
	 */
	public String translatorStr(String target, String oldEncodingType, String newEncodingType) {
		String originTypeStr = decodeStr(target, oldEncodingType);
		return decodeStr(originTypeStr, newEncodingType);
	}
	
	
	/**
	 * 문자열을 현재 인코딩되어있는 타입으로 디코딩하여 byte배열로 만든 후 byte 배열을 문자열로 변환하여 
	 * 변환된 문자열을 리턴한다. 
	 * @param target
	 * @param type
	 * @return
	 */
	public String decodeStr(String target, String type) {
		String decodedStr = null;
		try {
			decodedStr = new String(target.getBytes(type), type);
			
		} catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		
		return decodedStr;
	}
	


}
