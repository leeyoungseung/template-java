package template.java.algorithm.programers;

public class PMS_028_GetEvenArraySum {

	public static void main(String[] args) {
		int n = 10;
		System.out.printf("len : %d , result : %d \n", n, solution(n));
		n = 4;
		System.out.printf("len : %d , result : %d \n", n, solution(n));
	}

    public static int solution(int n) {
    	int sum = 0;
    	for (int i=1; i<=n; i++) {
    		if (i % 2 == 0) sum += i;
    	}
        return sum;
    }
}
