package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_067_SumPlaceValue {

	public static void main(String[] args) {
		System.out.printf("N : %d, Result : %d \n", 1234, solution(1234));
	}

    public static int solution(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(i -> Integer.parseInt(i)).sum();
    }
}
