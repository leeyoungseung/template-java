package template.java.algorithm.programers;

public class PMS_021_ReverseString {

	public static void main(String[] args) {
		System.out.printf("Before : %s, After : %s \n ", "jaron", solution("jaron"));
		System.out.printf("Before : %s, After : %s \n ", "bread", solution("bread"));
	}

    public static String solution(String my_string) {
    	StringBuilder sb = new StringBuilder(my_string);
        String answer = sb.reverse().toString();
        return answer;
    }
}
