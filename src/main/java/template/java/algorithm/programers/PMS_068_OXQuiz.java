package template.java.algorithm.programers;

import java.util.Arrays;
import java.util.List;

public class PMS_068_OXQuiz {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String [] {"3 - 4 = -3", "5 + 6 = 11", "-3 - 3 = -6"})));
		System.out.println(Arrays.toString(solution(new String [] {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"})));
	}

    public static String[] solution(String[] quiz){

	    String[] answer = new String [quiz.length];
	    for (int i=0; i<quiz.length; i++) {
	    	answer[i] = getResult(quiz[i]);
	    }
	    return answer;
//	    return Arrays.stream(quiz).map(s -> {
//            String[] arr = s.trim().split(" ");
//            return arr[1].equals("+") && Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) || Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) ? "O" : "X";
//        }).toArray(String[]::new);
    }

    public static String getResult(String str) {
    	List<String> list = Arrays.asList(str.split(" "));
    	int answer = calc(list.get(1), list.get(0), list.get(2));
    	int answerInCase = Integer.parseInt(list.get(4));
    	return answer == answerInCase ? "O" : "X";
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
/**
 * 3 - 4 = -3 : X
 * 5 + 6 = 11 : O
 *
 * 1. = 을 기준으로 수식과 답을 나눈다.
 * 2. 연산부를 실제로 연산해본다.
 * 3. 1.에서 넣은 답과 2에서 얻은 답을 비교한다.
 * 4. 판단하기 O 또는 X
 *
 * */
