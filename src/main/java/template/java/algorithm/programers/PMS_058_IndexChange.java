package template.java.algorithm.programers;

public class PMS_058_IndexChange {

	public static void main(String[] args) {
		String data1 = "hello";
		String data2 = "I love you";
		System.out.printf("Origin : %s , num1 : %d , num2 : %d , Result : %s \n", data1, 1, 2, solution(data1, 1, 2));
		System.out.printf("Origin : %s , num1 : %d , num2 : %d , Result : %s \n", data2, 3, 6, solution(data2, 3, 6));
	}

    public static String solution(String my_string, int num1, int num2) {
        char [] ary = my_string.toCharArray();
        char num1C = ary[num1];
        char num2C = ary[num2];
        ary[num1] = num2C;
        ary[num2] = num1C;
        return String.valueOf(ary);
//        List<String> list = Arrays.stream(myString.split("")).collect(Collectors.toList());
//
//        Collections.swap(list, num1, num2);
//        return String.join("", list);
    }
}
