package template.java.str;

import template.java.utils.StrUtil;

public class Str_03_SearchWord {

	public static void main(String[] args) {
		StrUtil su = new StrUtil();
		String ex1 = "hello||test1||String||test2,,test3";
		String ex2 = "hello";
		String pattern1 = "hello";
		String pattern2 = ".*hello.*";
		String pattern3 = ".*[a-z]{4,5}.*";
		String pattern4 = "test[0-9]";

		// 문자열 검색
		System.out.println("Search1 :"+su.hasStrInTarget(ex1, pattern1));
		System.out.println("Search2 :"+su.isMatch(ex1, pattern1));     // Pattern이 일치하지 않으니 false
		System.out.println("Search3 :"+su.isMatch(ex2, pattern1));     // Pattern이 일치하므로 true
		System.out.println("Search4 :"+su.isMatch(ex1, pattern2));    // Pattern이 일치하므로 않으니 true
		System.out.println("Search5 :"+su.isMatch(ex1, pattern3));    // Pattern이 일치하므로 않으니 true
		
		// 위치 찾기 
		int res[] = su.getFindStrIndexsInTarget(ex1, pattern1);
		System.out.println("Search6 :"+res[0] +", "+ res[1]);
		
		// 문자열 검색 결과 모두 가져오기 
		System.out.println("Search7 :"+su.getMatchedStrs(ex1, pattern4));
		
	}
}
