package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_073_Count7 {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {7, 77, 17}));
	}

    public static int solution(int[] array) {
        return Arrays.toString(array).length() - Arrays.toString(array).replaceAll("7", "").length();
//        return (int) Arrays.stream(
//                Arrays.stream(array)
//                        .mapToObj(String::valueOf)
//                        .collect(Collectors.joining())
//                        .split("")
//        )
//        .filter(s -> s.equals("7"))
//        .count();
    }
}
