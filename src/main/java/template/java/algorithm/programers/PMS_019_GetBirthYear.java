package template.java.algorithm.programers;

public class PMS_019_GetBirthYear {

	public static void main(String[] args) {
		System.out.printf("Age : %d, BirthYear : %d \n ", 40, solution(40));
	}

    public static int solution(int age) {
    	// 기준 년도 2022년으로 출생년도 구하기
        int answer = (2022 - age) + 1;
        return answer;
    }

}
