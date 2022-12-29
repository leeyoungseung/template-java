package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_043_GetMaxValue1 {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {1, 2, 3, 4, 5}));
		System.out.println(solution(new int [] {0, 31, 24, 10, 1, 9}));
	}

    public static int solution(int[] numbers) {
    	// 오름차순 정렬한후 length-1 * length-2
    	Arrays.sort(numbers);
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }
}
