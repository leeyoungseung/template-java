package template.java.file;

import template.java.utils.FileUtil;

public class File_07_CheckPermission {

	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}

			String path = args[0];
			FileUtil fu = new FileUtil();
			
			System.out.println("Result : "+ fu.checkPermission(path));
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
