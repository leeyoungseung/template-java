package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_047_SumOnlyNumbers {

	public static void main(String[] args) {
		String data1 = "aAb1B2cC34oOp";
		System.out.printf("data : %s, result : %d \n", data1, solution(data1));
		String data2 = "1a2b3c4d123";
		System.out.printf("data : %s, result : %d \n", data2, solution(data2));
		String data3 = "abcde0";
		System.out.printf("data : %s, result : %d \n", data3, solution(data3));
	}

    public static int solution(String my_string) {
    	// 영어 + 숫자로 구성된 문자열이므로 영어를 우선 제거
    	// 숫자로 구성된 문자열 리스트로 변환
    	// 문자열 리스트를 Integer 리스트로 변환
    	// Integer 리스트의 합계를 구함
        return Arrays.stream(my_string.replaceAll("[A-z|a-z]", "").split("")).mapToInt(Integer::parseInt).sum();
    }
}
