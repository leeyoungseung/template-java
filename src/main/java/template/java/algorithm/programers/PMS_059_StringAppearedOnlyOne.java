package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PMS_059_StringAppearedOnlyOne {

	public static void main(String[] args) {
		String data = "abcabcadc";
		System.out.printf("Origin : %s, Result : %s \n", data , solution(data));
		data = "abdc";
		System.out.printf("Origin : %s, Result : %s \n", data , solution(data));
		data = "hello";
		System.out.printf("Origin : %s, Result : %s \n", data , solution(data));
	}

    public static String solution(String s) {
	    List<String> list = new ArrayList<String>();
	    for (String str : s.split("")) {
	    	if ((s.length() - s.replaceAll(str, "").length()) == 1) list.add(str);
	    }
	    Collections.sort(list);
	    return String.join("", list);
    }
//    return Arrays.stream(s.split(""))
//            .collect(Collectors.groupingBy(s1 -> s1))
//            .entrySet()
//            .stream()
//            .filter(entry -> entry.getValue().size() <= 1)
//            .map(Map.Entry::getKey)
//            .sorted()
//            .collect(Collectors.joining());

}
