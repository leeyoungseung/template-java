package template.java.utils.model;

public class StockHistory {
	
	private int stockHistoryNo;
	private int count;
	private String receivingDate;
	
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
	public String getReceivingDate() {
		return receivingDate;
	}
	
	public void setReceivingDate(String receivingDate) {
		this.receivingDate = receivingDate;
	}
	
	@Override
	public String toString() {
		return "StockHistory [stockHistoryNo=" + stockHistoryNo + ", count=" + count + ", receivingDate="
				+ receivingDate + "]";
	}
	
}
