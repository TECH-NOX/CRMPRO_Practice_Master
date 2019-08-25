package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropFile {

	private InputStream is = null;
	private Properties prop = null;

	public ReadPropFile() {
		try {
			is = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/configuration/config.properties");
			prop = new Properties();
			prop.load(is);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error with Loading Properties File");
		}
	}

	public Properties getProp() {
		return prop;
	}

}
