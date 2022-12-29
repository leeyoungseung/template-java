package template.java.algorithm.programers;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class PMS_048_Factorization {

	public static void main(String[] args) {
		int data1 = 12;
		System.out.printf("data : %d, result : %s \n", data1, Arrays.toString(solution(data1)));
		int data2 = 17;
		System.out.printf("data : %d, result : %s \n", data2, Arrays.toString(solution(data2)));
		int data3 = 420;
		System.out.printf("data : %d, result : %s \n", data3, Arrays.toString(solution(data3)));
	}

    public static int[] solution(int n) {

    	SortedSet<Integer> set = new TreeSet<Integer>();
    	for (int i=2; i<=n; i++) {
    		if (n % i == 0 && getDivisorCount(i) == 2) set.add(i);
    	}
        return set.stream().mapToInt(i->i).toArray();
    }

    public static int getDivisorCount(int su) {
    	int cnt = 0;
    	for (int i=1; i<=su; i++) {
    		if (su % i == 0) cnt++;
    	}
    	return cnt;
    }
}
