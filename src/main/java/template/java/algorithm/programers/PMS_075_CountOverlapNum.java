package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_075_CountOverlapNum {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {1, 1, 2, 3, 4, 5}, 0));
	}

    public static int solution(int[] array, int n) {
        return (int) Arrays.stream(array).filter(value -> value == n).count();
    }
}
