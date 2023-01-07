package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;

public class PMS_074_CutStringToArray {

	public static void main(String[] args) {
		System.out.printf("data : %s, result : %s", "abc1Addfggg4556b", Arrays.toString(solution("abc1Addfggg4556b", 6)));
	}

    public static String [] solution(String my_str, int n) {
        ArrayList<String> list = new ArrayList<>();
        int start = 0;
        int end = n;

        while (true) {
        	String str = my_str.substring(start, end > my_str.length() ? my_str.length() : end);
        	if (!str.equals("")) list.add(str);
        	if (end > my_str.length()) break;
        	start = end;
        	end += n;
        }

        return list.stream().toArray(String[]::new);
//        return IntStream.range(0, myStr.length() / n + (myStr.length() % n > 0 ? 1 : 0))
//                .mapToObj(i -> i == myStr.length() / n ? myStr.substring(i * n) : myStr.substring(i * n, (i + 1) * n))
//                .toArray(String[]::new);
    }
}
