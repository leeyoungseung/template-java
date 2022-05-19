package template.java.aws;

import java.io.FileReader;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AwsProp extends Properties {

	private static final long serialVersionUID = 1L;

	private AwsProp() {};

	public static AwsProp getInstance() {
		return AwsPropHolder.INSTANCE;
	}

	private static class AwsPropHolder {
		private static final AwsProp INSTANCE = new AwsProp();
	}

	/**
	 *
	 * @param propFile : (ex) : "src/main/resources/aws.properties"
	 */
	public void loadProperties(String propFile) {
		log.info("Will load from [%s]", propFile);

		try {
			this.load(new FileReader(propFile));

			for (Object key : this.keySet()) {
				log.info("aws.properties Key : [%s], Value : [%s]", key, this.get(key));
			}

		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}

	public String getAccessKey() throws NullPointerException {
		return (String) this.get("access_key");
	}

	public String getSecretKey() {
		return (String) this.get("secret_key");
	}

	public String getEndPoint() {
		return (String) this.get("endpoint");
	}

}
