package template.java.algorithm.programers;

public class PMS_026_GetAngle {

	public static void main(String[] args) {
		System.out.println(solution(90));
	}

    public static int solution(int angle) {

    	if (angle == 180) return 4;
    	else if (angle > 90 && angle < 180) return 3;
    	else if (angle == 90) return 2;
    	else if (angle > 0 && angle < 90) return 1;
        return 0;
    }
}
