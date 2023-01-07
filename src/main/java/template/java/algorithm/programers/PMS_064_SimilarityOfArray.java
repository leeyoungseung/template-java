package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_064_SimilarityOfArray {

	public static void main(String[] args) {
		String [] s1 = {"a", "b", "c"};
		String [] s2 = {"com", "b", "d", "p", "c"};
		System.out.printf("S1 : %s, S2 : %s, Result : %d \n", Arrays.toString(s1), Arrays.toString(s2), solution(s1, s2));
	}

    public static int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (int i=0; i<s1.length; i++) {
        	for (int j=0; j<s2.length; j++) {
        		if (s1[i].equals(s2[j])) {
        			answer++;
        			break;
        		}
        	}
        }
        return answer;
        // return (int) Arrays.stream(s1).map(s -> Arrays.stream(s2).collect(Collectors.toList()).contains(s)).filter(b -> b).count();
    }
}
