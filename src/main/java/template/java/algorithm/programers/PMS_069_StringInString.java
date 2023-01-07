package template.java.algorithm.programers;

public class PMS_069_StringInString {

	public static void main(String[] args) {
		System.out.println(solution("ab6CDE443fgh22iJKlmn1o","6CD"));
		System.out.println(solution("ppprrrogrammers","pppp"));
	}

    public static int solution(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }
}
