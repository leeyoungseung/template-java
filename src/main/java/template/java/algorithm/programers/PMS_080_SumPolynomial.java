package template.java.algorithm.programers;

import java.util.ArrayList;
import java.util.List;

public class PMS_080_SumPolynomial {

	public static void main(String[] args) {
		System.out.println(solution("3x + 7 + x"));
		System.out.println(solution("x + x + x"));
		System.out.println(solution("3 + 4 + 12"));
	}

    public static String solution(String polynomial) {

        String [] ary = polynomial.split(" ");
        List<String> listX = new ArrayList<>();
        List<String> listN = new ArrayList<>();
        for (int i=0; i<ary.length; i++) {
        	if (ary[i].matches("(.*)x(.*)")) listX.add(ary[i]);
        	else if (ary[i].matches("[0-9]+"))listN.add(ary[i]);
        }

        int resN = listN.stream().mapToInt(s -> Integer.parseInt(s)).sum();
        int countX = 0;
        for (int i=0; i<listX.size(); i++) {
        	if (listX.get(i).length()==1) {
        		countX++;
        	} else {
        		countX += Integer.parseInt(listX.get(i).replaceAll("x", ""));
        	}
        }

        String resX = (countX == 1) ? "x" : (countX == 0) ? "" : countX+"x";

        if (resX.equals("") && resN == 0) {
        	return "";
        } else if (resX.length() >= 1 && resN == 0) {
        	return resX;
        } else if (resX.equals("") && resN >= 1) {
        	return ""+resN;
        } else {
        	return resX + " + " + resN;
        }
    }
}
