package template.java.algorithm.programers;

import java.util.Scanner;

public class PMS_022_GetIsoscelesTriangle {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
        	StringBuilder sb = new StringBuilder();
        	for (int j=0; j<=i; j++) {
        		sb.append("*");
        	}
        	System.out.println(sb.toString());
        }
	}
}
