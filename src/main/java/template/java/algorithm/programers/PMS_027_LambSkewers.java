package template.java.algorithm.programers;

public class PMS_027_LambSkewers {

	public static void main(String[] args) {
		System.out.println(solution(10,3));
		System.out.println(solution(64,6));
	}

    public static int solution(int n, int k) {
    	// 양꼬치 수 n , 음료수 수 k
    	// 양꼬치 10개 마다 k-1
    	int skewersPrice = 12000 * n;
    	int beveragePrice = (2000 * k) - (((int)(n / 10)) * 2000 );
        int answer = skewersPrice + beveragePrice;
        return answer;
    }
}
