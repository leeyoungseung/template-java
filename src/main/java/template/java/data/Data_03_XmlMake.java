package template.java.data;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import template.java.utils.FileUtil;
import template.java.utils.XmlUtil;
import template.java.utils.model.Item;
import template.java.utils.model.StockHistory;
import template.java.utils.xmlsub.XmlConverterItem;
import template.java.utils.xmlsub.XmlConverterItemList;

public class Data_03_XmlMake {
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	static XmlUtil xu = XmlUtil.getInstance();
	static FileUtil fu = FileUtil.getInstance();
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}

			/**
			 * Object -> XML , XmlMapper 사용의 경우 
			 */
			Item item1 = getItem(1);
			File itemTestMapperFile = xu.ObjToXmlUseMapper(item1, args[0]);
			System.out.println("(1) Object -> XML Use XmlMapper : "+ fu.readPerLine(itemTestMapperFile));
			System.out.println("");
			
			
			/**
			 * Object -> XML
			 */
			xu.setObjToXml(new XmlConverterItem());
			Item item2 = getItem(1);
			File xmlText02 = xu.ObjToXml(item2, args[1]);
			System.out.println("(2) Object -> XML : "+ fu.readPerLine(xmlText02));
			System.out.println("");
			
			
			/**
			 * List<Object> -> XML List
			 */
			List<Item> items = getItems();
			File itemListTestMapperFile = xu.ObjToXmlUseMapper(items, args[2]);
			System.out.println("(3) List<Object> -> XML List Use XmlMapper : "+ fu.readPerLine(itemListTestMapperFile));
			System.out.println("");
			
			
			xu.setObjToXml(new XmlConverterItemList());
			xu.ObjToXml(items, args[3]);
			System.out.println("(4) List<Object> -> XML List : "+ fu.readPerLine(new File(args[3])));
			
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	private static Item getItem(int i) {
		Item item = new Item();
		item.setItemId(i);
		item.setItemName("testItem"+i);
		item.setItemPrice(Integer.parseInt(i+"000"));
		item.setSales(true);
		
		List<String> itemImages = new ArrayList<String>();
		for (int z=1; z<=3; z++) {
			itemImages.add("testItem"+i+"-img"+z+".png");
		}
		item.setImages(itemImages);
		
		List<StockHistory> itemStocks = new ArrayList<StockHistory>();
		for (int j=1; j<=3; j++) {
			StockHistory sh = new StockHistory();
			sh.setStockHistoryNo(j);
			sh.setCount(j*2);
			sh.setReceivingDate(format.format(new Date()));
			itemStocks.add(sh);
		}
		item.setStockHistories(itemStocks);
		
		item.setJoinDate(format.format(new Date()));
		return item;
	}
	

	private static List<Item> getItems() {
		List<Item> list = new ArrayList<Item>();
		for (int i=1; i<=3; i++) {
			list.add(getItem(i));
		}
		return list;
	}
}
