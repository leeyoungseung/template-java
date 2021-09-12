package template.java.file;

import template.java.utils.FileUtil;

public class File_08_SetPermission {
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			
			String path = args[0];
			String value = args[1];
			FileUtil fu = new FileUtil();
			
			System.out.println("Before : "+ fu.checkPermission(path));
			
			System.out.println("Result : "+ fu.setPermission(path, Integer.parseInt(value)));
			
			System.out.println("After : "+ fu.checkPermission(path));
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
