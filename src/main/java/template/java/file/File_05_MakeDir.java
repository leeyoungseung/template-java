package template.java.file;

import template.java.utils.FileUtil;

public class File_05_MakeDir {
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}

			String path = args[0];
			FileUtil fu = FileUtil.getInstance();
			
			System.out.println("Case 1 : "+ fu.makeDir(path));
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
