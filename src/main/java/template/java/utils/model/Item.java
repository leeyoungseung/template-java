package template.java.utils.model;

import java.util.Date;
import java.util.List;

public class Item {

	private int itemId;
	private String itemName;
	private int itemPrice;
	private boolean sales;
	private List<String> images;
	private List<StockHistory> stockHistory;
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
		return images;
	}


	public void setImages(List<String> images) {
		this.images = images;
	}


	public List<StockHistory> getStockHistory() {
		return stockHistory;
	}


	public void setStockHistory(List<StockHistory> stockHistory) {
		this.stockHistory = stockHistory;
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
				+ ", images=" + images + ", stockHistory=" + stockHistory + ", joinDate=" + joinDate + "]";
	}
	
	
}
