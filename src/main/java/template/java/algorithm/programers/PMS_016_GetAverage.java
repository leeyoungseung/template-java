package template.java.algorithm.programers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PMS_016_GetAverage {

	public static void main(String[] args) {
		int [] data1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] data2 = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};

		System.out.printf("data1 : %s , result : %f \n", Arrays.toString(data1), solution(data1));
		System.out.printf("data2 : %s , result : %f \n", Arrays.toString(data2), solution(data2));
	}

    public static double solution(int[] numbers) {

    	List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        double answer = list.stream().mapToInt(a -> a).average().orElse(0);
        return answer;
    }

}
