package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_072_SortString2 {

	public static void main(String[] args) {
		String data = "Bcad";
		System.out.printf("Data : %s , Result : %s \n", data , solution(data));
	}

    public static String solution(String my_string) {
    	char [] list = my_string.toLowerCase().toCharArray();
    	Arrays.sort(list);
        return String.valueOf(list);
    }
}
