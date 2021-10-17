package template.java.data;

import template.java.utils.DateUtil;

public class Data_05_Date {
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			
			String testStr1 = "20191203";
			String testStr2 = "2021-10-17 13:23:35";
			String testStr3 = "1631929893268";
			
			DateUtil du = DateUtil.getInstance();
			
			System.out.println("---------- (1) 현재시간을 지정한 날짜시간 포맷의 문자열로 변환 ---------- ");
			System.out.println(du.getNowStr(DateUtil.FORMAT_3));
			System.out.println(du.getNowStr(DateUtil.FORMAT_7));
			System.out.println();
			
			
			System.out.println("---------- (2) 날짜시간 데이터를 날짜시간 포맷의 문자열로 변환  ---------- ");
			System.out.println(testStr1 + " -> "+ du.getDateStr(du.getDate(testStr1, DateUtil.FORMAT_1), DateUtil.FORMAT_3));
			System.out.println(testStr2 + " -> "+ du.getDateStr(du.getDate(testStr2, DateUtil.FORMAT_1), DateUtil.FORMAT_7));
			System.out.println();
			
			
			System.out.println("---------- (3) 타임스탬프를 날짜시간 포맷의 문자열로 변환  ---------- ");
			System.out.println(testStr3 + " -> "+ du.getDateStr(Long.parseLong(testStr3), DateUtil.FORMAT_4));
			System.out.println(testStr3 + " -> "+ du.getDateStr(Long.parseLong(testStr3), DateUtil.FORMAT_8));
			System.out.println();
			
			
			System.out.println("---------- (4) 날짜시간 포맷의 문자열을 타임스탬프로 변환  ---------- ");
			System.out.println(testStr2 + " -> "+ du.getTimeStamp(testStr2, DateUtil.FORMAT_7));
			System.out.println(testStr1 + " -> "+ du.getTimeStamp(testStr1, DateUtil.FORMAT_1));
			System.out.println();
			
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
