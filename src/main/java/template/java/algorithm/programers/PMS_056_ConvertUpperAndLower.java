package template.java.algorithm.programers;

public class PMS_056_ConvertUpperAndLower {

	public static void main(String[] args) {
		String data = "cccCCC";
		System.out.printf("data : %s, result : %s \n", data, solution(data));
	}

    public static String solution(String my_string) {
        char [] ary = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<ary.length; i++) {
        	int temp = ary[i];
        	if ((int) ary[i] >= 97) {
        		temp -= 32;
        		sb.append((char)temp);
        	}
        	else {
        		temp += 32;
        		sb.append((char)temp);
        	}
        }
        return sb.toString();
        // return myString.chars().mapToObj(operand -> String.valueOf((char) (Character.isLowerCase(operand) ? Character.toUpperCase(operand) : Character.toLowerCase(operand)))).collect(Collectors.joining());

    }
}
