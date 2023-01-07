package template.java.algorithm.programers;

public class PMS_098_CutPaper {

	public static void main(String[] args) {
		System.out.println(solution(2, 2));
		System.out.println(solution(2, 5));
		System.out.println(solution(1, 1));
	}

    public static int solution(int M, int N) {
        return (M == 1 && N == 1) ? 0  : M * N - 1;
    }
}
