package template.java.algorithm.programers;

public class PMS_084_DicOfAlien {

	public static void main(String[] args) {
		String [] data1 = {"p", "o", "s"};
		String [] data2 = {"sod", "eocd", "qixm", "adio", "soo"};
		System.out.println(solution(data1, data2));
	}

    public static int solution(String[] spell, String[] dic) {
    	// spell에 들어있는 원소가 한번씩만 쓰여진 단어가 dic에 있는지?
    	// 1. 단어가 한번씩 들어가 있는지 -> spell과 dic의 이중for문으로 확인
    	// 2. 단어가 spell의 원소로만 이루어졌는지 -> spell과 완성단어의 길이로 비교하기
    	// 3. 판단하기 존재하면 1, 없으면 2

    	int answer = 2;
    	for (int i=0; i<dic.length; i++) {
    		int temp = 0;
	    	for (int j=0; j<spell.length; j++) {
	    		if ((dic[i].length()-1) == (dic[i].replaceAll(spell[j], "").length())) {
	    			temp++;
	    		}
	    	}
	    	if (temp == spell.length) {
	    		answer = 1;
	    		break;
	    	}
    	}

        return answer;
        // return Arrays.stream(dic).map(s -> s.chars().sorted().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining())).collect(Collectors.toList()).contains(Arrays.stream(spell).sorted().collect(Collectors.joining())) ? 1 : 2;
    }
}
