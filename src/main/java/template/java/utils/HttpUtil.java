	/**
	 * HTTP Request ~ Response처리 까지의 흐름
	 * 1.Request 
	 *  1) 요청 URL ( + 파라미터 설정&a=1?b=param2)
	 *  2) HTTP 메서드 GET, POST, PUT, DELETE, CONNECT...
	 *  3) 요청헤더
	 *   - HOST : 서버의 도메인 네임과 리스닝중인 TCP포트를 지정 
	 *            Ex) Host: www.google.com:80 
	 *   - User-Agent : 리퀘스트를 보내는 클라이언트(운영체제 + 브라우저 · 스마트폰단말등..) 정보 
	 *            Ex) User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36
	 *   - Accept : 응답시에 받을 데이터 타입을 서버에 알림
	 *            Ex) Accept: text/html, application/json;q=0.9, application/xml;q=0.8 
	 *   - Authorization : 요청자가 서버에 인가된 사용자임을 증명할때 사용, JWT토큰 등을 서버로 보낼때 이용
	 *            Ex) Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDAzQGdtYWlsLmNvbSIsImV4cCI6MTYyNjU3NDUwNywiaWF0IjoxNjI2NTc0NDQ3fQ.InnVSkfoTfu7Z0EsMkAlMAqRfBj7-DfPvu8VnMMXdwQNt0M6-OPCfq8POFPmlxdhMoejx2k7Gsl4urtP6LFQ0A
	 *   - Origin : 요청이 어느 주소에서 시작되었는지 표시
	 *   - Referer : 이전 페이지의 주소가 담겨있음
	 *   - Content-Type : 요청시 바디에 담기는 데이터의 타입 명시
	 *            Ex) Content-Type: application/json
	 *  4) Request Body 
	 *   JSON, XML, TEXT, FILE, Form데이터등등
	 *   
	 *  5) 기타 설정
	 *  - 동기 OR 비동기
	 *  - Connection Timeout Limit설정
	 *  
	 * 2. Request 보내기
	 *  
	 * 3. Response 처리
	 *  1) HTTP Response 코드 확인 (2xx, 3xx, 4xx, 5xx)
	 *  2) Response 결과가 성공 : Response Body의 데이터 처리등 상정한 처리 실시 
	 *  3) Response 결과가 실패 : Response Code에 해당하는 메시지를 출력
	 *   
	 */
package template.java.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

import template.java.utils.networksub.RequestBody;
import template.java.utils.networksub.ResponseBody;

public class HttpUtil {
	
	private HttpUtil() {};
	public static HttpUtil getInstance() { return HttpUtilHolder.INSTANCE; }
	private static class HttpUtilHolder { private static final HttpUtil INSTANCE = new HttpUtil(); }
	
	
	private HttpURLConnection con;
	private byte[] formData = null;
	private int CONNECTION_TIMEOUT_LIMIT = 0;
	private int READ_TIMEOUT_LIMIT       = 0;
	private RequestBody requestBody;
	private ResponseBody responseBody;
	private OutputStream os;
	
	// For Multipart File data Upload
	private BufferedOutputStream out;
	private String BOUNDARY = "-----";
	private String LINEFEED = "\r\n";

	public void setRequestBody(RequestBody requestBody) { this.requestBody = requestBody; }
	public RequestBody getRequestBody() { return requestBody; }
	public void setResponseBody(ResponseBody responseBody) { this.responseBody = responseBody; }
	public ResponseBody getResponseBody() { return responseBody; }
	public byte[] getFormData() { return formData; }
	public void setFormData(byte[] formData) { this.formData = formData; }
	
