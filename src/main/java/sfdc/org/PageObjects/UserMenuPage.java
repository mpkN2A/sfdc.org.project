package sfdc.org.PageObjects;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import sfdc.org.utilities.ActionsUtility;
import sfdc.org.utilities.DropdownChkboxUtility;

public class UserMenuPage extends BaseClassPage {
	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String[] expectedUserMenuItems = { "My Profile", "My Settings", "Developer Console",
			"Switch to Lightning Experience", "Logout" };

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(id = "userNav-arrow")
	public WebElement userMenuButton;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(id = "userNav-menuItems/a[1]")
	public WebElement MyProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement MySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement DevelopersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement Logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editprofilebutton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	// div[@id='contactInfoContent']
	@FindBy(xpath = "//div[@id='contactInfoContent']")
	public WebElement frameDivContact;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement Userprofilepagenamedisplay;

	@FindBy(css = "#contactInfoContentId")
	public WebElement contactInfoFrame;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(css = "#publisherAttachContentPost")
	public WebElement publisherAttachContent;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	// Photo link

	@FindBy(css = "#displayBadge")
	public WebElement displayBadge;

	@FindBy(xpath = "//div[@class='photoUploadSection']/a")
	public WebElement addPhoto;
	@FindBy(css = "#deletePhoto")
	public WebElement deletePhoto;
	@FindBy(css = "#simpleDialog0button0")
	public WebElement EditPhotoDialog;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	public WebElement uploadPhoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement SavePhoto;

	// My Settings
	// personallink

	@FindBy(xpath = "//div[@id='PersonalInfo']//descendant::span[@id='PersonalInfo_font']")
	public WebElement personallink;

	@FindBy(xpath = "//div[@id='PersonalInfo']//descendant::span[@id='LoginHistory_font']")
	public WebElement loginHistorylink;
	@FindBy(xpath = "//div[@id='RelatedUserLoginHistoryList_body']//child::div[@class='pShowMore']//child::a[1]")
	public WebElement downloadlink;
	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	// Display&layoutlink

	@FindBy(xpath = "//span[@id='DisplayAndLayout_font']")
	public WebElement DisplayLayoutlink;

	@FindBy(xpath = "//div[@id='DisplayAndLayout_child']//descendant::span[@id='CustomizeTabs_font']")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//select[@id='p4']")
	public WebElement selectSalesForceChatter;

	@FindBy(xpath = "//select[@id='duel_select_0']")
	public WebElement SelectReports;

	@FindBy(xpath = "//a[@id='duel_select_0_right']//child::img[1]")
	public WebElement Add;

	@FindBy(xpath = "//td[@id='bottomButtonRow']/input[@title='Save']\"")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	@FindBy(xpath = "//select[@id='duel_select_1']//option[@value='report']")
	public WebElement checkReport;
	@FindBy(xpath = "//div[@id='tsid-menuItems']//child::a[1]")
	public WebElement salesTab;

	@FindBy(xpath = "//ul[@id='tabBar']//li[@id='report_Tab']")
	public WebElement ReportTab;
	@FindBy(id = "tsidButton")
	public WebElement reportButton;

	@FindBy(xpath = "//div[@id='tsid-menuItems']//child::a[3]")
	public WebElement checkMarketingPage1;

	@FindBy(xpath = "div[@id='tsid-menuItems']//child::a[7]")
	public WebElement checkSFPage;

	@FindBy(xpath = "//ul[@id='tabBar']//li[@id='report_Tab']")
	public WebElement checkSFChatterPage;

	@FindBy(xpath = "//li[@id='report_Tab']/a[1]")
	public WebElement checkSalesPage;

	@FindBy(xpath = "div[@id='tsid-menuItems']//child::a[7]")
	public WebElement checkMarketingPage;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement EmaillinkFont;

	@FindBy(css = "#EmailSetup>a")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;
	// Developer console

	@FindBy(xpath = "//div[@id='userNav-menuItems']//child::a[2]")
	public WebElement devConsole;
	@FindBy(xpath = "//a[@title='Developer Console (New Window)']")
	public WebElement devConsoleWindow;

	// Logout

	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logout;

	/**
	 * This function is responsible to verify user menu items in user menu drop down
	 * This function has to be called after clicking on user menu
	 * 
	 * @return {Boolean} true if all options are verified successfully else returns
	 *         false
	 */
	public boolean verifyUserMenuDropdownItems() {
		int i = 0;
		boolean blnIsUsermenuItems = true;

		ActionsUtility.clickAction(userMenuButton);
		// Check for the given dropdown values

		for (WebElement oWelem : userMenuOptions) {
			String strdispMenu = oWelem.getText();
			try {
				Assert.assertEquals(strdispMenu, expectedUserMenuItems[i],
						"The item " + expectedUserMenuItems[i] + " is missing in the UserMenu dropdown");
				i++;
			} catch (Exception e) {
				blnIsUsermenuItems = false;
			}

		}
		return blnIsUsermenuItems;
	}

