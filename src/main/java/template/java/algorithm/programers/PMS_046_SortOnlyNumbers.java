package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_046_SortOnlyNumbers {

	public static void main(String[] args) {
		String data1 = "hi12392";
		System.out.printf("data : %s, result : %s \n", data1, Arrays.toString(solution(data1)));
		String data2 = "p2o4i8gj2";
		System.out.printf("data : %s, result : %s \n", data2, Arrays.toString(solution(data2)));
		String data3 = "abcde0";
		System.out.printf("data : %s, result : %s \n", data3, Arrays.toString(solution(data3)));
	}

    public static int[] solution(String my_string) {
    	// 영어 소문자 + 숫자로 구성된 문자열이므로 영어소문자를 우선 제거
    	// 숫자로 구성된 문자열을 char 배열로 변환
    	// char배열을 int 배열로 변환
    	// int 배열을 정렬
    	char [] tempList = my_string.replaceAll("[a-z]", "").toCharArray();
        int[] answer = new int [tempList.length];
        for (int i=0; i<tempList.length; i++) {
        	answer[i] = Character.getNumericValue(tempList[i]);
        }
        Arrays.sort(answer);
        return answer;
    }
}
