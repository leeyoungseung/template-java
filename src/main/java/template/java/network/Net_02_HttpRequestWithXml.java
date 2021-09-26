package template.java.network;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import template.java.utils.HttpUtil;
import template.java.utils.XmlUtil;
import template.java.utils.networksub.RequestBodyJson;
import template.java.utils.networksub.ResponseBodyJson;
import template.java.utils.networksub.ResponseBodyXml;

public class Net_02_HttpRequestWithXml {

	static HttpUtil hu = HttpUtil.getInstance();
	static XmlUtil xu = XmlUtil.getInstance();
	static String apiUrl = "http://localhost:8080/api/items";
	static String resultFileDir = "C:\\Users\\leeyoungseung\\project_source\\template-java\\result\\file\\api-res-xml";
	
	public static void main(String[] args) {
		
		try {
			// (1) GET Request를 송신하여 현재의 전체데이터를 가져오기 
			String resultXml = getRequest();
			System.out.println("(1) GET Request Result : "+ resultXml);
			JsonNode jsonNode = xu.getXmlNode(resultXml);
			int lastItemNum = jsonNode.get("item").get("itemId").asInt();
			System.out.println("Last Item Num : "+ lastItemNum);

			
			// (2) 가장 마지막 번호에서 번호를 증가하여 POST Request를 송신해서 데이터 생성
			int nextNum = lastItemNum + 1;
			String postJsonString = "<item>"
					+ "<itemName>ItemName"+nextNum+"</itemName>"
					+ "<itemDescription>itemDescription"+nextNum+"</itemDescription>"
					+ "<makerCode>120</makerCode>"
					+ "<price>1000"+nextNum+"</price>"
					+ "<saleStatus>0</saleStatus>"
					+ "<images/>"
					+ "</item>";
			
			int newItemNo = postRequest(postJsonString);
			System.out.println("New Item Num : "+ newItemNo);
			
			
			// (3) (2)에서 생성한 데이터의 내용을 PUT Request로 데이터 갱신
			String putJsonString = "<item>"
					+ "<itemName>ItemName"+nextNum+"</itemName>"
					+ "<itemDescription>Update-itemDescription"+nextNum+"</itemDescription>"
					+ "<makerCode>120</makerCode>"
					+ "<price>1000"+(nextNum * 10)+"</price>"
					+ "<saleStatus>0</saleStatus>"
					+ "<images/>"
					+ "</item>";
			
			putRequest(newItemNo, putJsonString);
			
			// GET Request를 송신하여 데이터가 갱신되었는지 확인
			resultXml = getRequest(newItemNo);
			System.out.println("Update Check : "+ resultXml);
			
			// (4) (3)에서 갱신한 데이터의 내용을 DELETE Request로 데이터 삭제
			deleteRequest(newItemNo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getRequest() throws IOException {
		return getRequest(null);
	}
	
	
	public static String getRequest(Integer itemNo) throws IOException {
		// HttpURLConnection의 사양상 Request Body에 데이터가 있다면, Method를 GET로 설정한다고 할지라도 POST Request를 보내버리므로 NULL값을 설정해준다.
		if (hu.getRequestBody() != null) hu.setRequestBody(null);
		if (hu.getFormData() != null) hu.setFormData(null); 
			
		String protocol = "http";
		String targetUrl = (itemNo == null) 
				? apiUrl 
				: apiUrl+"/"+itemNo;
		System.out.println("URL : "+targetUrl);
		Map<String, String> settings = new HashMap<String, String>();
		
		settings.put("Method", "GET");
		settings.put("HOST", "localhost:8080");
		settings.put("User-Agent", "Java-Client");
		settings.put("Accept", "application/xml");
		
		hu.setResponseBody(new ResponseBodyJson());
		hu.request(protocol, targetUrl, settings);
		String saveFilePath = (itemNo == null) 
				? resultFileDir+"/getResult"+itemNo+".xml" 
				: resultFileDir+"/getResult.xml";
		hu.getResponseBody().saveResultToFile(saveFilePath);
		
		return (String) hu.getResponseBody().getResult();
	}
	
	
	public static int postRequest(String postJson) throws UnsupportedEncodingException, IOException {
		System.out.println("POST Request Body JSON = "+postJson);
		hu.setRequestBody(new RequestBodyJson(postJson));
		
		String protocol = "http";
		String targetUrl = apiUrl;
		System.out.println("URL : "+targetUrl);
		Map<String, String> settings = new HashMap<String, String>();
		
		settings.put("Method", "POST");
		settings.put("HOST", "localhost:8080");
		settings.put("User-Agent", "Java-Client");
		settings.put("Accept", "application/xml");
		settings.put("Content-Type", "application/xml; utf-8");
		
		hu.setResponseBody(new ResponseBodyXml());
		hu.request(protocol, targetUrl, settings);
		
		System.out.println("Post Request - Response Result ");
		System.out.println(hu.getResponseBody().getResult());
		String result = (String)hu.getResponseBody().getResult();
		String newItemId = result.replaceAll("[^\\d]", "");
		return Integer.parseInt(newItemId);
	}
	
	
	public static void putRequest(int itemId, String putJson) throws UnsupportedEncodingException, IOException {
		System.out.println("PUT Request Body JSON = "+putJson);
		hu.setRequestBody(new RequestBodyJson(putJson));
		String protocol = "http";
		String targetUrl = apiUrl+"/"+itemId;
		System.out.println("URL : "+targetUrl);
		Map<String, String> settings = new HashMap<String, String>();
		
		settings.put("Method", "PUT");
		settings.put("HOST", "localhost:8080");
		settings.put("User-Agent", "Java-Client");
		settings.put("Accept", "application/xml");
		settings.put("Content-Type", "application/xml; utf-8");
		
		hu.setResponseBody(new ResponseBodyXml());
		hu.request(protocol, targetUrl, settings);
		String saveFilePath = resultFileDir+"/putResult"+itemId+".xml";
		hu.getResponseBody().saveResultToFile(saveFilePath);
		
		System.out.println("PUT Request - Response Result ");
		System.out.println(hu.getResponseBody().getResult());
	}
	
	
	public static void deleteRequest(int itemId) throws IOException {
		String protocol = "http";
		String targetUrl = apiUrl+"/"+itemId;
		System.out.println("URL : "+targetUrl);
		Map<String, String> settings = new HashMap<String, String>();
		
		settings.put("Method", "DELETE");
		settings.put("HOST", "localhost:8080");
		settings.put("User-Agent", "Java-Client");
		settings.put("Accept", "*/*");
		settings.put("Content-Type", "application/xml; utf-8");
		
		hu.setResponseBody(new ResponseBodyXml());
		hu.request(protocol, targetUrl, settings);
		
		System.out.println("DELETE Request - Response Result ");
		System.out.println(hu.getResponseBody().getResult());
	}
}
