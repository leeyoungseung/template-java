package template.java.algorithm.programers;

public class PMS_091_Babbling {

	public static void main(String[] args) {
		System.out.println(solution(new String [] {"aya", "yee", "u", "maa", "wyeoo"}));
		System.out.println(solution(new String [] {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
	}

    public static int solution(String[] babbling) {
        int answer = 0;

        for (int i=0; i<babbling.length; i++) {
            if (babbling[i].replaceAll("aya|ye|woo|ma", "").length() == 0) answer++;
        }

        return answer;
    }
}
