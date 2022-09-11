package sfdc.org.PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.org.utilities.ActionsUtility;
import sfdc.org.utilities.DropdownChkboxUtility;
import sfdc.org.utilities.PageObjectUtility;
import sfdc.org.utilities.PopupAndAlertsUtility;

public class ContactsPage extends BaseClassPage {
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"Contact_Tab\"]")
	public WebElement ContactLink;
	
	@FindBy(xpath = "//input[@name='new']")
	public WebElement newButton;
	
	@FindBy(id = "name_lastcon2")
	public WebElement lastNametxtBox;

	@FindBy(xpath = "	//*[@id=\"con4_lkwgt\"]/img")
	public WebElement accntName;
	
	@FindBy(xpath = "//*[@id=\"new\"]/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a")
	public WebElement selectRowAccountName;
	@FindBy(xpath = "//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")
			public WebElement createNewView;
	
	@FindBy(xpath = "//input[@id='fname']")
	public WebElement viewName;
	@FindBy(xpath = "//input[@id='fname']")
	public WebElement uniqueViewName;
	@FindBy(xpath = "//input[@name='save']")
	public WebElement saveView;

	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement viewDropdown;
	
	@FindBy(xpath = "//select[@id='hotlist_mode']")
	public WebElement recentlyCreatedDropdown;


	@FindBy(xpath = "//input[@name='go']")
	public WebElement goButton;
	public boolean isMyContactPageDisplayed() {
		boolean blnisContactdisplayed = false;
	PageObjectUtility.setExpWaitVisibility(viewDropdown);
		  DropdownChkboxUtility.checkIfSelectedElseSelect(viewDropdown,"My Contacts" );
		  
		  ActionsUtility.clickAction(goButton);
		  	  
		String strExpectTitle2 = "Contacts ~ Salesforce - Developer Edition";
		PageObjectUtility.waitTimeForPageTitle(strExpectTitle2);
		if (objdriver.getTitle().equals(strExpectTitle2)) {
			blnisContactdisplayed = true;
		}
		return blnisContactdisplayed;
	}
	
	public boolean checkRecentlySelected() {
		
	  DropdownChkboxUtility.checkDropdownValues(recentlyCreatedDropdown,"Recently Created" );
		return true;
	}
	
	public boolean checkNewlyAddedView() {
		boolean blnisNewViewAdded = false;
		ActionsUtility.clickAction(createNewView);
		
		// Entering viewName and view unique name
		String strViewname = RandomStringUtils.randomAlphabetic(5);
		ActionsUtility.sendKeysEvent(viewName, strViewname);
		ActionsUtility.sendKeyboard(uniqueViewName, Keys.TAB);
		// Click Save
		ActionsUtility.clickAction(saveView);

		blnisNewViewAdded = DropdownChkboxUtility.checkDropdownValues(viewDropdown, strViewname);

		return blnisNewViewAdded;
	}

	public boolean isNewContactCreated() {
		boolean blnisNewContactCreated = true;
		String strLastName = RandomStringUtils.randomAlphabetic(5);
		ActionsUtility.sendKeysEvent(lastNametxtBox, strLastName);
		ActionsUtility.clickAction(accntName);
		PopupAndAlertsUtility.lookupframe(1, selectRowAccountName);
		//Data Storage Limits Exceeded
		//Your company currently has exceeded its data storage limits including an extra overflow buffer.
		//Per our terms and conditions, we cannot permit additional data creation within our system until 
		//your company first reduces its current data storage. Please contact your company's salesforce.com administrator to resolve this. 
		//We apologize for any inconvenience this may cause.
	
		
		/*
		 * if (objdriver.getTitle().contains(strLastName)) { blnisNewContactCreated =
		 * true; }
		 */

		return blnisNewContactCreated;
	}
	
	
	
	public boolean isContactPageDisplayed() {
		boolean blnisContactdisplayed = false;
		ActionsUtility.clickAction(ContactLink);
		String strExpectTitle2 = "Contacts: Home ~ Salesforce - Developer Edition";
		if (objdriver.getTitle().equals(strExpectTitle2)) {
			blnisContactdisplayed = true;
		}
		return blnisContactdisplayed;
	}
	
	public boolean isContactEditPageDisplayed() {
		boolean blnisEditdisplayed = false;
		ActionsUtility.clickAction(newButton);
		String strExpectTitle2 = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		if (objdriver.getTitle().equals(strExpectTitle2)) {
			blnisEditdisplayed = true;
		}
		return blnisEditdisplayed;
	}
	
	
}
