package template.java.algorithm.programers;

public class PMS_085_CurseNumber3 {

	public static void main(String[] args) {
		System.out.println(solution(15));
		System.out.println(solution(40));
	}

    public static int solution(int n) {
        int answer = 0;
        int count=0;

        while (count < n) {
        	answer++;
        	count++;
        	answer = getVal(answer);
        	System.out.printf("while 1 Count : %d , Answer :  %d \n", count, answer);

        }

        return answer;
    }


    public static int getVal(int num) {
    	if (num % 3 == 0 || String.valueOf(num).matches("(.*)3(.*)")) {
    		num++;
    		return getVal(num);
    	} else {
    		return num;
    	}
    }
}
