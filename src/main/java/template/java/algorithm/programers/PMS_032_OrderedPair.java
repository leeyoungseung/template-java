package template.java.algorithm.programers;

public class PMS_032_OrderedPair {

	public static void main(String[] args) {
		System.out.println(solution(20));
		System.out.println(solution(100));
	}

    public static  int solution(int n) {
        // 자연수 n이 매개변수로 주어질 때 두 숫자의 곱이 n인 자연수 순서쌍의 개수를 return
    	// 결국엔 약수 구하기
        int answer = 0;
    	for (int i=1; i<=n; i++) {
    		if (n % i ==0) answer++;
    	}
        return answer;
    }
}
