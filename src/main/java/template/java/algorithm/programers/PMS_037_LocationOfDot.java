package template.java.algorithm.programers;

public class PMS_037_LocationOfDot {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2,4}));
		System.out.println(solution(new int[]{-7,9}));
	}

    public static int solution(int[] dot) {

    	if (dot[0]>0 && dot[1]>0) return 1;
    	else if (!(dot[0]>0) && dot[1]>0) return 2;
    	else if (!(dot[0]>0) && !(dot[1]>0)) return 3;
    	else if (dot[0]>0 && !(dot[1]>0)) return 4;
    	else return 0;
    }
}
