package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PMS_011_MostFrequent {

	public static void main(String[] args) {
		int [] data = {1, 2, 3, 3, 3, 4};
		System.out.printf("before : %s \n", Arrays.toString(data));
		Arrays.sort(data);
		System.out.printf("after : %s \n", Arrays.toString(data));
		System.out.println(solution(data));
	}

    public static int solution(int[] array) {
    	// 준비 :
    	// [m][f]
    	// [메타값0][빈도0]
    	// [메타값1][빈도1] 로 구성된 2차원 리스트를 준비한다.
    	// 1. 배열을 정렬한다.
    	// 2. 리스트의 길이가 없거나, 기존의 m열의 값에 일치하는 값이 없다면 [m=메타값][f=1]
    	//   기존의 m열의 값에 일치하는 값이 있다면 해당 m열의 f행에 ++해준다.
    	// 3. f행을 기준으로 정렬한다.
    	// 4. 최대값을 구한다.
    	List<ArrayList<Integer>> lists = new ArrayList<>();

    	Arrays.sort(array);

    	for(int num : array) {
    		int matchValue = hasMatchValue(lists, num);
    		if (lists.size()==0 || matchValue == -1) {
    			ArrayList<Integer> list = new ArrayList<Integer>();
    			list.add(num);
    			list.add(1);
    			lists.add(list);
    		} else {
    			ArrayList<Integer> list = lists.get(matchValue);
    			list.set(1, (list.get(1)+1));
    		}
    	}
    	int targetIndex = sortAndGetRes(lists);
        int answer = 1 < checkDuplication(lists, targetIndex) ? -1 : lists.get(targetIndex).get(0);
        return answer;
    }

    public static int checkDuplication(List<ArrayList<Integer>> lists, int targetIndex) {
    	int cnt = 0;
    	int freqValue = lists.get(targetIndex).get(1);
    	for (ArrayList<Integer> list : lists) {
    		if (list.get(1) == freqValue) cnt++;
    	}
    	return cnt;
    }

    public static int sortAndGetRes(List<ArrayList<Integer>> lists) {

    	int max = 0;
    	int targetIndex = 0;
    	int i = 0;
    	for (ArrayList<Integer> list : lists) {
    		if (max == 0) {
    			max = list.get(1); i++;
    			continue;
    		}

    		if (max < list.get(1)) {
    			max = list.get(1);
    			targetIndex = i;
    		}

    		i++;
    	}

    	return targetIndex;
    }

    public static int hasMatchValue(List<ArrayList<Integer>> lists, int num) {
    	int i = 0;
    	for (ArrayList<Integer> list : lists) {
    		if (list.get(0) == num) return i;
    		i++;
    	}

    	return -1;
    }
}
