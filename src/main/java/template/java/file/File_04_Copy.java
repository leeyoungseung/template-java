package template.java.file;

import template.java.utils.FileUtil;

public class File_04_Copy {
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			
			// Case 1 : 파일 복사 
			String oldPath1 = args[0];
			String newPath1 = args[1];
			
			// Case 2 : 파일 복사(덮어쓰기)
			String oldPath2 = args[2];
			String newPath2 = args[3];
			
			
			FileUtil fu = new FileUtil();
			System.out.println("Case 1 : "+ fu.copy(oldPath1, newPath1, false));
			
			System.out.println("Case 2 failure : "+ fu.copy(oldPath2, newPath2, false));
			System.out.println("Case 2 success : "+ fu.copy(oldPath2, newPath2, true));
			
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
