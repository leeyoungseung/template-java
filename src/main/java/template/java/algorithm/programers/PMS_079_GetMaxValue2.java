package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_079_GetMaxValue2 {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {1, 2, -3, 4, -5}));
	}

    public static int solution(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);

        int positive = numbers[len-1] * numbers[len-2];
        int negative = numbers[0] * numbers[1];
        return positive >= negative ? positive : negative;
    }
}
