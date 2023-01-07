package template.java.algorithm.programers;

public class PMS_087_Overlap {

	public static void main(String[] args) {
		System.out.println(solution(new int [][] {{0, 1}, {2, 5}, {3, 9}}));
		System.out.println(solution(new int [][] {{-1, 1}, {1, 3}, {3, 9}}));
		System.out.println(solution(new int [][] {{0, 5}, {3, 9}, {1, 10}}));
	}

    public static int solution(int[][] lines) {

        // 2개 이상의 선분이 겹치는 경우 겹치는 길이를 리턴해야함.
        // 3개의 선분이 주어짐 -> 3개의 배열
        // 선분의 길이는 -100 ~ 0 ~ 100 까지 -> 계산하기 쉽게 0~200으로 하자
        // 3템플릿에 3개의 배열을 매칭시킨다. -> 배열의 숫자 범위 안은 1 아니면 0(기본값)
        // 매칭이 끝난 후 템플릿을 0~200까지 반복한 후 인덱스 요소의 합이 2이상인경우의 수를 센다.
    	int answer = 0;
    	int [] a = new int [201];
    	int [] b = new int [201];
    	int [] c = new int [201];

    	for (int i=(lines[0][0]+100); i<(lines[0][1]+100); i++) {
    		a[i] = 1;
    	}

    	for (int i=(lines[1][0]+100); i<(lines[1][1]+100); i++) {
    		b[i] = 1;
    	}

    	for (int i=(lines[2][0]+100); i<(lines[2][1]+100); i++) {
    		c[i] = 1;
    	}

    	for (int i=0; i<a.length; i++) {
    		if (a[i]+b[i]+c[i] >= 2) {
    			answer++;
    		}
    	}

        return answer;
    }
}
