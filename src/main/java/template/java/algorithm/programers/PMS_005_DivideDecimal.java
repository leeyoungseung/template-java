package template.java.algorithm.programers;

public class PMS_005_DivideDecimal {

    public static void main(String[] args) {
    	System.out.println(solution(3,2));
	}

    public static int solution(int num1, int num2) {
    	// 부동소수점계산할때는 부동소수점수의 변수로 형변환을 먼저하자
        int answer = (int)((double)num1 / (double)num2 * 1000);
        return answer;
    }

}
