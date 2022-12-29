package template.java.algorithm.programers;

public class PMS_045_RemoveVowels {

	public static void main(String[] args) {
		String data1 = "nice to meet you";
		System.out.printf("data : %s, result : %s \n", data1, solution(data1));
		String data2 = "bus";
		System.out.printf("data : %s, result : %s \n", data2, solution(data2));
	}

    public static String solution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }
}
