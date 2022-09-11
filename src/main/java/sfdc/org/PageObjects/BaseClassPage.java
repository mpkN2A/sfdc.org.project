package sfdc.org.PageObjects;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author MohanaPriyaK
 * Browser Configs, Report Config
 */
public class BaseClassPage {
	 public static WebDriver objdriver ;
     public static Properties prop=new Properties();
     public static FileReader fr;
     public static String LoginPageTitle = "Login | Salesforce";
 	public static String SFDeveloperPageTitle = "Home Page ~ Salesforce - Developer Edition";
 	//@Parameters("browser")
     @BeforeMethod
     public void setup() throws IOException
     {
    	 System.out.print("From Baseclasspage");
    
    	 
			/*
			 * if(objdriver==null) { fr= new FileReader(System.getProperty("user.dir")+
			 * "/src/main/resources/config.properties"); prop.load(fr); }
			 */
    	 fr= new FileReader(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fr);
			
    	 if(prop.getProperty("browser").equals("chrome"))
    	 {
    		 WebDriverManager.chromedriver().setup();
    		 objdriver=new ChromeDriver();
    		 objdriver.get(prop.getProperty("testURL"));
    		 objdriver.manage().window().maximize();
    	 }
    	 if (prop.getProperty("browser").equals("firefox"))
    	 {
    		 WebDriverManager.chromedriver().setup();
    		 objdriver=new  FirefoxDriver();
    		 objdriver.get(prop.getProperty("testURL"));
    		 objdriver.manage().window().maximize();
    	 }
    	 
     }
     @AfterMethod
     public void closeDriver()
     {
    	// objdriver.quit();
     }
   
}
