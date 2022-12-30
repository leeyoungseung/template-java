package template.java.algorithm.programers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PMS_050_getElementLengthArray {

	public static void main(String[] args) {
		String [] data = new String [] {"We", "are", "the", "world!"};
		System.out.printf("data : %s, result : %s \n", Arrays.toString(data), Arrays.toString(solution(data)));
	}

    public static int[] solution(String[] strlist) {
        return Arrays.asList(strlist).stream().map(s -> s.length()).collect(Collectors.toList()).stream().mapToInt(n -> n).toArray();
        // return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
}