	/**
	 * This function is responsible to select user menu item in user menu drop down
	 * by passing an option name
	 * 
	 * @param optionName example: {"My profile", "Settings"}
	 * @return true if option is selected else false
	 */
	public boolean selectOptionInUserMenuDropDown(WebDriver driver, String optionName) {
		boolean isOptionSelected = false;
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + optionName + "']"));
		if (userMenuOption.isDisplayed()) {
			ActionsUtility.clickAction(userMenuOption);
			isOptionSelected = true;
		} else {
			System.out.println("Option " + optionName + " not selected");
		}
		return isOptionSelected;
	}

	/**
	 * This function will create a post, Should be called in my profile page
	 * 
	 * @param textBox WebElement
	 * @param message to be posted in text box
	 * @param button
	 * @return true if post is created else false
	 */
	public boolean createAPost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if (postLink.isDisplayed()) {
			postLink.click();
			// System.out.println("Clicked on the text box");
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message + "  " + RandomStringUtils.randomAlphanumeric(5));
			driver.switchTo().defaultContent();
			// System.out.println("Entered the text in text box");
			if (shareButton.isDisplayed()) {
				shareButton.click();
				System.out.println("Clicked on the post button");
				isPostCreated = true;
			}
		}
		return isPostCreated;
	}

	public boolean uploadFile(String strFilePath) {
		boolean blnIsFileUploaded = false;
		ActionsUtility.clickAction(publisherAttachContent);
		ActionsUtility.clickAction(Uploadfile);
		ActionsUtility.sendKeysEvent(Fileopen, strFilePath);
		if (ActionsUtility.verifyIfDisplayed(publish)) {
			ActionsUtility.clickAction(publish);
			blnIsFileUploaded = true;
		}
		try {
			// to handle when SFDC server error due to storage issue in uploading files
			if (ActionsUtility.verifyIfDisplayed(EditPhotoDialog)) {
				ActionsUtility.clickAction(EditPhotoDialog);
			}
		} catch (NoSuchElementException ex) {
			return blnIsFileUploaded;
		}
		return blnIsFileUploaded;

	}

	public boolean isUserMenuSeen() {

		boolean blnresult = ActionsUtility.verifyIfDisplayed(userMenu);
		return blnresult;

	}

	public void clickOnUserMenu() {
		if (userMenu.isDisplayed()) {
			ActionsUtility.clickAction(userMenuButton);
		}
	}

	public boolean openEditProfilePopUp() {
		boolean isEditProfileWindowSeen = false;

		ActionsUtility.clickAction(editprofilebutton);
		objdriver.switchTo().frame("contactInfoContentId");
		if (ActionsUtility.verifyIfDisplayed(Abouttab) && ActionsUtility.verifyIfDisplayed(contactTab)) {
			isEditProfileWindowSeen = true;
		}

		return isEditProfileWindowSeen;
	}

	public boolean changeLastNameInAboutTab() {
		// driver.switchTo().frame("contactInfoContentId");
		boolean isLastNameChanged = false;
		String strLastName = RandomStringUtils.randomAlphabetic(6);
		if (Abouttab.isDisplayed()) {
			Abouttab.click();
			if (Abouttablastname.isDisplayed()) {
				Abouttablastname.clear();
				Abouttablastname.sendKeys(strLastName);
				saveAllButton.click();
				isLastNameChanged = true;
			}
		}
		objdriver.switchTo().defaultContent();
		return isLastNameChanged;
	}

	public boolean addPhoto(String strPhotoPath) {

		boolean isPhotoAdded = false;
		ActionsUtility.clickAction(addPhoto);
		// delete if photo is already uploaded
		try {

			if (ActionsUtility.verifyIfDisplayed(deletePhoto)) {
				ActionsUtility.clickAction(deletePhoto);
				ActionsUtility.clickAction(EditPhotoDialog);
				objdriver.switchTo().defaultContent();
				ActionsUtility.clickAction(addPhoto);
				objdriver.switchTo().frame("uploadPhotoContentId");
			}

		} catch (Exception ex) {
			objdriver.switchTo().frame("uploadPhotoContentId");
		}

		ActionsUtility.sendKeysEvent(uploadPhoto, strPhotoPath);
		ActionsUtility.clickAction(uploadButton);
		if (ActionsUtility.verifyIfDisplayed(SavePhoto)) {
			ActionsUtility.clickAction(SavePhoto);
			objdriver.switchTo().defaultContent();
			isPhotoAdded = true;
		}

		return isPhotoAdded;

	}
	// Click on personal link and select Login History link.
	// verify Login history is displayed and the data is downloaded in .csv format.

	public void personalAndLoginHistotylink() {

		// Click on Personal link
		ActionsUtility.clickAction(personallink);
		// Click on Login history
		ActionsUtility.clickAction(loginHistorylink);
		// Check if LoginHistory page is displayed
		String strExpLogHislnk = "Login History ~ Salesforce - Developer Edition";
		String ActEXpLogHislnk = objdriver.getTitle();
		Assert.assertEquals(ActEXpLogHislnk, strExpLogHislnk);
		// Click Download link
		ActionsUtility.clickAction(downloadlink);

	}

	public boolean isAddReportTOSFChatter() {

		boolean blnIsReportAdded = false;

		// Click on Display&Layout link
		ActionsUtility.clickAction(DisplayLayoutlink);
		// Click on Customize my Tab
		ActionsUtility.clickAction(CustomizedTab);
		// Selecting Salesforce Chatter from dropdown
		DropdownChkboxUtility.selectValueFromDropdown(selectSalesForceChatter, "Salesforce Chatter");
		DropdownChkboxUtility.selectValueFromDropdown(SelectReports, "Reports");
		// Click Add button
		ActionsUtility.clickAction(Add);
		String strisReport = ActionsUtility.getTextValue(checkReport);
		Assert.assertTrue(strisReport.equals("report"), "The selected value Report is not added in the Selected Tab.");
		// Click Save button
		// objdriver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@title='Save']")).click();
		// ActionsUtility.click("//td[@id='bottomButtonRow']/input[@title='Save']",
		// pathType.XPath);
		// Check in 'Sales Force chatter' Page
		ActionsUtility.clickAction(checkSFPage);
		Assert.assertTrue(checkSFChatterPage.isDisplayed(),
				"Report Tab is not displayed in the SF Chatter page home tab.");
		// Check if Report tab is added in the Salesforce home page
		Assert.assertTrue(checkSalesPage.isDisplayed(), "Report Tab is not displayed in the Sales force Home Tab Bar.");
		// Check if Report is added
		ActionsUtility.clickAction(reportButton);

		// Select Sales page and check if report tab is visible
		ActionsUtility.clickAction(salesTab);
		Assert.assertTrue(ReportTab.isDisplayed(), "Report Tab is not displayed in Sales Page Home home tab.");

		// Check in 'Marketing' Page
		ActionsUtility.clickAction(checkMarketingPage1);
		Assert.assertTrue(ReportTab.isDisplayed(), "Report Tab is not displayed in the Marketing page home tab.");
		blnIsReportAdded = true;

		return blnIsReportAdded;
	}

	public boolean emailSaveFunctionality() {
		boolean blnIsEmailSaved = false;

		ActionsUtility.clickAction(Emaillink);
		ActionsUtility.clickAction(EmaillinkFont);
		String strEmailname = RandomStringUtils.randomAlphanumeric(5);
		ActionsUtility.sendKeysEvent(Emailname, strEmailname);
		String strEmailaddress = RandomStringUtils.randomAlphanumeric(5) + "@hogwarts.com";
		ActionsUtility.sendKeysEvent(Emailaddress, strEmailaddress);
		if (!BCCradiobutton.isSelected()) {
			ActionsUtility.clickAction(BCCradiobutton);
		}
		ActionsUtility.clickAction(Saveonemail);
		if ((ActionsUtility.getTextValue(Emailname).equals(Emailname))
				&& (ActionsUtility.getTextValue(Emailaddress).equals(strEmailaddress))
				&& (BCCradiobutton.isSelected())) {
			blnIsEmailSaved = true;
		}

		return blnIsEmailSaved;
	}

	public boolean isCalenderPopupwindowDisplayed() {
		boolean blnIsWindowDisplayed = false;

		ActionsUtility.clickAction(CalendarAndReminders);
		ActionsUtility.clickAction(ActivityRemainder);
		String strParentWindow = objdriver.getWindowHandle();
		ActionsUtility.clickAction(OpenaTestRemainder);
		// CHECK IF POP WINDOW IS DISPLAYED

		Set<String> setWindowHandle = objdriver.getWindowHandles();
		try {
			for (String wh : setWindowHandle) {
				if (!wh.equals(strParentWindow)) {
					objdriver.switchTo().window(wh);
					blnIsWindowDisplayed = true;
					objdriver.close();

				}

			}
		} catch (Exception ex) {
			blnIsWindowDisplayed = false;
		}

		return blnIsWindowDisplayed;
	}

	public boolean isDevConsoleWindowOpened() {
		boolean blnIsWindowDisplayed = false;
		ActionsUtility.clickAction(userMenuButton);
		ActionsUtility.clickAction(devConsoleWindow);

		String strParentWindow = objdriver.getWindowHandle();
		Set<String> setChildWindows = objdriver.getWindowHandles();
		for (String strChildWindow : setChildWindows) {
			if (!strChildWindow.equals(strParentWindow)) {
				// Considering Parent page has only one child window opened
				objdriver.switchTo().window(strChildWindow);
				String strExpectedTitle = "Developer Console";
				String strActualTitle = objdriver.getTitle();
				if (strActualTitle.equals(strExpectedTitle)) {
					blnIsWindowDisplayed = true;
					objdriver.close();

				}

			}

		}
		return blnIsWindowDisplayed;
	}
	public boolean loggedout() {
		boolean blnLogout = false;
		ActionsUtility.clickAction(userMenuButton);
		ActionsUtility.clickAction(logout);
		//check if sales force home page is displayed   
		String strExptTitle = "Login | Salesforce";
		String strActualTitle = objdriver.getTitle();
		if (strActualTitle.equals(strExptTitle)) {
			blnLogout=true;
		}
		
		return blnLogout;
	}
	
}
