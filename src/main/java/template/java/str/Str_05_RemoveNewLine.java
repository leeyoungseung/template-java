package template.java.str;

import template.java.utils.StrUtil;

public class Str_05_RemoveNewLine {
	
	public static void main(String[] args) {
		StrUtil su = new StrUtil();
		
		String linuxNewLineCheckText = " 1.It is text for testing \n 2.It is text for testing \n 3.It is text for testing";
		String windowsNewLineCheckText = " 4.It is text for testing \r\n 5.It is text for testing \r\n 6.It is text for testing";
		String macNewLineSpaceCheckText = " 7.It is text for testing \r 8.It is text for testing \r 9.It is text for testing";
		
		System.out.println("Before --------------------------------------------------- "); 
		System.out.println(linuxNewLineCheckText);
		System.out.println("After  --------------------------------------------------- "); 
		System.out.println(su.deleteLineSeparator(linuxNewLineCheckText));
		System.out.println("---------------------------------------------------------- "); 
		
		
		System.out.println("Before --------------------------------------------------- "); 
		System.out.println(windowsNewLineCheckText);
		System.out.println("After  --------------------------------------------------- "); 
		System.out.println(su.deleteLineSeparator(windowsNewLineCheckText));
		System.out.println("---------------------------------------------------------- "); 
		
		
		System.out.println("Before --------------------------------------------------- "); 
		System.out.println(macNewLineSpaceCheckText);
		System.out.println("After  --------------------------------------------------- "); 
		System.out.println(su.deleteLineSeparator(macNewLineSpaceCheckText));
		System.out.println("---------------------------------------------------------- "); 
		
	}

}
