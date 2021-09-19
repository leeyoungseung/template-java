package template.java.utils.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Item {

	private int itemId;
	private String itemName;
	private int itemPrice;
	private boolean sales;
	private List<String> images;
	private List<StockHistory> stockHistories;
	private String joinDate;
	
	
	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}


	public boolean isSales() {
		return sales;
	}


	public void setSales(boolean sales) {
		this.sales = sales;
	}


	public List<String> getImages() {
		if (images == null) images = new ArrayList<String>();
		return images;
	}


	public void setImages(List<String> images) {
		this.images = images;
	}


	public List<StockHistory> getStockHistories() {
		if (stockHistories == null) stockHistories = new ArrayList<StockHistory>();
		return stockHistories;
	}


	public void setStockHistories(List<StockHistory> stockHistories) {
		this.stockHistories = stockHistories;
	}


	public String getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}


	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", sales=" + sales
				+ ", images=" + images + ", stockHistories=" + stockHistories + ", joinDate=" + joinDate + "]";
	}
	
	
}
