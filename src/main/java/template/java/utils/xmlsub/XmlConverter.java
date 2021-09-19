package template.java.utils.xmlsub;

import java.text.ParseException;

import org.jdom2.Element;

public interface XmlConverter {

	public String objToXml(Object obj);
	public Element makeXmlElement(Object element);
	public boolean xmlToObj(String tagName, String value, Object obj) throws ParseException;
	public void resetCount();
	
}
