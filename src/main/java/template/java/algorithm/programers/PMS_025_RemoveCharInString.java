package template.java.algorithm.programers;

public class PMS_025_RemoveCharInString {

	public static void main(String[] args) {
		String data = "abcdef";
		String removeChar = "f";
		System.out.printf(
				"Origin String : %s , "
				+ "removeChar : %s, "
				+ "Converted String : %s", data , removeChar, solution(data, removeChar));
	}

    public static String solution(String my_string, String letter) {
        return my_string.replaceAll(letter, "");
    }
}
