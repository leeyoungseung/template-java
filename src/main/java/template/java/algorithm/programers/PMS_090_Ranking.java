package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_090_Ranking {

	public static void main(String[] args) {
		int data [][] = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
		System.out.printf("Origin : %s, Result : %s \n ", Arrays.deepToString(data), Arrays.toString(solution(data)));
		int data2 [][] = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
		System.out.printf("Origin : %s, Result : %s \n ", Arrays.deepToString(data2), Arrays.toString(solution(data2)));
	}

    public static int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        System.out.printf("Before : %s\n ", Arrays.toString((answer)));
        Arrays.fill(answer, 1);
        System.out.printf("After : %s \n ", Arrays.toString((answer)));

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if(score[i][0] + score[i][1] > score[j][0] + score[j][1]) {
                    answer[j]++;
                    System.out.printf("i : %d, j : %d , Process : %s \n ", i, j, Arrays.toString((answer)));
                }
            }
        }
        return answer;
    }
}
