package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_095_AtoB {

	public static void main(String[] args) {
		System.out.println(solution("olleh","hello"));
	}

    public static int solution(String before, String after) {

    	char [] beforeC = before.toCharArray();
    	char [] afterC = after.toCharArray();
    	Arrays.sort(beforeC);
    	Arrays.sort(afterC);
    	return String.valueOf(beforeC).equals(String.valueOf(afterC)) ? 1 : 0;

    }
}
