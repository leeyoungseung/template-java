package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_053_GetNearValue {

	public static void main(String[] args) {
		int [] data = {3, 10, 28, 12, -12};
		System.out.printf("data : %s, result : %d", Arrays.toString(data), solution(data, 20));
	}

    public static int solution(int[] array, int n) {
    	Arrays.sort(array);
        int answer = 0;
        int com = n + 100;
        for (int d : array) {
        	if (Math.abs(d-n) < com) {
        		com = Math.abs(d-n);
        		answer = d;
        	}
        }
        return answer;
    }

	/** TC3 불합 왜 틀렸는지 모르겠음ㄷㄷ??
    public static int solution(int[] array, int n) {
    	// 1. n - array[i]의 절대값을 구하기
    	// 2. 이전 1의 결과 보다 값이 더크다면 1의 결과를 변수에 저장
    	Arrays.sort(array);
        int answer = 0;
        int before = 0;
        for (int i=array.length-1; i>=0; i--) {
        	int abs = Math.abs(n - Math.abs(array[i]));
        	if (abs <= before || before == 0) {
        		answer = array[i];
        		before = Math.abs(n - array[i]);
        	}
        }
        return answer;
    }
    */
}
