package template.java.utils.networksub;

import java.io.BufferedReader;
import java.io.IOException;

public interface ResponseBody {

	boolean readResult(BufferedReader buff) throws IOException;
	Object getResult() throws IOException;
}
