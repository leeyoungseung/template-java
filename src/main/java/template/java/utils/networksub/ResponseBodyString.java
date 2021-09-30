package template.java.utils.networksub;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class ResponseBodyString implements ResponseBody {
	
	private String resultString = "";
	
	@Override
	public boolean readResult(BufferedReader buff) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		
		while ((line = buff.readLine()) != null) {
			sb.append(line).append("\n");
		}
		
		this.resultString = sb.toString();
		
		return ( this.resultString != null || !this.resultString.equals("")) ? true : false;
	}

	@Override
	public File saveResultToFile(String path) {
		return null;
	}

	@Override
	public Object getResult() throws IOException {
		return this.resultString;
	}

}
