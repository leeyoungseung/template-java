package template.java.algorithm.programers;

public class PMS_094_SumBinary {

	public static void main(String[] args) {
		System.out.println(solution("10", "11"));
		System.out.println(solution("1001", "1111"));
	}

    public static String solution(String bin1, String bin2) {
        int su1 = Integer.parseInt(bin1, 2);
        int su2 = Integer.parseInt(bin2, 2);
        return Integer.toBinaryString(su1+su2);
    }
}
