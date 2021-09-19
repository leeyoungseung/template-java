package template.java.utils.xmlsub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import template.java.utils.model.Item;
import template.java.utils.model.StockHistory;

public class XmlConverterItem implements XmlConverter {

	public boolean prettyFormat = false;
	
	public boolean isPrettyFormat() {
		return prettyFormat;
	}

	public void setPrettyFormat(boolean prettyFormat) {
		this.prettyFormat = prettyFormat;
	}

	public Format fm = (this.prettyFormat) ? Format.getPrettyFormat() : Format.getCompactFormat();
	
	protected Document doc = null;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Item 클래스의 객체 -> XML 문자열
	 */
	@Override
	public String objToXml(Object obj) {
		if (obj == null || !(obj instanceof Item)) return null;
		Item item = (Item) obj;
		Element rootEl = new Element("root");
		this.doc = new Document(rootEl);
		
		Element itemContents = makeXmlElement(item);
		this.doc.getRootElement().addContent(itemContents);
		
		fm.setEncoding("UTF-8");
		XMLOutputter output = new XMLOutputter(fm);
		return output.outputString(doc);
	}
	
	
	/**
	 * Item 클래스의 객체 -> XML형식 Element 객체
	 * @param item
	 * @return
	 */
	@Override
	public Element makeXmlElement(Object element) {
		Item item = (Item) element;
		
		Element itemContents = new Element("item");
		itemContents.addContent(new Element("itemId").addContent(String.valueOf(item.getItemId())));
		itemContents.addContent(new Element("itemName").addContent(item.getItemName()));
		itemContents.addContent(new Element("itemPrice").addContent(String.valueOf(item.getItemPrice())));
		itemContents.addContent(new Element("sales").addContent(String.valueOf(item.isSales())));
		
		Element imagesContents = new Element("images");
		for (String image : item.getImages()) {
			Element imageContents = new Element("image");
			imageContents.addContent(image);
			imagesContents.addContent(imageContents);
		}
		itemContents.addContent(imagesContents);
		
		Element historiesContents = new Element("stockHistories");
		for (StockHistory stock : item.getStockHistories()) {
			Element stockHistoryContents = new Element("stockHistory");
			stockHistoryContents.addContent(new Element("stockHistoryNo").addContent(String.valueOf(stock.getStockHistoryNo())));
			stockHistoryContents.addContent(new Element("count").addContent(String.valueOf(stock.getCount())));
			stockHistoryContents.addContent(new Element("receivingDate").addContent(String.valueOf(stock.getReceivingDate())));
			historiesContents.addContent(stockHistoryContents);
		}
		itemContents.addContent(historiesContents);
		itemContents.addContent(new Element("joinDate").addContent(item.getJoinDate()));
		
		return itemContents;
	}

	
	protected int historyCount = 0;
	
	
	@Override
	public boolean xmlToObj(String tagName, String value, Object obj) throws ParseException {
		if (value == null) return false;
		
		//System.out.println(historyCount+" = Element Name : ["+tagName+"], Value : ["+value+"]");
		
		Item item = (Item) obj;
		
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
			historyCount = 0;
			break;
		case "joinDate":
			item.setJoinDate(value);
			break;
		default : 
			return false;
		}
		
		return true;
	}

	@Override
	public void resetCount() {
		this.historyCount = 0;
	}
	
}
