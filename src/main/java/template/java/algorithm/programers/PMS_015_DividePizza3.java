package template.java.algorithm.programers;

public class PMS_015_DividePizza3 {

	public static int PIZZA_COUNT = 1;

	public static void main(String[] args) {
//		System.out.printf("Pizza count : %d \n", solution(7, 10));
		System.out.printf("Pizza count : %d \n", solution(4, 12));
	}

    public static int solution(int slice, int n) {

    	if (n % slice != 0 || slice < n) {

    		n = n - slice;

    		if (n <= 0) {
    			return PIZZA_COUNT++;
    		}

    		PIZZA_COUNT++;
    		return solution(slice, n);
    	} else {
    		return PIZZA_COUNT;
    	}
    }
}
