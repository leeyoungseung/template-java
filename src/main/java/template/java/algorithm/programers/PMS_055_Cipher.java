package template.java.algorithm.programers;

public class PMS_055_Cipher {

	public static void main(String[] args) {
		String data = "dfjardstddetckdaccccdegk";
		System.out.printf("data : %s, result : %s \n", data, solution(data, 4));
	}

    public static String solution(String cipher, int code) {
        char [] ary = cipher.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=code-1; i<ary.length; i+=code) {
        	sb.append(ary[i]);
        }
        return sb.toString();

//        return IntStream.range(0, cipher.length())
//        .filter(value -> value % code == code - 1)
//        .mapToObj(c -> String.valueOf(cipher.charAt(c)))
//        .collect(Collectors.joining());
    }
}
