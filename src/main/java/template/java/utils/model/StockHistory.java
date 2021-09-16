package template.java.utils.model;

import java.util.Date;

public class StockHistory {
	
	private int stockHistoryNo;
	private int count;
	private Date receivingDate;
	
	public int getStockHistoryNo() {
		return stockHistoryNo;
	}
	public void setStockHistoryNo(int stockHistoryNo) {
		this.stockHistoryNo = stockHistoryNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getReceivingDate() {
		return receivingDate;
	}
	
	public void setReceivingDate(Date receivingDate) {
		this.receivingDate = receivingDate;
	}
	
	@Override
	public String toString() {
		return "StockHistory [stockHistoryNo=" + stockHistoryNo + ", count=" + count + ", receivingDate="
				+ receivingDate + "]";
	}
	
}
