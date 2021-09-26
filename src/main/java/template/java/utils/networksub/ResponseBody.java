package template.java.utils.networksub;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public interface ResponseBody {

	boolean readResult(BufferedReader buff) throws IOException;
	File saveResultToFile(String path);
	Object getResult() throws IOException;
}
