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

	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			
			List<Item> items = getItems();
			JsonUtil ju = JsonUtil.getInstance();
			
			String jsonContents = ju.makeJsonFromObj(items);
			System.out.println(jsonContents);
			
			
			makeJson(args[0], jsonContents);
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	private static void makeJson(String path, String ...strs) {
		FileUtil fu = new FileUtil();
		List<String> jsonFileContents = Arrays.asList(strs);
		fu.writePerLine(new File(path), jsonFileContents);
	}
	

	private static List<Item> getItems() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		
		List<Item> list = new ArrayList<Item>();
		for (int i=1; i<=3; i++) {
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
				sh.setReceivingDate(new Date());
				itemStocks.add(sh);
			}
			item.setStockHistory(itemStocks);
			
			item.setJoinDate(format.format(new Date()));
			list.add(item);
		}

		return list;
	}
}
