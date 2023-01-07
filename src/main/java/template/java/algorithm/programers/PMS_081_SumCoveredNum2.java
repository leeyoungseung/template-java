package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PMS_081_SumCoveredNum2 {


	public static void main(String[] args) {
		System.out.println(solution("aAb1B2cC34oOp"));
		System.out.println(solution("1a2b3c4d123Z"));
		System.out.println(solution("AaABc"));
		System.out.println(solution("1a2b3c4d123"));
	}

    public static int solution(String my_string) {

    	String [] ary = my_string.split("");
    	List<Integer> list = new ArrayList<>();
    	String temp = "";
    	boolean flg = false; // 직전이 숫자인지 판별 숫자면 true
    	for (int i=0; i<=ary.length; i++) {
    		if (i<=ary.length)

    		if (i!=ary.length && Pattern.matches("[0-9]", ary[i])) {
    			temp += ary[i];
    			flg = true;
    		} else {
    			flg = false;
    		}

    		if (!flg) {
    			if (!temp.equals("")) {
    				list.add(Integer.parseInt(temp));
    				temp = "";
    			}
    		}

    	}

        return list.stream().mapToInt(s->s).sum();
        // return Arrays.stream(myString.split("[A-Z|a-z]")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();
    }
}
