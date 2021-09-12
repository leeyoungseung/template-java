package template.java.file;

import template.java.utils.FileUtil;

public class File_06_CopyRecursively {

	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}

			String origin = args[0];
			String dest = args[1];
			String separator = args[2];
			
			FileUtil fu = new FileUtil();
			fu.setPathSeparator(separator);
			
			System.out.println("Result " +fu.copys(origin, dest, true));

			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
