package template.java.algorithm.programers;

public class PMS_007_SumFountain {

	public static void main(String[] args) {
		int[] answer = solution(1,2,1,2);
		System.out.printf("ary[1] = %d, ary[2] = %d \n", answer[0], answer[1]);
		answer = solution(9,2,1,3);
        System.out.printf("ary[1] = %d, ary[2] = %d \n", answer[0], answer[1]);
		answer = solution(1,2,1,2);
        System.out.printf("ary[1] = %d, ary[2] = %d \n", answer[0], answer[1]);
	}

    public static int[] solution(int denum1, int num1, int denum2, int num2) {

    	// 두 분수를 더한 값의 분자를 answer[0], 분모를 answer[1]에 넣어 리턴한다.
    	// 분수의 덧셈 공식
    	// 1. 분모의 최대 공약수(GCD)를 구한다. (유클리드 호제법 사용)
    	// 2. 분모의 최소 공배수(LCM)를 구한다. = (분모1 * 분모2) / 최대공약수
    	// 3. a = (LCM / 분모1) * num1 과 b = (LCM / 분모2) * num2 의 값을 구한다.
    	// 4. answer[0] = a + b, answer[1] = LCM
    	// 5. 결과 값이 기약분수인지 다시한번 확인하기

    	int lcmOfDeno = lcm(num1, num2, gcd(num1, num2));
    	int sumOfNume = ((lcmOfDeno / num1) * denum1) + ((lcmOfDeno / num2) * denum2);
        // int[] answer = {sumOfNume, lcmOfDeno};        // -- 이거 제출해서 틀림

    	// 기약분수 추려내서 다시답변해보자
    	int gcdOfRes1 = gcd(sumOfNume, lcmOfDeno);
    	int[] answer = {(sumOfNume / gcdOfRes1), (lcmOfDeno / gcdOfRes1)};

        return answer;
    }

    // 최대 공약수 구하기
    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }

    // 최소 공배수 구하기
    public static int lcm(int num1, int num2, int gcd) {
    	return (num1 * num2) / gcd;
    }

}
