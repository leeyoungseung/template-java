package template.java.algorithm.programers;

public class PMS_097_PushString {

	public static void main(String[] args) {
		System.out.println(solution("hello"	, "ohell"));
		System.out.println(solution("apple"	, "elppa"));
	}

    public static int solution(String A, String B) {

    	if (A.equals(B)) return 0;

        int answer = -1;
        String [] ary = A.split("");
        String shiftStr = "";

        for (int i=1; i<ary.length; i++) {

        	shiftStr = ary[ary.length-1];
        	for (int j=ary.length-1; j>=1; j--) {
        		ary[j] = ary[j-1];
        	}
        	ary[0] = shiftStr;

        	if (String.join("", ary).equals(B)) {
        		answer = i;
        		break;
        	}
        }

        return answer;
        // return (B+B).indexOf(A);
    }
}
