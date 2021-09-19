package template.java.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import template.java.utils.FileUtil;

public class File_01_Write {

	public static void main(String[] args) {
		
		try {
			File target = new File(args[0]);
			
			List<String> contents = new ArrayList<String>();
			contents.add("FileWriteTest01");
			contents.add("FileWriteTest02");
			contents.add("FileWriteTest03");
			
			FileUtil fu = FileUtil.getInstance();
			fu.writePerLine(target, contents);
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
