package template.java.utils.networksub;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface RequestBody {

	void setData(Object data) throws UnsupportedEncodingException;
	void setData(Object data, String originEncoding, String newEncoding) throws UnsupportedEncodingException;
	void setData(File target) throws UnsupportedEncodingException, IOException;
	void setData(File target, String originEncoding, String newEncoding) throws UnsupportedEncodingException, IOException;
	byte[] getData();
	
}
