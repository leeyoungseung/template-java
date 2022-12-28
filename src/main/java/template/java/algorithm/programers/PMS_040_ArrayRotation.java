package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_040_ArrayRotation {

	public static void main(String[] args) {
		int [] data = {1, 2, 3};
		System.out.printf("OriginData : %s, ConvertedData : %s \n", Arrays.toString(data), Arrays.toString(solution(data, "right")));
		int [] data2 = {4, 455, 6, 4, -1, 45, 6};
		System.out.printf("OriginData : %s, ConvertedData : %s \n", Arrays.toString(data2),  Arrays.toString(solution(data2, "left")));
	}

    public static int[] solution(int[] numbers, String direction) {
        int[] answer = new int [numbers.length];
        if (direction.equals("right")) {
        	for (int i=0; i<numbers.length-1; i++) {
        		answer[i+1] = numbers[i];
        	}
        	answer[0] = numbers[numbers.length-1];
        } else {
        	for (int i=1; i<numbers.length; i++) {
        		answer[i-1] = numbers[i];
        	}
        	answer[answer.length-1] = numbers[0];
        }
        return answer;
    }
}
