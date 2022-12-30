package template.java.algorithm.programers;

import java.util.Arrays;
import java.util.List;

public class PMS_049_CtrlZ {

	public static void main(String[] args) {
		System.out.printf("data : %s ,  result : %d \n", "1 2 Z 3", solution("1 2 Z 3"));
		System.out.printf("data : %s ,  result : %d \n", "10 20 30 40", solution("10 20 30 40"));
		System.out.printf("data : %s ,  result : %d \n", "-1 -2 -3 Z", solution("-1 -2 -3 Z"));
	}

    public static int solution(String s) {
    	// 공백으로 문자열을 나눈 리스트 만들기
    	// 반복하면 i++ Z가 들어 있다면 i-1의 숫자를 빼준다.
    	int answer = 0;
    	List <String> list = Arrays.asList(s.split(" "));
    	for (int i=0; i<list.size(); i++) {
    		if (list.get(i).equals("Z")) {
    			answer -= Integer.parseInt(list.get(i-1));
    		} else {
    			answer += Integer.parseInt(list.get(i));
    		}
    	}
        return answer;
    }
}