	/**
	 * HTTP Request 메인
	 * 
	 * @param protocol
	 * @param targetUrl
	 * @param settings
	 * @return
	 */
	public boolean request(String protocol, String targetUrl, Map<String, String> settings) {
		
		try {
			// URL에 해당하는 Connection 객체 생성
			setConnection(protocol, targetUrl);
			
			// Request 준비
			requestSetting(settings);
			
			// Request 준비 - Request Body 설정
			if (settings.get("Method") != null && (settings.get("Method").equals("POST") || settings.get("Method").equals("PUT"))) {
				this.formData = requestBody.getData();
			}
			
			// Request 송신 & Response 처리
            return execute();
            
		} catch (Exception e) { 
			e.printStackTrace(); 
			return false;
		} 
	}
	
	
	/**
	 * Connection 설정
	 * 
	 * @param protocol
	 * @param targetUrl
	 * @return
	 * @throws IOException
	 */
	private void setConnection(String protocol, String targetUrl) throws IOException {
		URL url = new URL(targetUrl);
		switch (protocol) {
		case "http":
			this.con = (HttpURLConnection)url.openConnection();
			break;
		case "https":
			this.con = (HttpsURLConnection)url.openConnection();
			break;
		default:
			break;
		}
	}
	
	
	/**
	 * Request Header등 설정
	 * 
	 * @param settings
	 * @throws ProtocolException
	 */
	private void requestSetting(Map<String, String> settings) throws ProtocolException {

		System.out.println("---------- Set Header Start----------");
		for (String headerInfoKey : settings.keySet()) {
			System.out.println("SetKey : "+headerInfoKey+", SetValue : "+settings.get(headerInfoKey) );
			this.con.setRequestProperty(headerInfoKey, settings.get(headerInfoKey));
			
		}
		System.out.println("---------- Set Header End  ----------");
		
		System.out.println("--------- Value Setting -------");
		this.con.setRequestMethod(settings.get("Method"));
		this.con.setConnectTimeout(CONNECTION_TIMEOUT_LIMIT);
		this.con.setReadTimeout(READ_TIMEOUT_LIMIT);
		this.con.setUseCaches(false); 
		this.con.setInstanceFollowRedirects(settings.get("Method").equals("GET") ? true : false);
		this.con.setDoOutput(settings.get("Method").equals("GET") ? false : true);
		
		System.out.println("----- Setting Method : "+con.getRequestMethod());
	}
	
	
	/**
	 * Request 송신
	 * 
	 * @return
	 * @throws Exception 
	 */
	private boolean execute() throws Exception {
		
		BufferedReader buff = null;
		try {
			
			// 요청보내기
			this.con.connect();
			
			if (this.formData != null) {
				System.out.println("exist data");
				this.os = this.con.getOutputStream();
				this.os.write(this.formData);
			}
			
			// 응답 확인하기
			int responseCode = this.con.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				buff = new BufferedReader(
						new InputStreamReader(this.con.getInputStream(),"utf-8"));
				
				if (!responseBody.readResult(buff)) {
					throw new Exception();
				}
				
			} else {
				System.err.println("ResponseCode : " + con.getResponseCode() +", ResponseMessage" + con.getResponseMessage());
				return false;
			}
			
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		} finally {
	    	try {
		        if (buff != null) {
	    		    buff.close();
	    		    buff = null;
		        }
		    	this.con.disconnect();
		    	this.con = null;
		    	this.os.close();
		    	this.os = null;
			} catch (Exception e) { e.printStackTrace(); }
		}
	}
	
	/**
	 * 【Multipart/form-data】HTTP Request 메인
	 * 
	 * @param protocol
	 * @param targetUrl
	 * @param settings
	 * @param headers
	 * @param files
	 * @return
	 */
	public boolean request(String protocol, String targetUrl, Map<String, String> settings, Map<String, String> params, File ...files) {
		// 파일 한개 전송시는 file, 여러개 전송시는 files로 파라미터 설정
		String fileParam = ( 2 <= files.length ) ? "files" : "file";
		BufferedReader buff = null;
		try {
			// URL에 해당하는 Connection 객체 생성
			setConnection(protocol, targetUrl);
			
			// Request 준비
			settings.put("Content-Type", "multipart/form-data;charset=utf-8;boundary=" + BOUNDARY);
			requestSetting(settings);
			
			os = this.con.getOutputStream();
			out =  new BufferedOutputStream(os);
			int contentLength = 0;
			contentLength += write(out, LINEFEED);
			
			if (params.size() > 0) {
				contentLength += write(out, addParams(params));
			}
			out.flush();
			
			for (File file : files) {
	            contentLength += write(out, ("--" + BOUNDARY + LINEFEED));
	            StringBuffer header = new StringBuffer(); 
	            		
	            		
	            header.append("Content-Disposition: form-data;name=\""+ fileParam +"\";filename=\"" + file.getName()  + "\"").append(LINEFEED);
	            header.append(LINEFEED);
	            header.append("Content-Type:" + URLConnection.guessContentTypeFromName(file.getName())).append(LINEFEED);
	            header.append(LINEFEED);
	            header.append("Content-Transfer-Encoding:binary").append(LINEFEED);
	            header.append(LINEFEED);
	            
	            contentLength += write(out, header.toString());
	            contentLength += write(out, LINEFEED);

	            InputStream inputStream = new FileInputStream(file);
	            byte[] input = new byte[inputStream.available()];
	            while(inputStream.read(input) > -1) {
	                contentLength += input.length;
	                write(out, input);
	            }

	            contentLength += write(out, LINEFEED);
			}
			
			contentLength += write(out , "--" + BOUNDARY + "--"+ LINEFEED);
			out.flush();
			out.close(); // -- 보내야할 데이터 설정완료, 요청보내기
			
			
			// 응답 확인하기
			int responseCode = this.con.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				buff = new BufferedReader(
						new InputStreamReader(this.con.getInputStream(),"utf-8"));
				
				if (!responseBody.readResult(buff)) {
					throw new Exception();
				}
				
			} else {
				System.err.println("ResponseCode : " + con.getResponseCode() +", ResponseMessage" + con.getResponseMessage());
				return false;
			}
	        
			return true;
		} catch (Exception e) { 
			e.printStackTrace(); 
			return false;
			
		} finally {
			try {
				if (buff != null) {
					buff.close();
	    		    buff = null;
				}
	    		this.con.disconnect();
	    		this.con = null;
				this.os.close(); 
				this.os = null;
			} catch (IOException e) {  e.printStackTrace(); }
		}
		
	}
	
	
	/**
	 * 【Multipart/form-data】파라미터를 설정 준비
	 * 
	 * @param textDataMap
	 * @return
	 */
	private String addParams(Map<String, String> params) {
        StringBuilder body = new StringBuilder();
        body.append(LINEFEED);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            body
                .append("--").append(BOUNDARY).append(LINEFEED)
                .append("Content-Disposition: form-data; name=\"").append(entry.getKey()).append("\"").append(LINEFEED)
                .append(LINEFEED)
                .append(entry.getValue()).append(LINEFEED);
        }

        return body.toString();
    }
    
	
	/**
	 * 【Multipart/form-data】폼에 파라미터 설정하기 
	 * 
	 * @param out
	 * @param string
	 * @return
	 * @throws IOException
	 */
    private int write(BufferedOutputStream out, String string) throws IOException {
        out.write(string.getBytes("UTF-8"));
        return string.length();
    }

    
    /**
     *【Multipart/form-data】폼에 파일 데이터 설정하기
     * 
     * @param out
     * @param bytes
     * @return
     * @throws IOException
     */
    private int write(BufferedOutputStream out, byte[] bytes) throws IOException {
        out.write(bytes);
        return bytes.length;
    }
	
}