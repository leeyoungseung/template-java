package template.java.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import template.java.utils.jsonsub.JsonToObj;

/**
 * JSON 데이터를 지정한 클래스(데이터를 담기위한 클래스) 형식으로 파싱, 
 * 또는  지정한 클래스에 담긴 데이터를 JSON형식으로 변환해주는 유틸클래스.
 * 대용량 JSON데이터를 처리하는데 있어 유리한 jackson-databind를 사용했다.
 * 이 코드를 사용하기 위해선 build.gradle에 아래의 의존성을 추가해주어야한다.
 * // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
 * compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.11.2'
 * 
 * @author lee-y
 *
 */
public class JsonUtil {

	final private ObjectMapper mapper = new ObjectMapper();
	
	public ObjectMapper getObjectMapper() {
		return this.mapper;
	}
	
	private JsonUtil() {};
	
	public static JsonUtil getInstance() {
		return JsonUtilHolder.INSTANCE;
	}
	
	private static class JsonUtilHolder {
		private static final JsonUtil INSTANCE = new JsonUtil();
	}
	
	
	/**
	 * Object -> JSON Str
	 * 
	 * @param obj : : Json으로 변환하기 위한 데이터 클래스
	 * @return : Json 문자열을 리턴한다.
	 */
	public String ObjToJson(Object obj) {
		if (obj == null) return null;
		
		String res = null;
		
		try {
			res =  mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * Object -> JSON File
	 * 
	 * @param obj : Json으로 변환하기 위한 데이터 클래스
	 * @param filePath : 출력할 JSON파일 경로
	 * @return : 생성된 파일 객체 리턴
	 */
	public File ObjToJson(Object obj, String filePath) {
		if (obj == null || filePath == null || filePath.equals("")) return null;
		
		File f = null;
		
		try {
			f = new File(filePath);
			mapper.writeValue(f, obj);
			
		} catch (IOException ie) { ie.printStackTrace(); }
		
		return f;
	}
	
	
	/**
	 * JSON Str -> JsonNode
	 * 
	 * @param json     : 파싱할 Json 문자열 데이터
	 * @return
	 */
	public JsonNode getJsonNode(String json) {
		if (json == null) return null;
		
		JsonNode res = null;
		
		try {
		    res = mapper.readTree(new File(json));
		} catch (JsonProcessingException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * JSON Str -> JsonNode
	 * 
	 * @param json     : 파싱할 Json 파일
	 * @return
	 */
	public JsonNode getJsonNode(File json) {
		if (json == null) return null;
		
		JsonNode res = null;
		
		try {
		    res = mapper.readTree(json);
		} catch (JsonProcessingException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * JSON Str -> Object One
	 * 
	 * @param json     : 파싱할 Json 문자열
	 * @param template : 파싱한 데이터를 담기위한 클래스
	 * @return
	 */
	public Object jsonToObj(String json, Class<?> template) {
		if (json == null) return null;
		
		Object res = null;
		
		try {
		    res = mapper.readValue(json, template);
		} catch (JsonProcessingException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * JSON File -> Object One
	 * 
	 * @param jsonFilePath     : 파싱할 Json파일
	 * @param template : 파싱한 데이터를 담기위한 클래스
	 * @return
	 */
	public Object jsonToObj(File jsonFilePath, Class<?> template) {
		if (jsonFilePath == null) return null;
		
		Object res = null;
		
		try {
			res = mapper.readValue(jsonFilePath, template);

		} catch (JsonProcessingException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * JSON List / Map 등의 묶음 데이터 -> List<Object>, Map<String, Object>로 변환
	 * 기능확장이 필요하다면 JsonToObj를 구현한 클래스를 생성하여 대응한다.
	 * 
	 * @param json          : 파싱할 Json 문자열
	 * @param JsonToObj     : 파싱할 형식을 지정
	 * @return
	 */
	public Object jsonListToObjList(String json, JsonToObj jsonToObj) {
		if (json == null) return null;
		
		Object res = null;
		
		try {
			res = mapper.readValue(json, jsonToObj.getTypeReference());

		} catch (JsonProcessingException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * JSON List / Map 등의 묶음 데이터 파일 -> List<Object>, Map<String, Object>로 변환   
	 * 기능확장이 필요하다면 JsonToObj를 구현한 클래스를 생성하여 대응한다.
	 * 
	 * @param jsonFile     : 파싱할 Json파일
	 * @param JsonToObj    : 파싱할 형식을 지정
	 * @return
	 */
	public Object jsonListToObjList(File jsonFile, JsonToObj jsonToObj) {
		if (jsonFile == null) return null;
		
		Object res = null;
		
		try {
			res = mapper.readValue(jsonFile, jsonToObj.getTypeReference());

		} catch (JsonProcessingException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); }
		
		return res;
	}
	

	/**
	 * 지정한 데이터 클래스에 담긴 데이터를 Json형식의 byte[]데이터로 변환해주는 기능.
	 * 
	 * @param obj : : Json으로 변환하기 위한 데이터 클래스
	 * @return : byte[]를 리턴한다.
	 */
	public byte [] makeJsonByteFromObj(Object obj) {
		if (obj == null) return null;
		
		byte [] res = null;
		
		try {
			res =  mapper.writeValueAsBytes(obj);
		} catch (JsonProcessingException e) { e.printStackTrace(); }
		
		return res;
	}
	
}
