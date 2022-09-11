package sfdc.org.PageObjects;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sfdc.org.utilities.ActionsUtility;
import sfdc.org.utilities.DropdownChkboxUtility;





public class AccountPage extends BaseClassPage {

	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Create an Account
	@FindBy(xpath = "//*[@id=\\\"hotlist\\\"]/table/tbody/tr/td[2]/input")
	public WebElement accounttab;
	@FindBy(css = "#acc2")
	public WebElement lastName;
	@FindBy(xpath = "//td[@id='topButtonRow']/input[1]")
	public WebElement newAccount;
	@FindBy(xpath = "//*[@id=\"Account_Tab\"]")
	public WebElement Accountlink;
//Create new view
	@FindBy(css = "#fname")
	public WebElement viewName;
	@FindBy(css = "#devname")
	public WebElement uniqueViewName;
	@FindBy(xpath = "//*[@id=\\\"editPage\\\"]/div[1]/table/tbody/tr/td[2]/input[1]")
	public WebElement saveView;

	//Edit account
	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement viewDropdown;
	@FindBy(css = "#fcf>option")
	public WebElement viewOptions;
	
	
	@FindBy(css = ".filterLinks>a")
	public WebElement editbutton;
	
	@FindBy(css = "#fcol1")
	public WebElement accountName;
	@FindBy(css = "#fop1")
	public WebElement optionA;
	@FindBy(css = "#fval1")
	public WebElement inputA;
	@FindBy(css = "#colselector_select_0")
	public WebElement lastActivity;
	@FindBy(css = "#colselector_select_0_right")
	public WebElement addButton;
	@FindBy(xpath  = "//div[@class='pbHeader']/table/tbody/tr/td[@class='pbButtonb']/input[1]")
	public WebElement saveButton;
	@FindBy(xpath = "//*[@id=\"00B8V00000D7gGj_listSelect\"]")
	public WebElement updateView;
	@FindBy(xpath = "//*[@id=\\\"ext-gen16\\\"]/div/table/thead/tr/td[10]/div")
	public WebElement lastColumn;
	
	// create view report
	@FindBy (xpath = "//div[@class='lbBody']//ul//li[2]/a")
	public WebElement accountGreaterthan30days;
	
	@FindBy(css = "#ext-gen20")
	public WebElement  datefieldDropdown;
	
	
	@FindBy(css = "#duration-ext-gen17")
	public WebElement  dateRange;
	
	@FindBy(css = "#ext-gen152")
	public WebElement FromdateRange;
	@FindBy(css = "#ext-gen154")
	public WebElement  TodateRange;
	

	@FindBy(xpath = "//button[contains(text(),'Today')][1]")
	public WebElement FromToday;
	@FindBy(xpath ="//button[contains(text(),'Today')]//following::button[contains(text(),'Today')]")
	public WebElement  ToToday;
	@FindBy(css = "#ext-gen49")
	public WebElement  	saveReport;
	@FindBy(id  = "gridViewScrollpreviewPanelGrid")
	public WebElement  	accountList;
	@FindBy(css = "#ext-gen148")
	public WebElement  	createdDateImage;		

	

	@FindBy(css = "#ext-gen24")
	public WebElement  frameDate;

	@FindBy(xpath =	"//div[@class='dateColumnCategory'][1]//following::div[2]")
	public WebElement  createdDateInput;
	
	@FindBy(xpath =	"//input[@name='endDate']")
	public WebElement endDate;
	
	
	@FindBy(xpath =	"//button[contains(text(),'Save')]")
	public WebElement savebuton;
	@FindBy(name ="reportName")
	public WebElement reportname;
	@FindBy(name ="reportDevName")
	public WebElement reportUniquename;
	
	@FindBy(xpath ="//table[@id='dlgSaveAndRun']//button")
	
	public WebElement saveReportButton;
	
	
	@FindBy(xpath ="//img[@title='Reports']//following::h1")
	public WebElement reportViewName;
	
