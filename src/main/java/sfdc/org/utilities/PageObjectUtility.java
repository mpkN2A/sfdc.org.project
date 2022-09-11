package sfdc.org.utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.org.PageObjects.BaseClassPage;

public class PageObjectUtility extends BaseClassPage {
	
	public static void waitTimeForPageTitle(String strPageTitle)
	{
		WebDriverWait wait =new WebDriverWait(objdriver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.titleIs(strPageTitle));
		
		
		
		
	}
	public static void setExpWaitVisibility(WebElement element) {

		new WebDriverWait(objdriver, Duration.ofSeconds(40))
				.until(ExpectedConditions.visibilityOf(element));
	}
   
}
