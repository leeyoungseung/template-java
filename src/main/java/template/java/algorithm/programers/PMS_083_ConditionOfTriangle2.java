package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_083_ConditionOfTriangle2 {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {1, 2}));
		System.out.println(solution(new int [] {3, 6}));
		System.out.println(solution(new int [] {11, 7}));
	}

    public static int solution(int[] sides) {
//        Set<Integer> set = new HashSet<Integer>();
//        // 1.
//        Arrays.sort(sides);
//        // 2-1
//        for (int i=1; i<=sides[1]; i++) {
//        	if (sides[1] < i + sides[0]) {
//        		System.out.println("case 2-1 : " +i);
//        		set.add(i);
//        	}
//        }
//        // 2-2
//        int m = (sides[0]+sides[1]);
//        for (int i=1; i<m; i++) {
//        	if (m < i + sides[0]) {
//        		System.out.println("case 2-2 : " +i);
//        		set.add(i);
//        	}
//        	if (m < i + sides[1]) {
//        		System.out.println("case 2-2 : " +i);
//        		set.add(i);
//        	}
//        }
//		  return set.size();
    	Arrays.sort(sides);
        return sides[0] * 2 - 1;
    }

    // 1. sides를 정렬
    // 2. sides[1]이 가장큰 경우 / side[2]이 가장큰 경우를 추려내야함.
    //   sides[1]이 가장큰 경우 : side[0]++ sides[1]까지
    //   sides[2]이 가장큰 경우 : side[1]++ (side[0] + side[1])
    // 3. 2.에서 추려낸 패턴의 수를 더하기

/*
 * 가장큰 변은 다른 2개의 변의 합보다 작음.
 * 변이 2개 주어짐
 * A. 주어진 변 중에 가장 큰 변(n)이 있는 경우
 *  -> 1 부터 n까지 반복하며, i + (n-1)이 > n까지 반복
 * B. 주어진 두 변중에 가장 큰 변(m)이 없는 경우
 *  -> (n)+(n-1)-1까지 반복하며
 *    -->  i + (n-1)이 > m
 *    -->  i + (n)이 > m
 * */
}
