package template.java.file;

import template.java.utils.FileUtil;

public class File_03_Rename {

	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			
			// Case 1 : 파일명 변경 
			String oldPath1 = args[0];
			String newPath1 = args[1];
			
			// Case 2 : 파일 이동
			String oldPath2 = args[2];
			String newPath2 = args[3];
			
			// Case 3 : 파일 이동 (덮어쓰기) 
			String oldPath3 = args[4];
			String newPath3 = args[5];
			
			FileUtil fu = new FileUtil();
			System.out.println("Case 1 : "+ fu.rename(oldPath1, newPath1, false));
			
			System.out.println("Case 2 : "+ fu.rename(oldPath2, newPath2, false));
			
			System.out.println("Case 3 failure : "+ fu.rename(oldPath3, newPath3, false));
			
			System.out.println("Case 3 success : "+ fu.rename(oldPath3, newPath3, true));
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
