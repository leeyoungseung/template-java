package template.java.algorithm.programers;

public class PMS_082_SafeZone {

	public static void main(String[] args) {
		System.out.println("result " + solution(new int [][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}));
		System.out.println("result " + solution(new int [][] {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1},{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}));
	}

    public static int solution(int[][] board) {

        // 0: 안전 , 1: 지뢰 , 2: 지뢰범위
        // 1. (i,j) 가 1이라면 아래의 범위가 2가됨
        // (i-1, j-1)(i-1, j)(i-1, j+1)
        // (i, j-1)(i, j)(i, j+1)
        // (i+1, j-1)(i+1, j)(i+1, j+1)
        // 2. i와 j의 min, max값을 넘는경우는 2로 변환자체를 안함.
        // 3. 이미 1인경우 또는 이미 2인경우 2로 변하지 않음.
        // 4. 마지막의 배열의 요소 중 0의 갯수를 세어서 리턴

        final int maxI = board.length;
        final int maxJ = board[0].length;
        final int min = 0;

        int cnt = 0;
        for (int i=min; i<maxI; i++) {
        	for (int j=min; j<maxJ; j++) {
        		//System.out.println(cnt);
        		if (board[i][j]==1) {
        			if (((i-1) >= min && (j-1) >= min) && board[i-1][j-1] == 0) board[i-1][j-1] = 2;
        			if (((i-1) >= min && j < maxJ) && board[i-1][j] == 0) board[i-1][j] = 2;
        			if (((i-1) >= min && (j+1) < maxJ) && board[i-1][j+1] == 0) board[i-1][j+1] = 2;

        			if (((i >= min && i < maxI ) && (j-1) >= min) && board[i][j-1] == 0) board[i][j-1] = 2;
        			if (((i >= min && i < maxI ) && (j+1) < maxJ) && board[i][j+1] == 0) board[i][j+1] = 2;

        			if (((i+1) < maxI && (j-1) >= min) && board[i+1][j-1] == 0) board[i+1][j-1] = 2;
        			if (((i+1) < maxI) && board[i+1][j] == 0) board[i+1][j] = 2;
        			if (((i+1) < maxI && (j+1) < maxJ) && board[i+1][j+1] == 0) board[i+1][j+1] = 2;

        		}
        		cnt++;
        	}
        }

        int answer = 0;
        for (int i=0; i<maxI; i++) {
        	for (int j=0; j<maxJ; j++) {
        		if (board[i][j]==0) answer++;
        	}
        }

        return answer;
    }
}
