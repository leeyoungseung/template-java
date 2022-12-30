package template.java.algorithm.programers;

public class PMS_051_RepeatCharsInString {

	public static void main(String[] args) {
		System.out.printf("data : %s , result : %s \n", "people", solution("people"));
	}

    public static String solution(String my_string) {
    	StringBuilder sb = new StringBuilder();
    	for (int i=0; i<my_string.length(); i++) {
    		if (my_string.indexOf(my_string.charAt(i)) == i) {
    			sb.append(my_string.charAt(i));
    		}
    	}
        return sb.toString();
        //return Arrays.stream(myString.split("")).distinct().collect(Collectors.joining());
    }
}
