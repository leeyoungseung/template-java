package template.java.algorithm.programers;

public class PMS_054_369Game {

	public static void main(String[] args) {
		System.out.println(solution(3));
		System.out.println(solution(29423));
	}

    public static int solution(int order) {
        return String.valueOf(order).length() - String.valueOf(order).replaceAll("[369]", "").length();
        // return (int) Arrays.stream(String.valueOf(order).split("")).map(Integer::parseInt).filter(i -> i == 3 || i == 6 || i == 9).count();
    }
}
