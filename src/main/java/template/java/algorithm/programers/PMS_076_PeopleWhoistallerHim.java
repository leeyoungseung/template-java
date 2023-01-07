package template.java.algorithm.programers;

import java.util.Arrays;

public class PMS_076_PeopleWhoistallerHim {

	public static void main(String[] args) {
		System.out.println(solution(new int [] {149, 180, 192, 170}, 167));
	}

    public static int solution(int[] array, int height) {
        int answer = 0;
        Arrays.sort(array);
        for (int i=0; i<array.length; i++) {
        	if (array[i] > height) {
        		answer = array.length - i;
        		break;
        	}
        }
        return answer;
        // return (int) Arrays.stream(array).filter(value -> value > height).count();
    }
}
