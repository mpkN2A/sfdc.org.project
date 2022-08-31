package sfdc.org.utilities;

import java.io.File;
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
	// Check last downloaded file in the system
	public static String returnLastAddedFileName(String strDownloadPath)

	{
		String strLastAddedFile = null;
		try {
			File oFilePath = new File(strDownloadPath);
			File[] oFilelist = oFilePath.listFiles();
			File lastModifiedFile = oFilelist[0];
			for (int i = 1; i < oFilelist.length; i++) {
				if (lastModifiedFile.lastModified() < oFilelist[i].lastModified()) {
					lastModifiedFile = oFilelist[i];
				}
			}
			strLastAddedFile = lastModifiedFile.getName();

		} catch (Exception ex) {

		}
		return strLastAddedFile;
	}




}
