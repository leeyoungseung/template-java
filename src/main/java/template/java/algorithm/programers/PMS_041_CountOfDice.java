package template.java.algorithm.programers;

public class PMS_041_CountOfDice {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {1, 1, 1}, 1));
		System.out.println(solution(new int [] {10, 8, 6}, 3));
	}

    public static int solution(int[] box, int n) {
    	// 가로 / n = a
    	// 세로 / n = b
    	// a * b = 2차원의 주사위수
    	// 높이 / n = c
    	// a * b * c = 상자에 들어갈 주사위 수
        return (box[0] / n) * (box[1] / n) * (box[2] / n);
    }
}
