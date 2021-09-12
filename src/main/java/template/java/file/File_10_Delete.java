package template.java.file;

import template.java.utils.FileUtil;

public class File_10_Delete {
	
	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}

			String target = args[0];
			
			FileUtil fu = new FileUtil();
			
			System.out.println("Result " +fu.delete(target));

			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
