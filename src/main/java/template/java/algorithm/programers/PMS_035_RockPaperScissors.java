package template.java.algorithm.programers;

public class PMS_035_RockPaperScissors {

	public static void main(String[] args) {

	}

    public static String solution(String rsp) {
    	// 받은 문자열을 분리
    	// 문자 한나씩 결과를 얻기
    	// 결과를 합쳐서 리턴
    	char [] array = rsp.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	for (char c : array) {
    		sb.append(getResult(""+c));
    	}
        return sb.toString();
    }

    public static String getResult(String key) {
    	if (key.equals("2")) return "0";
    	else if (key.equals("0")) return "5";
    	else if (key.equals("5")) return "2";
    	else return key;
    }
}
