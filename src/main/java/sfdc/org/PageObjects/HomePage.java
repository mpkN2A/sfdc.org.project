package sfdc.org.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.org.utilities.ActionsUtility;

public class HomePage extends BaseClassPage {

	public HomePage (WebDriver objdriver) {
		PageFactory.initElements(objdriver, this);
	}
@FindBy(xpath = "//div[@id='contentWrapper']/following-sibling::script[1]")
public WebElement checkHomepageUserName;
	
	//  Home Page
	public String getHomePageTitle() {
		//objdriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		return  objdriver.getTitle();

	}
	public boolean isHomePageHasCorrectUsername(String strUsername)
	{
		boolean blnHasCorrectUserName =ActionsUtility.verifyContainsText(checkHomepageUserName, strUsername);
		return blnHasCorrectUserName;
	}
	
	

}
