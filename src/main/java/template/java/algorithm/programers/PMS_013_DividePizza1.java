package template.java.algorithm.programers;

public class PMS_013_DividePizza1 {

	public static final int PIZZA_SLICE = 7;
	public static int PIZZA_COUNT = 1;

	public static void main(String[] args) {
//		System.out.printf("Pizza count : %d", solution(7));
		System.out.printf("Pizza count : %d", solution(1));
//		System.out.printf("Pizza count : %d", solution(15));
	}

    public static int solution(int n) {
    	// 피자는 7조각으로 나눠짐
    	// 사람은 한명당 1개의 피자 조각이 분배되어야함.
    	// 사람 % 피자조각 != 0 이면 한판을 추가해야함
    	// 못먹은 사람 으로 다시 사람 % 피자조각 != 0를 반복한다.

        int answer = pizzaMatch(n);
        return answer;
    }

    public static int pizzaMatch(int people) {
    	if (people % PIZZA_SLICE != 0 || PIZZA_SLICE < people) {

    		people = people - PIZZA_SLICE;

    		if (people <= 0) {
    			return PIZZA_COUNT++;
    		}

    		PIZZA_COUNT++;
    		return pizzaMatch(people);
    	} else {
    		return PIZZA_COUNT;
    	}
    }
}
