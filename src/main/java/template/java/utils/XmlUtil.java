package template.java.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import template.java.utils.xmlsub.XmlConverter;
import template.java.utils.xmlsub.XmlToObj;

/**
 * XML 데이터를 지정한 클래스(데이터를 담기위한 클래스) 형식으로 파싱, 
 * 또는  지정한 클래스에 담긴 데이터를 XML형식으로 변환해주는 유틸클래스.
 * 이 코드를 사용하기 위해선 build.gradle에 아래의 의존성을 추가해주어야한다.
 * // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
 * implementation group: 'com.fasterxml.jackson.dataformat', name: 'jackson-dataformat-xml', version: '2.11.2'
 * 
 * @author lee-y
 *
 */
public class XmlUtil {
	
	private XmlUtil() {};
	
	public static XmlUtil getInstance() {
		return XmlUtilHolder.INSTANCE;
	}
	
	private static class XmlUtilHolder {
		private static final XmlUtil INSTANCE = new XmlUtil();
	}
	
	final private XmlMapper mapper = new XmlMapper();
	
	public XmlMapper getObjectMapper() {
		return this.mapper;
	}
	
	private XmlConverter xmlConverter;

	public void setObjToXml(XmlConverter xmlConverter) {
		this.xmlConverter = xmlConverter;
	}

	private FileUtil fu = FileUtil.getInstance();
	
