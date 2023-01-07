package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PMS_060_GetDivisor {

	public static void main(String[] args) {
		System.out.printf("n : %d , Result : %s \n", 24, Arrays.toString(solution(24)));
		System.out.printf("n : %d , Result : %s \n", 29, Arrays.toString(solution(29)));
	}

    public static int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
        	if (n % i == 0) list.add(i);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
