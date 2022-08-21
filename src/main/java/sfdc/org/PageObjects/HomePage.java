package sfdc.org.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClassPage {

	public HomePage (WebDriver objdriver) {
		PageFactory.initElements(objdriver, this);
	}

	
	//  Home Page
	public String getHomePageTitle() {

		return  objdriver.getTitle();

	}

}
