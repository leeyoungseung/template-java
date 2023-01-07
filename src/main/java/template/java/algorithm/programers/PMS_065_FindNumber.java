package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_065_FindNumber {

	public static void main(String[] args) {
		System.out.printf("Num : %d, k : %d, Result : %d \n", 29183, 1, solution(29183, 1));
		System.out.printf("Num : %d, k : %d, Result : %d \n", 232443, 4, solution(232443, 4));
		System.out.printf("Num : %d, k : %d, Result : %d \n", 123456, 7, solution(123456, 7));
	}

    public static int solution(int num, int k) {
        int  answer = -1;
        int[] ary = Arrays.stream(String.valueOf(num).split("")).mapToInt(s -> Integer.parseInt(s)).toArray();
        for (int i=0; i<ary.length; i++) {
        	if (k == ary[i]) {
        		answer = i+1; break;
        	}
        }
        return answer;
        // return ("-" + num).indexOf(String.valueOf(k));
    }
}
