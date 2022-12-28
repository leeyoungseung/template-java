package template.java.algorithm.programers;

public class PMS_034_MorseConverter {

	public static void main(String[] args) {
		String data = ".... . .-.. .-.. ---";
		System.out.printf("Origin : %s, Result : %s", data, solution(data));
	}

    public static String solution(String letter) {
        // 문자열을 공백을 기준으로 나누기
    	// 나눈 문자가 morse 안에 있는지 검색
    	// hit시에는 결과담기 변수에 append
    	final String [] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    	String [] letterAry = letter.split(" ");
    	StringBuilder sb = new StringBuilder();
    	for (String c : letterAry) {
    		for (int i=0; i<morse.length; i++) {
    			if (c.equals(morse[i])) {
    				String str = ((char)(i+97))+"";
    				sb.append(str);
    			}
    		}
    	}
        return sb.toString();
    }
}
