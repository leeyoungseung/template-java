package template.java.algorithm.programers;

public class PMS_018_IceAmericano {

	public static void main(String[] args) {

	}

	public static int [] solution(int money) {
		// 가진돈 으로 살수 있는 최대 잔수 + 남은돈
		// 아메리카노 가격은? 5,500
		// 잔수 구하기 : 돈 - 5,500을 반복하기
		final int price = 5500;
		int cnt = 0;
		int asset = money;
		while (true) {
			if (price > money) break;
			asset -= price;
			if (price > asset) { cnt++; break; }
			else cnt++;
		}

		int totalPrice = cnt * price;
		int remein = money - totalPrice;
        int[] answer = {cnt,remein};
        return answer;
    }

}
