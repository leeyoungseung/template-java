package template.java.algorithm.programers;

import java.util.Arrays;
import java.util.Comparator;

public class PMS_031_OrderToDiagnosis {

	public static void main(String[] args) {
		int [] data = {3, 76, 24};
		System.out.printf("Emergeny : %s, Result : %s", Arrays.toString(data), Arrays.toString(solution(data)));
	}

    public static int[] solution(int[] emergency) {
    	// 우선순위를 알려면 정렬해야함. -> 배열을 복사해서 정렬된 배열을하나 만들자
    	// 정렬된 배열의 요소수 분 반복
    	// emergency의 요소수 분 반복해서 순위를 매기자

    	Integer [] sorted = Arrays.stream(emergency.clone()).boxed().toArray(Integer[]::new);
    	Arrays.sort(sorted, Comparator.reverseOrder());
    	int [] orders = new int[emergency.length];

    	for (int i=0; i<sorted.length; i++) {
    		for(int j=0; j<emergency.length; j++) {
    			if (sorted[i]==emergency[j]) orders[j] = (i+1);
    		}
    	}

        return orders;
    }
}
