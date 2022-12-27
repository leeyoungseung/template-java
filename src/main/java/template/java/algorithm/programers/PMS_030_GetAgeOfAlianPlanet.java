package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_030_GetAgeOfAlianPlanet {

	public static void main(String[] args) {
		int age = 23;
		System.out.printf("Age : %d, Result : %s", age, solution(age));
	}

    public static String solution(int age) {
    	// 숫자를 아스키코드로 변환해보자
    	// 23은 2 = c , 3 = d가 되어야한다.
    	// 아스키코드에서 c = 99, d = 100이다.
    	// 입력받은 숫자에서 + 97을 해주면 아스키코드 변환이 가능하다.
    	// (1) 입력받은 숫자를 char[] -> int 로
    	// (2) 97씩 더한후 char[] -> String으로

    	char [] array = String.valueOf(age).toCharArray();
    	StringBuilder sb = new StringBuilder();
    	for (char c : array) {
    		int temp = Integer.parseInt(""+c);
    		temp += 97;
    		sb.append((char)temp);
    	}
        return sb.toString();
    }

}


