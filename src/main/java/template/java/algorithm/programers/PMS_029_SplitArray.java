package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PMS_029_SplitArray {

	public static void main(String[] args) {
		int [] data = {1, 2, 3, 4, 5};
		System.out.printf("OriginData : %s, ConvertedData : %s", Arrays.toString(data), solution(data, 1, 3));
	}

    public static int[] solution(int[] numbers, int num1, int num2) {
    	List<Integer> list = new ArrayList<>();
    	for (int i=num1; i<=num2; i++) {
    		list.add(numbers[i]);
    	}
        return list.stream().mapToInt(i->i).toArray();
    }
}
