package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_010_GetCenter {

	public static void main(String[] args) {
		int [] data = {7, 11, 1, 10, 3};
		System.out.printf("before : %s \n", Arrays.toString(data));
		Arrays.sort(data);
		System.out.printf("after : %s \n", Arrays.toString(data));
	}

    public static int solution(int[] array) {
    	Arrays.sort(array);
    	int len = array.length-1;
    	int center = (len != 0 && len != 1) ? ((len-1) / 2) + 1 : len;
        int answer = array[center];
        return answer;
    }
}
