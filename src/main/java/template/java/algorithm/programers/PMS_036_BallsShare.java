package template.java.algorithm.programers;

import java.math.BigInteger;

public class PMS_036_BallsShare {

	public static void main(String[] args) {
		System.out.println(solution(3,2));
		System.out.println(solution(5,3));
	}

    public static long solution(int balls, int share) {
    	// 공식
    	// n! / (n-m)! * m!
    	// balls! / (balls - share)! * share!
    	BigInteger n = BigInteger.valueOf(balls);
    	BigInteger m = BigInteger.valueOf(share);
    	BigInteger childResult = getFactorial(n);
    	BigInteger parentsAResult = getFactorial(n.subtract(m));
    	BigInteger parentsBResult = getFactorial(m);
    	BigInteger parentsResult = parentsAResult.multiply(parentsBResult);
    	BigInteger result =childResult.divide(parentsResult);
        return result.longValue();
    }

    public static BigInteger getFactorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(getFactorial(n.subtract(BigInteger.ONE)));
    }
}
