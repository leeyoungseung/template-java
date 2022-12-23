package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PMS_012_GetOddArray {

	public static void main(String[] args) {
		int len = 10;
		System.out.printf("len : %d , result : %s \n", len, Arrays.toString(solution(len)));
		len = 15;
		System.out.printf("len : %d , result : %s \n", len, Arrays.toString(solution(len)));
	}

    public static int[] solution(int n) {

    	// n 은 길이가 되어야함
    	// 1 ≤ n ≤ 100; 따라서 0이 아니라 1부터 시작해서 n까지 값을 증가해야함. = i
    	// i를 2로 나눠서 나머지가 0인 경우 홀수임
    	// 홀수로 판정된 경우 리스트에 넣자
    	// 결과 리스트를 배열로 변환해여 리턴하자

    	int len = n;
    	List<Integer> list = new ArrayList<>();

    	for (int i=1; i<=len; i++) {
    		if (i % 2 != 0) list.add(i);
    	}

        int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
