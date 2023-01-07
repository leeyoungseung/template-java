package template.java.algorithm.programers;

public class PMS_071_GermMultiplication {

	public static void main(String[] args) {
		System.out.println(solution(2,10));
		System.out.println(solution(7,15));
	}

    public static int solution(int n, int t) {
        long answer = n;
        for (int i=1; i<=t; i++) {
        	answer *= 2;
        }
        return (int)answer;
        // return n * (int)Math.pow(2,t);
    }
}
