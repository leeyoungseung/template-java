package template.java.utils.networksub;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public interface RequestBody {

	void setData(Object data) throws Exception;
	void setData(File target) throws Exception;
	byte[] getData() throws Exception;
	boolean write(OutputStream os) throws Exception;
	
}
