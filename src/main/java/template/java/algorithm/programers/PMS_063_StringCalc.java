package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PMS_063_StringCalc {

	public static void main(String[] args) {
		System.out.println("57".chars().allMatch(Character::isDigit));
		System.out.println("+".chars().allMatch(Character::isDigit));
		System.out.println("1233".chars().allMatch(Character::isDigit));
		System.out.println(solution("1233 + 45 - 57 + 10"));
		System.out.println(solution("3 + 4"));
	}

    public static int solution(String my_string) {
    	// (A) 문자열을 숫자,기호,숫자의 형태의 리스트로 나눠야함.
    	// (B) 1.숫자 i -> 2.기호 n -> 3.숫자i+1 -> 기호 n+1(이 시점에) 1 ~ 3까지의 연산을 행해야함.
    	// (D) 연산의 최종 결과를 리턴

    	// ----- (A)
    	String [] ary = my_string.replaceAll(" ", "").split("");
    	List<String> list = new ArrayList<>();
    	String tmp = "";
    	for (int i=0; i<=ary.length; i++) {
    		if (ary.length > i && ary[i].trim().chars().allMatch(Character::isDigit)) {
    			tmp += ary[i];
    		} else {
    			if (!tmp.equals("")) { list.add(tmp); tmp = ""; }
    			if (ary.length > i) list.add(ary[i]);
    		}
    	}

    	//System.out.println(String.join(",", list));
    	// ----- (B)
        int answer = 0; // 전체 연산의 결과값
        String num1 = ""; // 숫자 i
        String num2 =""; // 숫자 i+1
        Integer calcFlg = 0; // 2가 되면 연산W
        String flg = "";

        for (int i=0; i<=list.size(); i++) {

        	if (list.size() > i  && list.get(i).trim().chars().allMatch(Character::isDigit)
        			|| i == 0
        			) {
        		if (num1.equals("")) {
        			num1 = list.get(i);
        		} else {
        			num2 = list.get(i);
        		}
        	}

        	if (list.size() > i && Pattern.matches("[\\+\\-\\*\\/]", list.get(i))) {
        		if (flg.equals("")) {
        			flg = list.get(i);
        		}
        		if (calcFlg != 2 || list.size() == i) {
        			calcFlg++;
        		}
        		if (calcFlg == 2) {
        			answer = calc(flg, num1, num2);
        			num1 = String.valueOf(answer);
        			if (list.size() != i) flg = list.get(i);
        			calcFlg = 1;
        		}
        	}

        	if (i == list.size()) {
    			answer = calc(flg, num1, num2);
        	}
        }

        return answer;
        // return Arrays.stream(myString.replaceAll("- ", "-").replaceAll("[+] ", "").trim().split(" ")).mapToInt(Integer::parseInt).sum();
    }

    public static int calc(String flg, String n1, String n2) {
    	int result = 0;
    	int num1 = Integer.parseInt(n1);
    	int num2 = Integer.parseInt(n2);
    	switch (flg) {
		case "+": result = num1 + num2; break;
		case "-": result = num1 - num2; break;
		case "*": result = num1 * num2; break;
		case "/": result = num1 / num2; break;
		default : break;
		}
    	return result;
    }
}
