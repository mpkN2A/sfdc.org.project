package sfdc.org.utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.org.PageObjects.BaseClassPage;

public class ActionsUtility extends BaseClassPage {
	
	// Click Action
	public static void clickAction(WebElement element) {

		WebDriverWait wait = new WebDriverWait(objdriver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}
	// Send Text
	public  static void sendKeysEvent(WebElement element,String strValue) {
		WebDriverWait wait = new WebDriverWait(objdriver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(strValue);
		
	}
	// Get Text
		public static String getTextValue(WebElement element) {
			String gettext =null;
			WebDriverWait wait = new WebDriverWait(objdriver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(element));
			gettext=element.getText();
			return gettext;
			
		}
		// Check/uncheck checkbox
		public static void checkUncheckBox(WebElement element,boolean blnCheck)
		{
			if(blnCheck)
			{
				if(!element.isSelected())
				ActionsUtility.clickAction(element);
			}
			else
			{
				if(element.isSelected())
					ActionsUtility.clickAction(element);
				
			}
			
				
		}
		public static boolean verifyIfDisplayed(WebElement element)
		{
			boolean blnisDisplayed=false;
			WebDriverWait wait = new WebDriverWait(objdriver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.isDisplayed())
			{
				blnisDisplayed=true;
			}
			return blnisDisplayed;
			
			
		}
		public static boolean verifyContainsText(WebElement element, String strText)
		{
			WebDriverWait wait = new WebDriverWait(objdriver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(element));
			String strDisplayedText = getTextValue(element);
			boolean blnVerifyContains =strDisplayedText.contains(strText);
			return blnVerifyContains;
			
		}

}
