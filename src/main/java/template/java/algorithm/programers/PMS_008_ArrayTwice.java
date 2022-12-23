package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_008_ArrayTwice {

	public static void main(String[] args) {
		int [] data = {1, 2, 3, 4, 5};
		System.out.printf("before : %s \n", Arrays.toString(data));
		System.out.printf("after : %s \n", Arrays.toString(solution(data)));
	}


    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }

        return answer;
    }
}
