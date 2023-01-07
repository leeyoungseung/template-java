package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_078_LocationOfCharacter {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String [] {"down", "down", "down", "down", "down"}, new int [] {7, 9})));
		System.out.println(Arrays.toString(solution(new String [] {"left", "left", "left", "right"}, new int [] {3, 3})));
		System.out.println(Arrays.toString(solution(new String [] {"up", "up", "up", "down"}, new int [] {3, 3})));
		System.out.println(Arrays.toString(solution(new String [] {"down", "down", "up", "up", "up"}, new int [] {3, 3})));
	}

    public static int[] solution(String[] keyinput, int[] board) {
        int[] res = {0, 0};

        int lengthW = board[0] / 2; // left, right 제한
        int lengthH = board[1] / 2; // up, down 제한

        int i = 0;
        for (String cmd : keyinput) {
        	i++;
        	System.out.printf("Cmd-Length : %d, Cmd-Count : %d \n", keyinput.length, i);
        	switch (cmd) {
    		case "left":
    			if (Math.abs(res[0]) < lengthW || res[0] >= 0) {res[0]--; }
    			break;
    		case "right":
    			if (Math.abs(res[0]) < lengthW || res[0] <= 0) {res[0]++; }
    			break;
    		case "up":
    			if (Math.abs(res[1]) < lengthH || res[1] <= 0) {res[1]++; }
    			break;
    		case "down":
    			if (Math.abs(res[1]) < lengthH || res[1] >= 0) {res[1]--; }
    			break;
    		}

        }

        if (res[0] > lengthW) res[0]=lengthW;
        if (-res[0] > lengthW) res[0]=(-lengthW);
        if (res[1] > lengthH) res[1]=(-lengthH);
        if (-res[1] > lengthH) res[1]=(-lengthH);

        return res;
    }
}
