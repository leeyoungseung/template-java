package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_089_SpecialSort {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int [] {1, 2, 3, 4, 5, 6}, 4)));
		System.out.println(Arrays.toString(solution(new int [] {10000,20,36,47,40,6,10,7000}, 30)));
	}

    public static int[] solution(int[] numlist, int n) {
    	// n , n+1 , n-1 , n+2 , n-2... 형식으로 이어진다.
    	// n+1은 10000까지 반복 // n-1은 1까지 반복한다.
    	// 반복하며 해당하는 숫자값이 numlist에 있는지 확인한다.
    	int[] answer = new int [numlist.length];
    	int up = n;
    	int down = n;
    	int i = 0;
    	while (true) {
    		up++;
    		down--;
    		if (isMatch(numlist, n) && i==0) {
    			answer[i] = n;
    			System.out.printf("n %d 번째 현재 값 : %s \n", i, Arrays.toString(answer));
    			i++;
    		}

    		if (isMatch(numlist, up)) {
    			answer[i] = up;
    			System.out.printf("up %d 번째 현재 값 : %s \n", i, Arrays.toString(answer));
    			i++;
    		}

    		if (isMatch(numlist, down)) {
    			answer[i] = down;
    			System.out.printf("dw %d 번째 현재 값 : %s \n", i, Arrays.toString(answer));
    			i++;
    		}

    		if (i>=numlist.length || (up > 10000 && down < 1)) {
    			break;
    		}
    	}

        return answer;
//        return Arrays.stream(numList)
//                .boxed()
//                .sorted((a, b) -> Math.abs(a - n) == Math.abs(b - n) ? b.compareTo(a) : Integer.compare(Math.abs(a - n), Math.abs(b - n)))
//                .mapToInt(Integer::intValue)
//                .toArray();
    }

    public static boolean isMatch(int [] numlist, int target) {
    	return Arrays.stream(numlist).anyMatch(x -> x == target);
    }
}
