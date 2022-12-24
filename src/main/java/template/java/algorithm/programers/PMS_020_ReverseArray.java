package template.java.algorithm.programers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PMS_020_ReverseArray {

	public static void main(String[] args) {
		int [] data = {1, 2, 3, 4, 5};
		System.out.printf("before : %s \n", Arrays.toString(data));
		System.out.printf("after : %s \n", Arrays.toString(solution(data)));
	}

    public static int[] solution(int[] num_list) {
    	List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        Collections.reverse(list);
    	int[] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
