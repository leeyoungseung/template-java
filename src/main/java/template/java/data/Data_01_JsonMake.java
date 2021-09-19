package template.java.data;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import template.java.utils.FileUtil;
import template.java.utils.JsonUtil;
import template.java.utils.model.Item;
import template.java.utils.model.StockHistory;

public class Data_01_JsonMake {

	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	static JsonUtil ju = JsonUtil.getInstance();
	static FileUtil fu = FileUtil.getInstance();
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}

			/**
			 * Object -> JSON
			 */
			Item item = getItem(0);
			ju.ObjToJson(item, args[0]);
			System.out.println(fu.readPerLine(new File(args[0])));
			
			
			/**
			 * List<Object지정> -> JSON 리스트
			 */
			List<Item> items = getItems();
			// (1)
//			String jsonContents = ju.ObjToJson(items);
//			makeJson(args[1], jsonContents);
//			System.out.println(jsonContents);
			
			// (2)
			ju.ObjToJson(items, args[1]);
			System.out.println(fu.readPerLine(new File(args[1])));
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	private static void makeJson(String path, String ...strs) {
		
		List<String> jsonFileContents = Arrays.asList(strs);
		fu.writePerLine(new File(path), jsonFileContents);
	}
	
	
	private static Item getItem(int i) {
		Item item = new Item();
		item.setItemId(i);
		item.setItemName("testItem"+i);
		item.setItemPrice(Integer.parseInt(i+"000"));
		item.setSales(true);
		
		List<String> itemImages = new ArrayList<String>();
		for (int z=1; z<=3; z++) {
			itemImages.add("testItem-img"+z+".png");
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
