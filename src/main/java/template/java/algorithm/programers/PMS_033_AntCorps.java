package template.java.algorithm.programers;

public class PMS_033_AntCorps {

	public static void main(String[] args) {
		System.out.println(solution(23));
	}

    public static  int solution(int hp) {
    	int [] corps = {5, 3, 1};
        int answer = 0;
    	for (int i=0; i<corps.length; i++) {
    		answer += hp / corps[i];
    		int temp = hp % corps[i];
    		if (temp == 0) break;
    		hp = temp;
    	}
        return answer;
    }
}
