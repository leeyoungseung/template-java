package template.java.algorithm.programers;

public class PMS_042_GetCompositionNumber {

	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(15));
	}

    public static int solution(int n) {
    	// # 용어 정리
    	// 합성수 : 약수의 개수가 세 개 이상인 수, 약수 : 어떤수를 나누었을 때 나머지가 없게하는 수
    	// n까지 반복해서 숫자를 출력
    	// i에 해당하는 약수의 갯수를 출력
    	// i약수 갯수가 3이상이면 카운트 증가

        int answer = 0;
        for (int i=1; i<=n; i++) {
        	int a = getDivisorCount(i);
        	if (a >= 3) answer++;
        }
        return answer;
    }

    public static int getDivisorCount(int su) {
    	int cnt = 0;
    	for (int i=1; i<=su; i++) {
    		if (su % i == 0) cnt++;
    	}
    	return cnt;
    }
}
