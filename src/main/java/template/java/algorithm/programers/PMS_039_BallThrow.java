package template.java.algorithm.programers;

public class PMS_039_BallThrow {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {1, 2, 3, 4}, 2));
		System.out.println(solution(new int [] {1, 2, 3, 4, 5, 6}, 5));
		System.out.println(solution(new int [] {1, 2, 3}, 3));
	}

    public static int solution(int[] numbers, int k) {

    	// 공을 던질때 위치는 바로 옆의 한칸을 건너 뛴다.
    	// n -> n+2
    	// n == length -> start+1 또는 n-1 == length의 경우 -> start가됨
    	// 공을 던질때마다 카운트하여 카운트 == k가 되면 종료

    	int throwCount = 1;
    	int index = 0;
    	while(true){
    		if (throwCount >= k) break;
    		index += 2;
    		throwCount++;
    		if (index >= numbers.length) index -= numbers.length;
    		System.out.printf("index : %d, value : %d, Cnt : %d \n", index, numbers[index], throwCount);
    	}
        return numbers[index];
    }
}
