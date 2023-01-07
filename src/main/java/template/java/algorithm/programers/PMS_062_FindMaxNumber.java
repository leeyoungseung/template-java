package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_062_FindMaxNumber {

	public static void main(String[] args) {
		int [] data = {1, 8, 3};
		System.out.printf("Data : %s , Result : %s \n", Arrays.toString(data), Arrays.toString(solution(data)));
		int [] data2 = {9, 10, 11, 8};
		System.out.printf("Data2 : %s , Result : %s \n", Arrays.toString(data2), Arrays.toString(solution(data2)));
	}

    public static int[] solution(int[] array) {
        int[] answer = new int [2];
        for (int i=0; i<array.length; i++) {
        	if (answer[0] < array[i]) {
        		answer[0] = array[i];
        		answer[1] = i;
        	}
        }
        return answer;
    }
}
