package template.java.algorithm.programers;

public class PMS_017_Discount {

	public static void main(String[] args) {
		System.out.printf("Original Price : 150000, Discounted Price : %d \n", solution(150000));
		System.out.printf("Original Price : 580000, Discounted Price : %d \n", solution(580000));
	}

    public static int solution(int price) {
    	// 할인률 10만원 이상 5%, 30만원이상 10%, 50만원 이상 20%
    	double discountPercent = 0;
    	if (price >= 10 && price <= 10000000) {
	    	if (500000 <= price) discountPercent = 20;
	    	else if (300000 <= price) discountPercent = 10;
	    	else if (100000 <= price) discountPercent = 5;
	    	else return price;
    	} else
    		return price;

    	double discountPercentDouble = discountPercent * 0.01;
    	double discountPrice = price * discountPercentDouble;
        int answer = (int) Math.floor(price - discountPrice);
        return answer;
    }
}
