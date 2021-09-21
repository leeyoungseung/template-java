package template.java.utils.networksub;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class RequestBodyForm implements RequestBody{

	private byte[] data;
	
	@Override
	public void setData(Object data) throws UnsupportedEncodingException {
		Map <String, String> body = (Map <String, String>) data;
		
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : body.entrySet()) {
			sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			sb.append("=");
			sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		
		this.data = sb.toString().getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public void setData(Object data, String originEncoding, String newEncoding) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setData(File target) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setData(File target, String originEncoding, String newEncoding)
			throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getData() {
		return this.data;
	}
	

}
