package template.java.algorithm.programers;

public class PMS_024_RepeatCharsInString {

	public static void main(String[] args) {
		String data = "hello";
		int repeatCount = 3;
		System.out.printf(
				"Origin String : %s , "
				+ "Repeat : %d, "
				+ "Converted String : %s", data , repeatCount, solution(data, repeatCount));
	}

    public static String solution(String my_string, int n) {
    	char [] array = my_string.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	for (char c : array) {
    		for (int i=0; i<n; i++) {
    			sb.append(c);
    		}
    	}
        String answer = sb.toString();
        return answer;
    }
}
