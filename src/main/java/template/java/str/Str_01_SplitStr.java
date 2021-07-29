package template.java.str;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import template.java.utils.StrUtil;

public class Str_01_SplitStr {

	public static void main(String[] args) {
		StrUtil util = new StrUtil();
		
		System.out.println("---------- Start ----------");
		String example1 = "test1,test2,test3,test4,test5";
		String example2 = "test1\ttest2\ttest3\ttest4\ttest5";
		String example3 = "David";
		
		System.out.println("---------- (1) Make String Array From String split ----------");
		String [] exampleAry1 = util.makeArrayFromStr(example1);
		System.out.println(exampleAry1[1]);
		System.out.println(exampleAry1[4]);
		
		System.out.println("---------- (2) Make String ArrayList From String split ----------");
		List<String> exampleList1 = util.makeListFromStr(example1);
		listCheck(exampleList1);
		System.out.println(exampleList1);
		
		System.out.println("---------- (3) Make String LinkedList From String split ----------");
		List<String> exampleList2 = util.makeListFromStr(example2, "\\t", false);
		listCheck(exampleList2);
		System.out.println(exampleList2);
		
		System.out.println("---------- (4) Make Char Array From String ----------");
		char [] exampleAry2 = util.makeCharArry(example3);
		System.out.println(exampleAry2[1]);
		System.out.println(exampleAry2[4]);
		
		System.out.println("---------- (5) Make Character LinkedList From String ----------");
		List<Character> exampleList3 = util.makeCharList(example3, false);
		listCheck(exampleList3);
		System.out.println(exampleList3);

	}
	
	
	public static void listCheck(List<?> list) {
		if (list instanceof LinkedList<?>) {
			System.out.println("LinkedList");
		} else if (list instanceof ArrayList<?>) {
			System.out.println("ArrayList");
		} else {
			System.out.println(list.getClass().getName());
		}
	}
}
