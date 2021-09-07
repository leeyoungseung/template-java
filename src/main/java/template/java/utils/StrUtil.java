package template.java.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	
	/**
	 * 타겟 문자열 안에 특정 문자열이 포함되어 있는지 확인. 찾는 문자열이 있다면 true, 없다면 false반환
	 * It check whether findStr exist or not in targetStr, If it exist, return true or false.
	 * @param targetStr
	 * @param findStr
	 * @return
	 */
	public boolean hasStrInTarget(String targetStr, String findStr) {
		return targetStr.contains(findStr);
	}
	
	
	/**
	 * 타겟 문자열 안에 찾는 패턴(정규표현식)의 문자열이 있다면 true를 리턴, 없다면 false를 리턴  
	 * It return true if words with regex exist in target String or false.
	 * @param targetStr
	 * @param regex
	 * @return
	 */
	public boolean isMatch (String targetStr, String regex) {
		return targetStr.matches(regex);
	}
	
	
	/**
	 * 타겟 문자열 안에 찾는 문자열이 포함되어 있다면. 찾는 문자열의 시작과 끝의 인텍스를 배열에 담아 리턴, 없다면 null리턴 
	 * It return array of words about findStr's index count start and end. if it has not findStr, return null.
	 * @param targetStr
	 * @param findStr
	 * @return
	 */
	public int [] getFindStrIndexsInTarget(String targetStr, String findStr) {
		int startIndex = targetStr.indexOf(findStr);
		if (startIndex == -1) 
			return null;
		int lastIndex  = startIndex + (findStr.length() - 1);
		
		return new int[] { startIndex, lastIndex };
	}
	

	
	
	/**
	 * 타겟 문자열 안의 패턴(정규표현식)에 해당하는 문자열을 추출하여 리스트에 담아서 리턴한다.
	 * It return List which put in words correspond with regex.
	 * @param targetStr
	 * @param regex
	 * @return
	 */
	public List<String> getMatchedStrs (String targetStr, String regex) {
		List<String> list = new ArrayList<>();
		
		Pattern.compile(regex).matcher(targetStr).results().forEach(result -> {
			list.add(result.group());
		});
		
		return list;
	}
	
	
	/**
	 * 문자열을 16진수로 변환해주는 메소드
	 * This method return a String converted from String to Hex 
	 * @param target
	 * @return
	 */
	public String convertStrToHex(String target) {
		if (isNullOrEmpty(target))
				return null;
		String res = "";
		
	    for (int i = 0; i < target.length(); i++) {
	    	res += String.format("%02X ", (int) target.charAt(i));
	    }
	    
		return res;
	}
	
	
	/**
	 * 16진수를 문자열로 변환해주는 메소드
	 * This method return a String converted from Hex to String 
	 * @param type
	 * @param target
	 * @return
	 */
	public String convertHexToStr(String type, String target) {
		if (isNullOrEmpty(type) || isNullOrEmpty(target))
				return null;
		
		int len = target.length();
		byte[] data = new byte[len/2];
		for (int i = 0; i < len; i += 2) {
			data[i/2] = (byte) ((Character.digit(target.charAt(i), 16) << 4)
					+ Character.digit(target.charAt(i+1), 16));
		}

		String res = null;
		try {
			res = new String(data, type);
			
		} catch (UnsupportedEncodingException e) { e.printStackTrace(); }
	    
		return res;
	}
	
	
	/**
	 * 문자열을 선택한 방식으로 디코딩해서 리턴하는 메소드
	 * This method return a String decoded by chosen encoding type. 
	 * @param type
	 * @param target
	 * @return
	 */
	public String decodeStr(String type, String target) {
		if (isNullOrEmpty(type) || isNullOrEmpty(target))
				return null;
		String decodeRes = null;
		
		try {
			decodeRes = new String(target.getBytes(type), type);
			
		} catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		
		return decodeRes;
	}
	
	/**
	 * 특정 인코딩 방식으로 인코딩된 문자열을 원하는 인코딩 방식으로 변환해준다
	 * 예시 ) EUC-KR -> UTF-8
	 * This method converts a string of chosen encoding type. 
	 * Have to input parameters original encoding type and chosen encoding type, target string. 
	 * @param oldType
	 * @param newType
	 * @param target
	 * @return
	 */
	public String decodeTypeToType(String oldType, String newType, String target) {
		String originTypeStr = decodeStr(oldType, target);
		return decodeStr(newType, originTypeStr);
	}
	
	
	/**
	 * 모든 종류의 공백 (전각, 반각)을 제거한 문자열을 리턴하는 메소드
	 * This method return a String deleted space of all kinds for example (full-width space character,half-width space character) 
	 * @param targetStr
	 * @return
	 */
	public String deleteAllSpace(String targetStr) {
		if (isNullOrEmpty(targetStr))
			return null;
		return targetStr.replaceAll("　", " ").replaceAll("\\s+", "");
	}
	
	
	/**
	 * 개행문자를 제거한 문자열을 리턴하는 메소드. 개행문자를 직접지정.
	 * This method return a String deleted lineseparator. Set lineseparator up directly.
	 * @param lineSeparator
	 * @param targetStr
	 * @return
	 */
	public String deleteLineSeparator(String lineSeparator, String targetStr) {
		if (isNullOrEmpty(lineSeparator) || isNullOrEmpty(targetStr))
			return null;
		return targetStr.replaceAll(lineSeparator, "");
	}
	
	
	/**
	 * 개행문자를 제거한 문자열을 리턴하는 메소드, 예약된 개행문자 설정
	 * This method return a String deleted lineseparator. Set reserved lineseparator up.
	 * @param lineSeparator
	 * @param targetStr
	 * @return
	 */
	public String deleteLineSeparator(String targetStr) {
		return targetStr.replaceAll("(\r\n|\r|\n|\n\r)", "");
	}
	
	
}
