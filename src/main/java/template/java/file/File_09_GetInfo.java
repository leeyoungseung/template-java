package template.java.file;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import template.java.utils.FileUtil;

public class File_09_GetInfo {

	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}

			String path = args[0];
			FileUtil fu = new FileUtil();
			
			Map<String, String> map = fu.getFileInfo(path);
			
		    for (Entry<String, String> entry : map.entrySet()) {
		        System.out.println("Key : " + entry.getKey() + 
		                 " ,Value : " + entry.getValue());
		    }
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
