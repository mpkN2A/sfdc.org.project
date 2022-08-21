package sfdc.org.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/*
	 * public static String readPropertiesFile(String filename, String key) throws
	 * IOException {
	 * 
	 * Properties p = new Properties(); FileReader prop = new
	 * FileReader(System.getProperty("user.dir")+
	 * "\\src\\main\\java\\testdata\\"+filename+".properties"); p.load(prop); String
	 * value= p.getProperty(key); return value; }
	 */
	
	public static String readPropertiesFile(String key) throws IOException {

		Properties p = new Properties();
		FileReader prop = new FileReader(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		p.load(prop);
		String value= p.getProperty(key);
		return value;
	}




}
