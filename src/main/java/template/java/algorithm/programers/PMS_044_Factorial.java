package template.java.algorithm.programers;

public class PMS_044_Factorial {

	public static void main(String[] args) {
		System.out.println(solution(7));
	}

    public static int solution(int n) {
        int answer = 1;
        while(true) {
        	int f = getFactorial(answer);
        	if (f == n) break;
        	else if (f > n) {answer--; break;}
        	answer++;
        }
        return answer;
    }

    public static int getFactorial(int n) {
    	if (n==0) {
    		return 1;
    	} else {
    		return n * getFactorial(n-1);
    	}
    }
}
