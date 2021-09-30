package template.java.utils.networksub;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class RequestBodyForm implements RequestBody {

	String BOUNDARY = "-----";
	String LINEFEED = "\r\n";
	private PrintWriter writer;
	private OutputStream os;
	
    public String getBOUNDARY() { return BOUNDARY; }
	public void setBOUNDARY(String bOUNDARY) { BOUNDARY = bOUNDARY; }


	public void addHeaderField(String name, String value) {
        writer.append(name + ": " + value).append(LINEFEED);
        writer.flush();
    }
    
	
    public void addFilePart(String fieldName, File uploadFile)
            throws IOException {
        String fileName = uploadFile.getName();
        writer.append("--" + BOUNDARY).append(LINEFEED);
        writer.append(
                "Content-Disposition: form-data; name=\"" + fieldName
                        + "\"; filename=\"" + fileName + "\"")
                .append(LINEFEED);
        writer.append(
                "Content-Type: "
                        + URLConnection.guessContentTypeFromName(fileName))
                .append(LINEFEED);
        writer.append("Content-Transfer-Encoding: binary").append(LINEFEED);
        writer.append(LINEFEED);
        writer.flush();

        FileInputStream inputStream = new FileInputStream(uploadFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.flush();
        inputStream.close();

        writer.append(LINEFEED);
        writer.flush();
    }
    
    
	public boolean sendRequest(OutputStream os) throws Exception {
        writer.append(LINEFEED).flush();
        writer.append(BOUNDARY).append(LINEFEED);
        writer.close();

		return true;
	}
	
	public boolean write(OutputStream os) throws Exception {
		writer = new PrintWriter(new OutputStreamWriter(os, "utf-8"), true);
		return true;
	}


	@Override
	public void setData(Object data) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setData(File target) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public byte[] getData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
