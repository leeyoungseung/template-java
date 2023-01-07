package template.java.algorithm.programers;

public class PMS_092_SuccessLogin {

	public static void main(String[] args) {
		System.out.println(solution(new String [] {"meosseugi", "1234"},
				new String [][] {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}}));
	}

	/**
	 * 아이디와 비밀번호가 모두 일치하는 회원정보가 있으면 "login"을 return합니다.
	 * 로그인이 실패했을 때 아이디가 일치하는 회원이 없다면 “fail”를,
	 * 아이디는 일치하지만 비밀번호가 일치하는 회원이 없다면 “wrong pw”를 return 합니다.
	 */
    public static String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        String id = id_pw[0];
        String pw = id_pw[1];

        for (int i=0; i<db.length; i++) {
        	if (db[i][0].equals(id) && db[i][0].length() < 16) {
        		if (db[i][1].equals(pw) && db[i][1].length() < 7) {
        			answer = "login";
        		} else {
        			answer = "wrong pw";
        		}
        	}
        }

        return answer;
    }
}
