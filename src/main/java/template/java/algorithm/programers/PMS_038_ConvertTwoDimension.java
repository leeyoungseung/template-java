package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_038_ConvertTwoDimension {

	public static void main(String[] args) {
		int [] data = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.printf("OriginData : %s, ConvertedData : %s", Arrays.toString(data), Arrays.deepToString(solution(data, 2)));

	}

    public static int[][] solution(int[] num_list, int n) {
    	// 1차원을 2차원으로 변경
    	// x1,x2,x3 -> x1,y2,y3으로 변하게됨
    	// n은 list의 배수이니, y가 수가 맞아 떨어지지 않는 케이스는 없음
    	// list를 반복하면서 y를 채워넣어야함.
    	// i += n으로 증감해서 list의 길이까지 반복하자
    	// y에 채워넣기는 [i][j]로 반복하면됨.
        int[][] answer = new int [num_list.length/n][n];

        int xCount = 0;
    	for (int i=0; i<num_list.length; i=i+n) {
    		for (int j=0; j<n; j++) {
    			answer[xCount][j]= num_list[i+j];
    		}
    		xCount++;
    	}

        return answer;
    }
}
