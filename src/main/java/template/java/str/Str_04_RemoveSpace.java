package template.java.str;

import template.java.utils.StrUtil;

public class Str_04_RemoveSpace {
	
	public static void main(String[] args) {
		StrUtil su = new StrUtil();
		
		String halfSpaceCheckText = "1.It is text for testing";    //공백 스페이스 반각
		String fullSpaceCheckText = "2.It　is　text　for　testing"; //공백 스페이스 전각
		String bothSpaceCheckText = "3.It is text　for　testing";  //공백 스페이스 반각 / 전각
		
		
		System.out.println(bothSpaceCheckText.replaceAll(" ","")); // 반각만 제거
		System.out.println(bothSpaceCheckText.replaceAll("　",""));// 전각만 제거 
		
		System.out.println("Before : " + halfSpaceCheckText);
		System.out.println("After  : " + su.deleteAllSpace(halfSpaceCheckText));
		System.out.println("Before : " + fullSpaceCheckText);
		System.out.println("After  : " + su.deleteAllSpace(fullSpaceCheckText));
		System.out.println("Before : " + bothSpaceCheckText);
		System.out.println("After  : " + su.deleteAllSpace(bothSpaceCheckText));
		
	}

}
