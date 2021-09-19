package template.java.file;

import java.io.File;
import java.util.List;

import template.java.utils.FileUtil;

public class File_02_Read {

	public static void main(String[] args) {
		
		try {
			File target = new File(args[0]);
			FileUtil fu = FileUtil.getInstance();
			List<String> list = fu.readPerLine(target);
			
			list.forEach(res -> {
				System.out.println("File Contents : "+ res);
			});
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
