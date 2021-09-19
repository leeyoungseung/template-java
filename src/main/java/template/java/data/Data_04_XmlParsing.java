package template.java.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import template.java.utils.FileUtil;
import template.java.utils.XmlUtil;
import template.java.utils.jsonsub.JsonToObjItemList;
import template.java.utils.model.Item;
import template.java.utils.xmlsub.XmlConverterItem;
import template.java.utils.xmlsub.XmlConverterItemList;
import template.java.utils.xmlsub.XmlToObjItemList;

public class Data_04_XmlParsing {
	static XmlUtil xu = XmlUtil.getInstance();
	static FileUtil fu = FileUtil.getInstance();
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			
			/**
			 * XML 객체 1개 -> Object지정
			 */
			xu.setObjToXml(new XmlConverterItem());
			
			System.out.println("---------- XML One -> Object One ----------");
			// Xml Mapper를 사용하여 변환된 XML을 다시 Xml Mapper를 사용해서 Object로 변환하는 것은 가능
			Item item = (Item)xu.xmlToObj(new File(args[0]), Item.class);
			System.out.println("(1) XML Use XmlMapper -> Object : "+item.toString());
			System.out.println("");
			
			
			// SAX parser를 사용하여 XML을 파싱하여 Object에 데이터를 담는다
			Item item2 = (Item)xu.parser(new File(args[1]), new Item());
			System.out.println("(2) XML -> Object : "+item2.toString());
			System.out.println("");
			
			
			/**
			 * XML 리스트 -> List<Object지정>
			 */
			
			
			System.out.println("---------- XML List -> List<Object> ----------");
			System.out.println("(3) XML List Use XmlMapper -> List<Object>");
			Object obj = xu.xmlListToObjList(new File(args[2]), new XmlToObjItemList());
			List<Item> items = (List<Item>) obj;
			
			for	(Item itemData : items) {
				System.out.println(itemData.toString());
			}
			System.out.println("");
			
			
			System.out.println("(4) XML List -> List<Object>");
			xu.setObjToXml(new XmlConverterItemList());
			List<Item> items2 = (List<Item>)xu.parser(new File(args[3]), new ArrayList<Item>());
			for	(Item itemData : items2) {
				System.out.println(itemData.toString());
		    }
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
