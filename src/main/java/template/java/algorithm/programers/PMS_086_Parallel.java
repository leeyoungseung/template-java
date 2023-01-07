package template.java.algorithm.programers;

import java.util.ArrayList;

public class PMS_086_Parallel {

	public static void main(String[] args) {
		System.out.println(solution(new int [][] {{1, 4}, {9, 2}, {3, 8}, {11, 6}}));
		System.out.println(solution(new int [][] {{3, 5}, {4, 1}, {2, 4}, {5, 10}}));
	}

    public static int solution(int[][] dots) {
    	int answer = 0;
        ArrayList<Double> list = new ArrayList<Double>();
        for (int i=0; i<dots.length; i++) {
        	for (int j=i+1; j<dots.length; j++) {
        		double a = (dots[i][1] - dots[j][1]);
        		double b =  (dots[i][0] - dots[j][0]);
        		double lean = a / b;
        		list.add(lean);
        	}
        }

        for (int i=0; i<list.size(); i++) {
        	double tmp = list.get(i);
        	for (int j=i+1; j<list.size(); j++) {
        		if (tmp == list.get(j)) {
        			answer = 1;
        			break;
        		}
        	}
        }

        return answer;
    }
}
