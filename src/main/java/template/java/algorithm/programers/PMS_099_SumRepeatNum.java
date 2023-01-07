package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_099_SumRepeatNum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3,12)));
		System.out.println(Arrays.toString(solution(5,15)));
		System.out.println(Arrays.toString(solution(4,14)));
		System.out.println(Arrays.toString(solution(5,5)));
	}

    public static int[] solution(int num, int total) {
        int[] answer = new int[num];

        int middleNumber = total / num;
        int subtracNumber = total % num == 0 ? num / 2 : num / 2 - 1;

        int startNumber = middleNumber - subtracNumber;

        for (int i = 0; i < num; i++) {
            answer[i]= startNumber + i;
        }
        return answer;
    }
}
