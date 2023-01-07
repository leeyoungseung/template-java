package template.java.algorithm.programers;

public class PMS_077_SqureSize {

	public static void main(String[] args) {
		System.out.println(solution(new int [][] {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}}));
	}

    // x1 - x2 * y2 - y3
    // 1. 양쪽 다 - 또는 + 이면 절대값의 감산
    // 2. 어딘가가 - 또는 + 또는 0은 절대값의 합산

    public static int solution(int[][] dots) {

    	int xMax = dots[0][0];
    	int xMin = dots[0][0];
    	int yMax = dots[0][1];
    	int yMin = dots[0][1];

    	for (int i=1; i<dots.length; i++) {
    		if (xMax < dots[i][0]) xMax = dots[i][0];
    		if (xMin > dots[i][0]) xMin = dots[i][0];
    		if (yMax < dots[i][1]) yMax = dots[i][1];
    		if (yMin > dots[i][1]) yMin = dots[i][1];
    	}
        // x중에서 가장 큰값 - x중에서 가장 작은 값 * y중에서 가장 큰값 - y중에서 가장 작은 값
        return (xMax - xMin) * (yMax - yMin);
    }
}
