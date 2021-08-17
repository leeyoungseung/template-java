package template.java.str;

import java.util.ArrayList;
import java.util.List;

import template.java.utils.StrUtil;

public class Str_02_AppendStr {

	public static void main(String[] args) {
		// Prepare data
		String [] exArray01 = new String [] {"test1","test2","test3","test4"};
		String [] exArray02 = new String [] {"test5","test6","test7","test8"};
		
		List<String> exList01 = inputValueInList(exArray01);
		List<String> exList02 = inputValueInList(exArray02);
		
		// Append String
		StrUtil util = new StrUtil();
		System.out.println("---------- Start ----------");
		
		System.out.println("---------- (1) makeRecodeStrCsvFormat Using Array----------");
		System.out.println(util.makeRecodeStrCsvFormat(exArray01));
		System.out.println(util.makeRecordStr(" ", exArray02));
		
		
		System.out.println("---------- (2) makeRecodeStrCsvFormat Using List----------");
		System.out.println(util.makeRecodeStrCsvFormat(exList01));
		System.out.println(util.makeRecordStr(" ", exList02));
		

		
		
	}
	
	
	public static List<String> inputValueInList(String [] strs) {
		List<String> tempList = new ArrayList<String>();
		
		for (String str : strs) {
			tempList.add(str);
		}
		
		for (String str : tempList) {
			System.out.println(str);
		}
		
		return tempList;
	}
}
