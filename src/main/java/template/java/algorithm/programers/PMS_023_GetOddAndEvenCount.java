package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_023_GetOddAndEvenCount {

	public static void main(String[] args) {
		int [] data = {1, 2, 3, 4, 5};
		System.out.printf("Data : %s Even And Odd : %s  \n", Arrays.toString(data), Arrays.toString(solution(data)));
		int [] data2 = {1, 3, 5, 7};
		System.out.printf("Data2 : %s Even And Odd : %s  \n", Arrays.toString(data2), Arrays.toString(solution(data2)));
	}

    public static int[] solution(int[] num_list) {
    	int countEven = 0;
    	int countOdd = 0;
    	for (int i=0; i<num_list.length; i++) {
    		if (num_list[i] % 2 == 0) countEven++;
    		else countOdd++;
    	}
        int[] answer = {countEven, countOdd};
        return answer;
    }
}
