package template.java.algorithm.programers;

public class PMS_014_DividePizza2 {

	public static void main(String[] args) {
		System.out.printf("Pizza count : %d", solution(6));
		System.out.printf("Pizza count : %d", solution(10));
		System.out.printf("Pizza count : %d", solution(4));
	}

    public static int solution(int n) {
    	// 피자는 6조각으로 나눠짐
    	// 사람은 한명당 같은 피자조각이 분배되야함.
    	// 사람 % 피자조각수 == 0인 시점의 피자판수를 구하는거임

    	int cnt = 1;
    	int slice = 6;

    	while(true) {
    		if (slice % n  == 0) {
    			break;
    		} else {
        		slice += 6;
        		cnt++;
    		}
    	}

        int answer = cnt;
        return answer;
    }
}