	@FindBy(css = "#saveReportDlg")
	public WebElement  dialogbox;


	
	public boolean	saveReport() throws InterruptedException
	{
		boolean blnIsReportNameDisplayed = false;
		ActionsUtility.clickAction(savebuton);
	
		
		  String strReportName = RandomStringUtils.randomAlphabetic(5);
		  ActionsUtility.sendKeysEvent(reportname, strReportName);
		  reportUniquename.sendKeys(Keys.TAB);
		  WebDriverWait wait = new WebDriverWait(objdriver, Duration.ofSeconds(60));
		  wait.until(ExpectedConditions.textToBePresentInElement(reportUniquename, strReportName));
		 ActionsUtility.clickAction(saveReportButton);
		 
			/*
			 * WebElement modalAcceptButton = dialogbox
			 * .findElement(By.xpath("//table[@id='dlgSaveAndRun']//button"));
			 * modalAcceptButton.click();
			 */
		
		 String strSaveTitle = "\'"+strReportName +"~ Salesforce - Developer Edition\'";
		 WebDriverWait wait1 = new WebDriverWait(objdriver, Duration.ofSeconds(60));
		  wait1.until(ExpectedConditions.titleIs(strSaveTitle));
				 
	String strAccountName=	ActionsUtility.getTextValue(reportViewName);
	if(strAccountName.equals(strReportName))
	{
		blnIsReportNameDisplayed=true;
	}
		return blnIsReportNameDisplayed;	
	}
	
	
	public boolean reportOptions() {
		boolean blnIsAccountdisplayed = false;
		
		ActionsUtility.clickAction(createdDateImage);
		//DropdownChkboxUtility.selectbyVisibleTextFromDropdown(datefieldDropdown, "Created Date");
		
		ActionsUtility.clickAction(createdDateInput);
		ActionsUtility.clickAction(FromdateRange);
		ActionsUtility.clickAction(FromToday);
		ActionsUtility.clickAction(TodateRange);
		ActionsUtility.clickAction(ToToday);
		//ActionsUtility.sendKeyboard(endDate, Keys.SPACE);
		/*
		 * Actions action = new Actions(objdriver);
		 * action.sendKeys(Keys.SPACE).build().perform();
		 */
		if(ActionsUtility.verifyIfDisplayed(accountList))
		{
			blnIsAccountdisplayed=true;
		}
		return blnIsAccountdisplayed;	
	}
	
	
	public boolean isAccountEditPageDisplayed() {
		boolean blnisAccountdisplayed = false;
		ActionsUtility.clickAction(accounttab);
		String strExpectTitle2 = "Account Edit: New Account ~ Salesforce - Developer Edition";
		if (objdriver.getTitle().equals(strExpectTitle2)) {
			blnisAccountdisplayed = true;
		}
		return blnisAccountdisplayed;
	}
	public boolean isAccountPageDisplayed() {
		boolean blnisAccountdisplayed = false;
		ActionsUtility.clickAction(Accountlink);
		String strExpectTitle2 = "Accounts: Home ~ Salesforce - Developer Edition";
		if (objdriver.getTitle().equals(strExpectTitle2)) {
			blnisAccountdisplayed = true;
		}
		return blnisAccountdisplayed;
	}

	public boolean isNewAccountPageDisplayLastname() {
		boolean blnisNewAccountdisplayed = false;
		String strLastName = RandomStringUtils.randomAlphabetic(5);
		ActionsUtility.sendKeysEvent(lastName, strLastName);
		ActionsUtility.clickAction(newAccount);
		if (objdriver.getTitle().contains(strLastName)) {
			blnisNewAccountdisplayed = true;
		}

		return blnisNewAccountdisplayed;
	}

	public boolean checkNewlyAddedView() {
		boolean blnisNewViewAdded = false;
		// Entering viewName and view unique name
		String strViewname = RandomStringUtils.randomAlphabetic(5);
		String strUniqueViewname = RandomStringUtils.randomAlphanumeric(5);
		ActionsUtility.sendKeysEvent(viewName, strViewname);
		ActionsUtility.sendKeysEvent(uniqueViewName, strUniqueViewname);
		// Click Save
		ActionsUtility.clickAction(saveView);

		blnisNewViewAdded = DropdownChkboxUtility.checkDropdownValues(viewDropdown, strViewname);

		return blnisNewViewAdded;
	}
	public boolean selectViewFromDropdown() {
		boolean blnisNewEditDisplayed = false;
		Assert.assertTrue(DropdownChkboxUtility.autoDropdownSelection(viewDropdown, "#fcf>option"));
		ActionsUtility.clickAction(editbutton);
		String strViewname = "UN" + RandomStringUtils.randomAlphabetic(5);
		ActionsUtility.sendKeysEvent(viewName, strViewname);
		String strAccountName = "ACCOUNT.NAME";
		DropdownChkboxUtility.selectValueFromDropdown(accountName, strAccountName);
		// Send ' a' as input in the filter field
		String strContains = "c";
		DropdownChkboxUtility.selectValueFromDropdown(optionA, strContains);
		// input value 'a'
		String strValue = "a";
	    ActionsUtility.clearField(inputA);
		ActionsUtility.sendKeysEvent(inputA, strValue);
		String strSelectField = "ACCOUNT.LAST_ACTIVITY";
		DropdownChkboxUtility.selectValueFromDropdown(viewDropdown, strSelectField);
		ActionsUtility.clickAction(addButton);
		ActionsUtility.clickAction(saveButton);
		
		if(DropdownChkboxUtility.checkDropdownValues(updateView, strViewname) &&  (ActionsUtility.verifyIfDisplayed(lastColumn)))
		{
			blnisNewEditDisplayed = true;
		}
		
		return blnisNewEditDisplayed;
	}
	public boolean createReport() {
		boolean blnunsavedreportpage = false;
		ActionsUtility.clickAction(accountGreaterthan30days);
		objdriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		String strExpectTitle  ="Unsaved Report ~ Salesforce - Developer Edition";
		String strDisplayTitle = objdriver.getTitle();
		 
		if(strDisplayTitle.equals(strExpectTitle))
		{
			blnunsavedreportpage=true;
		}
		return blnunsavedreportpage;
		
		
		
	}
	

	
	

}