	/**
	 * Object -> XML Str
	 * 
	 * @param obj : : XML로 변환하기 위한 데이터 클래스
	 * @return : XML 문자열을 리턴한다.
	 */
	public String ObjToUseMapper(Object obj) {
		if (obj == null) return null;
		
		String res = null;
		
		try {
			res =  mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * Object -> XML File
	 * 
	 * @param obj : Xml으로 변환하기 위한 데이터 클래스
	 * @param filePath : 출력할 XML파일 경로
	 * @return : 생성된 파일 객체 리턴
	 */
	public File ObjToXmlUseMapper(Object obj, String filePath) {
		if (obj == null || filePath == null || filePath.equals("")) return null;
		
		File f = null;
		
		try {
			f = new File(filePath);
			mapper.writeValue(f, obj);
			
		} catch (IOException ie) { ie.printStackTrace(); }
		
		return f;
	}
	
	
	
	/**
	 * Object -> XML Str
	 * 
	 * @param obj : : XML로 변환하기 위한 데이터 클래스
	 * @return : xml 문자열을 리턴한다.
	 */
	public String ObjToXml(Object obj) {
		if (obj == null) return null;
		
		String res = null;
		
		try {
			res = this.xmlConverter.objToXml(obj);
		} catch (Exception e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * Object -> XML File
	 * 
	 * @param obj : XML로 변환하기 위한 데이터 클래스
	 * @param filePath : 출력할 XML 파일경로
	 * @return : xml 문자열을 리턴한다.
	 */
	public File ObjToXml(Object obj, String filePath) {
		return ObjToXml(obj, new File(filePath));
	}
	
	
	/**
	 * Object -> XML File
	 * 
	 * @param obj : XML로 변환하기 위한 데이터 클래스
	 * @param filePath : 출력할 XML 파일경로
	 * @return : xml 문자열을 리턴한다.
	 */
	public File ObjToXml(Object obj, File file) {
		if (obj == null) return null;
		
		try {
			String resStr = this.xmlConverter.objToXml(obj);
			if (!fu.write(file, resStr)) {
				file = null;
			}
		} catch (Exception e) { e.printStackTrace(); }
		
		return file;
	}
	
	
	/**
	 * XML Str -> Object One
	 * 
	 * @param xml     : 파싱할 XML 문자열
	 * @param template : 파싱한 데이터를 담기위한 클래스
	 * @return
	 */
	public Object xmlToObj(String xml, Class<?> template) {
		if (xml == null) return null;
		
		Object res = null;
		
		try {
		    res = mapper.readValue(xml, template);
		} catch (JsonProcessingException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * XML File -> Object One
	 * 
	 * @param xmlFilePath     : 파싱할 xml파일
	 * @param template : 파싱한 데이터를 담기위한 클래스
	 * @return
	 */
	public Object xmlToObj(File xmlFilePath, Class<?> template) {
		if (xmlFilePath == null) return null;
		
		Object res = null;
		
		try {
			res = mapper.readValue(xmlFilePath, template);

		} catch (JsonProcessingException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * JSON List / Map 등의 묶음 데이터 -> List<Object>, Map<String, Object>로 변환
	 * 기능확장이 필요하다면 JsonToObj를 구현한 클래스를 생성하여 대응한다.
	 * 
	 * @param xml         : 파싱할 xml 문자열
	 * @param xmlToObj     : 파싱할 형식을 지정
	 * @return
	 */
	public Object xmlListToObjList(String xml, XmlToObj xmlToObj) {
		if (xml == null) return null;
		
		Object res = null;
		
		try {
			res = mapper.readValue(xml, xmlToObj.getTypeReference());

		} catch (JsonProcessingException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	
	/**
	 * JSON List / Map 등의 묶음 데이터 -> List<Object>, Map<String, Object>로 변환
	 * 기능확장이 필요하다면 JsonToObj를 구현한 클래스를 생성하여 대응한다.
	 * 
	 * @param xmlFile         : 파싱할 xml 파일
	 * @param xmlToObj     : 파싱할 형식을 지정
	 * @return
	 */
	public Object xmlListToObjList(File xmlFile, XmlToObj xmlToObj) {
		if (xmlFile == null) return null;
		
		Object res = null;
		
		try {
			res = mapper.readValue(xmlFile, xmlToObj.getTypeReference());

		} catch (JsonProcessingException e) { e.printStackTrace(); 
		} catch (IOException e) { e.printStackTrace(); }
		
		return res;
	}
	
	
	/**
	 * XML 데이터를 받아 파싱하여 지정한 Object에 데이터를 매핑한다.
	 * 
	 * @param targetFile : 파싱 대상 XML 파일
	 * @param obj    : 파싱한 데이터를 담기위한 클래스
	 * @return
	 */
	public Object parser(File targetFile, Object obj) {
		List<String> xmlListData = fu.readPerLine(targetFile);
		StringBuffer sb = new StringBuffer();
		for (String str : xmlListData) {
			sb.append(str);
		}
		return parser(sb.toString(), obj);
	}
	
	
	/**
	 * XML 데이터를 받아 파싱하여 지정한 Object에 데이터를 매핑한다.
	 * 
	 * @param target : 파싱 대상 XML
	 * @param obj    : 파싱한 데이터를 담기위한 클래스
	 * @return
	 */
	public Object parser(String target, Object obj) {
		
		SAXBuilder builder = new SAXBuilder();
		InputStream xmlInput = new ByteArrayInputStream(target.getBytes());
		
		Document doc;
		Element el;
		try {
			doc = builder.build(xmlInput, "UTF-8");
			el = doc.getRootElement();
			getObject(el, obj);
			
		} catch (JDOMException e) { e.printStackTrace();
		} catch (IOException e) { e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace(); }
		
		this.xmlConverter.resetCount();
		return obj;
	}
	
	/**
	 * XML데이터를 파싱하기 위한 메소드.
	 * 재귀방식으로 동작함.
	 * 
	 * @param el  : String 형식의 XML데이터를 Element형식으로 변환한것.
	 * @param obj : 파싱한 데이터를 담기위한 클래스
	 */
	public void getObject(Element el, Object obj) throws ParseException {
		
		int countInFirstRoop = 0;
		List<?> childList = el.getChildren();
		Iterator<?> childItr = childList.iterator();
		
		while(childItr.hasNext()) {
			countInFirstRoop++;
			Element childEl = (Element)childItr.next();
			String elName = new String(childEl.getName());
			List<?> grandChildList = childEl.getChildren();
			Iterator<?> grandChildItr = grandChildList.iterator();
			
			if (grandChildItr.hasNext()) {
				getObject(childEl, obj);
				
			} else {
				List<?> contentList = childEl.getContent();
				Iterator<?> contentItr = contentList.iterator();
				
				if (contentItr.hasNext()) {
					Content content = (Content) contentItr.next();
					
					if (!this.xmlConverter.xmlToObj(elName, content.getValue(), obj)) {
						System.err.println("Error ["+ elName+"], ["+content.getValue()+"]");
					}
					
				} else {
					System.out.println("("+countInFirstRoop+") "+elName + " : Null value");
				}
			}
			
		}
	}
	
	
}
