package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_052_ConditionOfTriangle {

	public static void main(String[] args) {
		int data [] = new int [] {1, 2, 3};
		System.out.printf("data : %s, result : %d  \n", Arrays.toString(data), solution(data));
	}

    public static int solution(int[] sides) {
        // 가장 긴 변을 찾기위해 정렬
    	// 가장 긴 변 이외의 변의 합과 가장긴변의 길이를 비교한다.
        Arrays.sort(sides);
        return sides[0]+sides[1] > sides[2] ? 1 : 2;
    }
}
