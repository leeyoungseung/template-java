package template.java.utils.networksub;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class ResponseBodyJson implements ResponseBody {
	
	private String resultJsonString = "";

	@Override
	public boolean readResult(BufferedReader buff) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		
		while ((line = buff.readLine()) != null) {
			sb.append(line).append("\n");
		}
		
		this.resultJsonString = sb.toString();
		
		return ( this.resultJsonString != null || !this.resultJsonString.equals("")) ? true : false;
	}

	@Override
	public Object getResult() throws IOException {
		return this.resultJsonString;
	}

	@Override
	public File saveResultToFile(String path) {
		return null;
	}

}
