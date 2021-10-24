package template.java.db;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import template.java.utils.DBUtil;
import template.java.utils.FileUtil;


public class DB_02_Insert {

	static FileUtil fu = FileUtil.getInstance();
	static DBUtil du = DBUtil.getInstance();
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			String sql = "";
			List list;
			
			// MySQL Insert SQL
		    sql = "INSERT INTO ITEM (ITEM_NAME, ITEM_DESCRIPTION, MAKER_CODE, PRICE, SALE_STATUS, UPDATED_DATE) VALUES (?,?,?,?,?,?)";
		    
		    // Set Parameter
			list = new ArrayList<Object>();
			list.add("ITEM_NAME_JDBC_05");
			list.add("ITEM_DESCRIPTION_JDBC_05");
			list.add("129");
			list.add(12000);
			list.add(0);
			list.add(new Date());
			
			// DB Connection
			getConnection(args[0]);
			
			// SQL execute
			if (du.executeUpdateSql(sql, list)) {
				System.out.println("Success Insert in MySQL!!");
			}  else {
				System.out.println("Failure Insert in MySQL!!");
			}
			
			
			// Oracle Insert SQL
			sql = "INSERT INTO ITEM (ITEM_ID, ITEM_NAME, ITEM_DESCRIPTION, MAKER_CODE, PRICE, SALE_STATUS, UPDATED_DATE) VALUES (SEQ_ITEM.NEXTVAL,?,?,?,?,?,?)";
			
			// Set Parameter
			list = new ArrayList<Object>();
			list.add("ITEM_NAME_JDBC_01");
			list.add("ITEM_DESCRIPTION_JDBC_01");
			list.add("109");
			list.add(10000);
			list.add(0);
			list.add(new Date());
			
			// DB Connection
			getConnection(args[1]);
			
			// SQL execute
			if (du.executeUpdateSql(sql, list)) {
				System.out.println("Success Insert in Oracle!!");
			}  else {
				System.out.println("Failure Insert in Oracle!!");
			}
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
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
