package template.java.algorithm.programers;

public class PMS_070_IsSquare {

	public static void main(String[] args) {
		System.out.println(solution(144));
		System.out.println(solution(976));
	}

    public static int solution(int n) {
        boolean status = false;
        for (int i=1; i<=n; i++) {
        	status = (i*i) == n ? true : false;
        	if (status) break;
        }
        return status ? 1 : 2;
        // return Math.sqrt(n) % 1 == 0 ? 1 : 2;
    }
}
