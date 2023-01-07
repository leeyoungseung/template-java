package template.java.algorithm.programers;

public class PMS_096_CountOfK {

	public static void main(String[] args) {
		System.out.println(solution(1,13,1));
	}

    public static int solution(int i, int j, int k) {
    	int answer = 0;
    	for (int su=i; su<=j; su++) {
    		int temp = String.valueOf(su).length() - String.valueOf(su).replaceAll((String.valueOf(k)), "").length();
    		if (temp > 0) {
    			answer+=temp;
    			//System.out.printf("Input : %d , Count : %d \n", su, answer);
    		}
    	}
        return answer;
    }
}
