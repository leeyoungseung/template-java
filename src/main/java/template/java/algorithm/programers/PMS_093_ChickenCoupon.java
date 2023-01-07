package template.java.algorithm.programers;

public class PMS_093_ChickenCoupon {

	public static void main(String[] args) {
		System.out.println(solution(1081));
	}

    public static  int solution(int chicken) {
    	int answer = 0;
        int remainCoupon = chicken % 10;
        int coupon = chicken / 10;

        answer += coupon;
        coupon += remainCoupon;
        while (true) {
            remainCoupon = coupon % 10;
            coupon = coupon / 10;
            answer += coupon;
            if (coupon == 0) {
                break;
            }
            coupon += remainCoupon;
        }

        return answer;
    }
}
