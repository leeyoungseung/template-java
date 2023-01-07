package template.java.algorithm.programers;

public class PMS_061_Letter {

	public static void main(String[] args) {
		String data = "happy birthday!";
		System.out.printf("Message : %s, result : %d \n", data, solution(data));
		data = "I love you~";
		System.out.printf("Message : %s, result : %d \n", data, solution(data));
	}

    public static int solution(String message) {
        return message.length() * 2;
    }
}
