package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_066_FindMultiple {

	public static void main(String[] args) {
		int [] data = {4, 5, 6, 7, 8, 9, 10, 11, 12};
		System.out.printf("N : %d, Numlist : %s, Result : %s \n", 3, Arrays.toString(data),  Arrays.toString(solution(3, data)));
	}

    public static int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(i -> i % n == 0).toArray();
    }
}
