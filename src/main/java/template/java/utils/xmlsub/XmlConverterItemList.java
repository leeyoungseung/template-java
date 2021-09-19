package template.java.utils.xmlsub;

import java.text.ParseException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import template.java.utils.model.Item;
import template.java.utils.model.StockHistory;

public class XmlConverterItemList extends XmlConverterItem {

	/**
	 * List<Item> -> XML 문자열
	 */
	@Override
	public String objToXml(Object obj) {
		if (obj == null) return null;
		
		List<Item> itemList = (List<Item>)obj;
		Element rootEl = new Element("root");
		this.doc = new Document(rootEl);
		
		Element itemsContents = new Element("items");
		for (Item item : itemList) {
			itemsContents.addContent(makeXmlElement(item));
		}
		this.doc.getRootElement().addContent(itemsContents);
		
		fm.setEncoding("UTF-8");
		XMLOutputter output = new XMLOutputter(fm);
		return output.outputString(doc);
	}
	
	
	protected int count = 0;
	
	
	@Override
	public boolean xmlToObj(String tagName, String value, Object obj) throws ParseException {
		if (value == null) return false;
		
		//System.out.println(count+" = Element Name : ["+tagName+"], Value : ["+value+"]");
		
		List<Item> items = (List<Item>) obj;
		Item item;
		
		try {
			item = items.get(count);
		} catch (Exception e) {
			item = new Item();
			items.add(count, item);
		}
		
		switch (tagName) {
		case "itemId":
			item.setItemId(Integer.parseInt(value));
			break;
		case "itemName":
			item.setItemName(value);
			break;
		case "itemPrice":
			item.setItemPrice(Integer.parseInt(value));
			break;
		case "sales":
			item.setSales(Boolean.parseBoolean(value));
			break;
		case "image" :
			item.getImages().add(value);
			break;
		case "stockHistoryNo":
			StockHistory stock = new StockHistory();
			stock.setStockHistoryNo(Integer.parseInt(value));
			item.getStockHistories().add(historyCount, stock);
			break;
		case "count":
			item.getStockHistories().get(historyCount).setCount(Integer.parseInt(value));
			break;
		case "receivingDate":
			item.getStockHistories().get(historyCount).setReceivingDate(value);
			break;
		case "joinDate":
			item.setJoinDate(value);
			count++;
			break;
		default : 
			return false;
		}
		
		return true;
	}
	
	
	@Override
	public void resetCount() {
		super.historyCount = 0;
		this.count = 0;
	}
}
