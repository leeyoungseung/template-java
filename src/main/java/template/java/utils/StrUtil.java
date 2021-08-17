package template.java.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StrUtil {

	
	/**
	 * Null 또는 공백이면 true, 아니면 false를 리턴. 
	 * return true if str is Null or empty.
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNullOrEmpty(String str) {
		if (str == null || str.trim().equals("") || str.isEmpty())
			return true;
		else
			return false;
	}

	
	/**
	 * 구분자를 기준으로 입력한 문자열을 자른 문자열의 리스트를 리턴하는 메소드 
	 * This method return a List of String
	 * that split String entered based on separator.
	 * 
	 * @param str
	 * @param separator
	 * @param isArrayList : Return ArrayList if it is true, Return LinkedList if it is false.
	 * @return List or Null
	 */
	public List<String> makeListFromStr(String str, String separator, boolean isArrayList) {
		if (isNullOrEmpty(separator) || isNullOrEmpty(str))
			return null;

		List<String> res = isArrayList 
				? new ArrayList<String>(Arrays.asList(str.split(separator)))
				: new LinkedList<String>(Arrays.asList(str.split(separator)));

		if (res != null && 0 < res.size())
			return res;
		else
			return null;
	}

	
	/**
	 * 구분자를 기준으로 입력한 문자열을 자른 문자열의 리스트를 리턴하는 메소드 주로 .csv 파일을 다룰때 사용.
	 * This method is used by when to handle CSV file mainly.
	 * 
	 * @param str
	 * @return
	 */
	public List<String> makeListFromStr(String str) {
		return makeListFromStr(str, ",", true);
	}
	
	
	/**
	 * 구분자를 기준으로 입력한 문자열을 자른 문자열의 배열을 리턴하는 메소드
	 * This method return an Array of String that split String entered based on separator.
	 * 
	 * @param separator
	 * @param targetStr
	 * @return
	 */
	public String [] makeArrayFromStr(String str, String separator) {
		if (isNullOrEmpty(separator) || isNullOrEmpty(str))
			return null;
		
		String [] res = str.split(separator);
		
		if (res != null && 0 < res.length) 
			return res;
		else 
			return null;
	}
	
	
	/**
	 * 구분자를 기준으로 입력한 문자열을 자른 문자열의 배열을 리턴하는 메소드 .csv 파일을 다룰때 사용.
	 * This method is used by when to handle CSV file mainly.
	 * 
	 * @param targetStr
	 * @return
	 */
	public String [] makeArrayFromStr(String str) {
	    return makeArrayFromStr(str, ",");
	}
	
	
	/**
	 * 문자열을 문자의 배열로 리턴한다.
	 * Return char array from String.
	 * 
	 * @param str
	 * @return
	 */
	public char [] makeCharArry(String str) {
		if ( isNullOrEmpty(str))
			return null;
		
		char [] res = str.toCharArray();
		
		if (res != null && 0 < res.length) 
			return res;
		else 
			return null;
	}
	
	
	/**
	 * 문자열을 문자(래퍼 클래스)의 리스트로 리턴한다.
	 * Return Character List from String.
	 * 
	 * @param str
	 * @param isArrayList : Return ArrayList if it is true, Return LinkedList if it is false.
	 * @return
	 */
	public List<Character> makeCharList(String str, boolean isArrayList) {
		if ( isNullOrEmpty(str))
			return null;
		
		List<Character> res = isArrayList
				? new ArrayList<Character>()
				: new LinkedList<Character>();
		
		for (char ch :  str.toCharArray()) {
			res.add((Character)ch);
		}
		
		if (res != null && 0 < res.size()) 
			return res;
		else 
			return null;
	}
	
	
	/**
	 * 문자열의 배열을 입력하면 CSV파일의 레코드와 같이 구분자로 각 요소를 구분한 문자열을 리턴한다.  
	 * Return String which split by separator like a record of CSV file, When input String Array.
	 * 
	 * @param separator
	 * @param strs
	 * @return
	 */
	public String makeRecordStr(String separator, String ...strs) {
		if (strs == null || strs.length == 0) {
			System.out.println("separator="+separator + ", strs="+strs[0]);
			return null;
		}
		
		int len = strs.length;
		StringBuffer res = new StringBuffer("");
		
		for (int i = 0; i < len; i++) {
			 res.append(strs[i]);
			 if (len == 1 || i == (len - 1 )) break;
			 if (separator != null) res.append(separator);
		}
		
		return res.toString();
	}
	
	
	/**
	 * 문자열의 리스트를 입력하면 CSV파일의 레코드와 같이 구분자로 각 요소를 구분한 문자열을 리턴한다.  
	 * Return String which split by separator like a record of CSV file, When input String List.
	 * 
	 * @param separator
	 * @param strs
	 * @return
	 */
	public String makeRecordStr(String separator, List<String> list) {
		if (list == null || list.size() == 0) {
			System.out.println("separator="+separator + ", list="+list.get(0));
			return null;
		}
			
		
		int len = list.size();
		StringBuffer res = new StringBuffer("");
		
		for (int i = 0; i < len; i++) {
			 res.append(list.get(i));
			 if (len == 1 || i == (len - 1 )) break;
			 res.append(separator);
		}
		
		return res.toString();
	}
	

	/**
	 * 문자열의 배열을 입력하면 CSV 형식의 레코드 문자열을 리턴하는 메소드.
	 * This method return a String format of CSV, When input String Array.
	 * 
	 * @param strs
	 * @return
	 */
	public String makeRecodeStrCsvFormat(String ...strs) {
		return makeRecordStr(",", strs);
	}
	
	
	/**
	 * 문자열의 리스트를 입력하면 CSV 형식의 레코드 문자열을 리턴하는 메소드.
	 * This method return a String format of CSV, When input String List.
	 * 
	 * @param strs
	 * @return
	 */
	public String makeRecodeStrCsvFormat(List<String> list) {
		return makeRecordStr(",", list);
	}
	
}
