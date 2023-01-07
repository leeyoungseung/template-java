package template.java.algorithm.programers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PMS_088_IsFiniteDecimal {

	public static void main(String[] args) {
		System.out.println(solution(7,20));
		System.out.println(solution(11,22));
		System.out.println(solution(12,21));
	}

	public static int solution(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
		BigInteger b2 = BigInteger.valueOf(b);
		int gcd = b1.gcd(b2).intValue();

		a /= gcd;
		b /= gcd;

		List<Integer> list = new ArrayList<>();
		if (a%b==0) return 1;

		for (int i=2; i<=b; i++) {
			if (b%i==0) {
				int cnt=0;
				for (int j=2; j<=i; j++) {
					if (i%j==0) {
						cnt++;
					}
				}
				if (cnt==1) {
					list.add(i);
				}
			}
		}

		list.remove(Integer.valueOf(2));
		list.remove(Integer.valueOf(5));

		if (list.size() == 0) return 1;
		else return 2;
	}
}
