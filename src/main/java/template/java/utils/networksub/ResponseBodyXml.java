package template.java.utils.networksub;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import template.java.utils.FileUtil;

public class ResponseBodyXml implements ResponseBody{
	
	private String resultXmlString = "";
	
	private FileUtil fu = FileUtil.getInstance();

	@Override
	public boolean readResult(BufferedReader buff) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		
		while ((line = buff.readLine()) != null) {
			sb.append(line).append("\n");
		}
		
		this.resultXmlString = sb.toString();
		
		return ( this.resultXmlString != null || !this.resultXmlString.equals("")) ? true : false;
	}

	
	@Override
	public Object getResult() throws IOException {
		return this.resultXmlString;
	}

	
	@Override
	public File saveResultToFile(String path) {
		if (this.resultXmlString == null || this.resultXmlString.equals("")) {
			return null;
		}
		
		File f = new File(path);
		if (fu.write(f, this.resultXmlString)) {
			return f;
		}
		
		return null;
	}

}
