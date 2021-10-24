package template.java.db;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import template.java.utils.DBUtil;
import template.java.utils.FileUtil;

public class DB_03_Select {
	static FileUtil fu = FileUtil.getInstance();
	static DBUtil du = DBUtil.getInstance();
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			String sql = "";
			List list;
			ResultSet rs;
			
			// MySQL/Oracle Select SQL
		    sql = "SELECT ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION, MAKER_CODE, PRICE, SALE_STATUS, UPDATED_DATE FROM ITEM WHERE ITEM_ID = ?";
		    
		    // Set Parameter
			list = new ArrayList<Object>();
			list.add(131);
			
			// MySQL DB Connection
			getConnection(args[0]);
			
			// SQL execute
			rs = du.executeSelectSql(sql, list);
			printDatas(rs);
			
			// Set Parameter
			list = new ArrayList<Object>();
			list.add(3);
			
			
			// Oracle DB Connection
			getConnection(args[1]);
			
			// SQL execute
			rs = du.executeSelectSql(sql, list);
			printDatas(rs);
				
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
			
	public static void printDatas(ResultSet rs) throws SQLException {
		
		while (rs.next()) {
			int itemNo = rs.getInt("ITEM_ID");
			String itemName = rs.getString("ITEM_NAME");
			String itmeDec = rs.getString("ITEM_DESCRIPTION");
			String makerCode = rs.getString("MAKER_CODE");
			int price = rs.getInt("PRICE");
			int saleStatus = rs.getInt("SALE_STATUS");
			Date updatedDate = rs.getDate("UPDATED_DATE");
			System.out.println("Print 【ITEM_NO="+itemNo+", ITEM_NAME="+itemName+", ITEM_DESCRIPTION="+itmeDec
					+", MAKER_CODE="+makerCode+", PRICE="+price+", SALE_STATUS="+saleStatus
					+", UPDATED_DATE="+updatedDate.getTime()+"】" );
		}
		
		System.out.println();
		System.out.println();
		
	}
	
    public static Connection getConnection(String conInfoFilePath) {
		List<String> conInfos = fu.readPerLine(new File(conInfoFilePath));
		
		du.setDBParam(
				conInfos.get(0),
				conInfos.get(1),
				conInfos.get(2),
				conInfos.get(3),
				conInfos.get(4),
				conInfos.get(5),
				conInfos.get(6),
				conInfos.get(7),
				conInfos.get(8),
				conInfos.get(9)
				);
		
		du.initConnection();
		Connection con = du.getConnection();
		System.out.println("Connection Info = "+con);
		return con;
    }
}
