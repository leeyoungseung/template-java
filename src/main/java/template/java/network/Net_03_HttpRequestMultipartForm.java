package template.java.network;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


import template.java.utils.HttpUtil;
import template.java.utils.networksub.ResponseBodyString;


public class Net_03_HttpRequestMultipartForm {

	static HttpUtil hu = HttpUtil.getInstance();

	public static void main(String[] args) {
		
		try {

			uploadOneFile(new File(args[0]));
			Thread.sleep(1000); // Stream이 완전 종료되기까지 대기
			
			File [] files = new File[args.length];
			for (int i=0; i<args.length; i++) {
				files[i] = new File(args[i]);
			}
			
			uploadManyFile(files);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void uploadOneFile(File file) throws Exception {
		System.out.println("POST Request Body file = "+file.getName());	
		String protocol = "http";
		String targetUrl = "http://localhost:8080/api/items/127/upload-file";
		System.out.println("URL : "+targetUrl);
		Map<String, String> settings = new HashMap<String, String>();
		
		settings.put("Method", "POST");
		settings.put("HOST", "localhost:8080");
		settings.put("User-Agent", "Java-Client");
		settings.put("Connection", "Keep-Alive");
		settings.put("Cache-Control", "no-cache");
		
		hu.setResponseBody(new ResponseBodyString());
		hu.request(protocol, targetUrl, settings, new HashMap(), file);
		
		System.out.println("Post Request - Response Result ");
		System.out.println(hu.getResponseBody().getResult());
		
	}
	
	
	public static void uploadManyFile(File [] files) throws Exception {
		System.out.println("POST Request Body files = "+files[0].getName());
		
		String protocol = "http";
		String targetUrl = "http://localhost:8080/api/items/127/upload-files";
		System.out.println("URL : "+targetUrl);
		Map<String, String> settings = new HashMap<String, String>();
		
		settings.put("Method", "POST");
		settings.put("HOST", "localhost:8080");
		settings.put("User-Agent", "Java-Client");
		settings.put("Connection", "Keep-Alive");
		settings.put("Cache-Control", "no-cache");
		
		hu.setResponseBody(new ResponseBodyString());
		hu.request(protocol, targetUrl, settings, new HashMap(), files);
		
		System.out.println("Post Request - Response Result ");
		System.out.println(hu.getResponseBody().getResult());
		
	}
	
}
