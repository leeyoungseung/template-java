package template.java.db;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import template.java.utils.DBUtil;
import template.java.utils.FileUtil;

public class DB_01_CheckConnection {
	
	static FileUtil fu = FileUtil.getInstance();
	static DBUtil du = DBUtil.getInstance();
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
				connectionTest(str);
			}

	
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
    public static void connectionTest(String conInfoFilePath) {
    	
		System.out.println("---------- DB Connection Test ----------");
		List<String> conInfos = fu.readPerLine(new File(conInfoFilePath));
		
		for (String str : conInfos) {
			System.out.println("ConInfo : "+str);
		}
		
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
		System.out.println();
		du.freeConnection(con);
    }
}
