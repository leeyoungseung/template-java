package template.java.algorithm.programers;

public class PMS_057_HateEnglish {

	public static void main(String[] args) {
		System.out.println(solution("onetwothreefourfivesixseveneightnine"));
		System.out.println(solution("onefourzerosixseven"));
	}

    public static long solution(String numbers) {
        String convertedStr = numbers.replaceAll("zero", "0")
        .replaceAll("one", "1")
        .replaceAll("two", "2")
        .replaceAll("three", "3")
        .replaceAll("four", "4")
        .replaceAll("five", "5")
        .replaceAll("six", "6")
        .replaceAll("seven", "7")
        .replaceAll("eight", "8")
        .replaceAll("nine", "9");
        return Long.parseLong(convertedStr);
    }
}
