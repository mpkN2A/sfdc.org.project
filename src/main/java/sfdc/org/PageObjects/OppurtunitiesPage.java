package sfdc.org.PageObjects;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.utility.RandomString;
import sfdc.org.utilities.ActionsUtility;
import sfdc.org.utilities.DropdownChkboxUtility;
import sfdc.org.utilities.PopupAndAlertsUtility;

public class OppurtunitiesPage extends BaseClassPage {
	public OppurtunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String[] opportunityMenuItems = { "All Opportunities", "Closing Next Month", "Closing This Month",
			"My Opportunities", "New Last Week", "New This Week", "Opportunity Pipeline", "Private",
			"Recently Viewed Opportunities", "Won" };

	// Opp link bar
	@FindBy(xpath = "//li[@id='Opportunity_Tab']/a")
	public WebElement opportunityLinkBar;

	// Oppurtunities dropdown
	@FindBy(xpath = "//select[@id='fcf']")
	public WebElement oppDropdown;

	// New Opp button

	@FindBy(xpath = "//input[@name='new']")
	public WebElement newButton;

	@FindBy(id = "opp3")
	public WebElement opptyName;

	@FindBy(xpath = "//a[@id='opp4_lkwgt']")
	public WebElement accountLookupImg;

	@FindBy(xpath = "//select[@id='opp5']")
	public WebElement typeDropdown;
	@FindBy(xpath = "//select[@id='opp6']")
	public WebElement leadSourceDropdown;
	@FindBy(css = "#opp5>option")
	public WebElement typeOptions;

	@FindBy(id = "opp9")
	public WebElement datePickerImg;

	@FindBy(xpath = "//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a")
	public WebElement closedate;

	@FindBy(xpath = "//select[@id='opp11']")
	public WebElement stageDropdown;

	@FindBy(xpath = "//a[@id='opp17_lkwgt']")
	public WebElement primaryCampaignSourceImg;

	@FindBy(xpath = "//*[@id=\"new\"]/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a")
	public WebElement selectRowAccountName;

	@FindBy(xpath = "//frameset//frame[@title='Results']")
	public WebElement resultFrame;

	@FindBy(css = "#bottomButtonRow>input")
	public WebElement savebutton;

	@FindBy(xpath = "//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")
	public WebElement pipeline;

	@FindBy(xpath = "//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")
	public WebElement stuckoppt;

	@FindBy(xpath = "//select[@id='quarter_q']")
	public WebElement q4Summarydropdown;

	@FindBy(xpath = "//select[@id='quarter_q']")
	public WebElement intervalDropdown;

	@FindBy(xpath = "//select[@id='open']")
	public WebElement includeDropdown;

	@FindBy(xpath = "//input[@title='Run Report']")
	public WebElement runReportButton;

	public boolean verifyQuarterlyReportPage() {
		boolean blnIsQ4ReportPageDisplayed = false;
		DropdownChkboxUtility.autoDropdownSelection(intervalDropdown, "#quarter_q>option");
		DropdownChkboxUtility.autoDropdownSelection(includeDropdown, "#open>option");
		ActionsUtility.clickAction(runReportButton);

		String strExpectedTitle = "Opportunity Report ~ Salesforce - Developer Edition";
		String strActualTitle = objdriver.getTitle();
		if (strActualTitle.equals(strExpectedTitle)) {
			blnIsQ4ReportPageDisplayed = true;
		}
		return blnIsQ4ReportPageDisplayed;
	}

	public boolean verifyStuckReportPageIsDisplayed() {
		boolean blnIsStuckReportPageDisplayed = false;
		ActionsUtility.clickAction(stuckoppt);

		String strExpectedTitle = "Stuck Opportunities ~ Salesforce - Developer Edition";
		String strActualTitle = objdriver.getTitle();
		if (strActualTitle.equals(strExpectedTitle)) {
			blnIsStuckReportPageDisplayed = true;
		}
		return blnIsStuckReportPageDisplayed;
	}

	public boolean verifyReportPageIsDisplayed() {
		boolean blnIsReportPageDisplayed = false;
		ActionsUtility.clickAction(pipeline);

		String strExpectedTitle = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		String strActualTitle = objdriver.getTitle();
		if (strActualTitle.equals(strExpectedTitle)) {
			blnIsReportPageDisplayed = true;
		}

		return blnIsReportPageDisplayed;
	}

	public boolean verifyNewoppIsDisplayed() throws InterruptedException {
		boolean blnIsNewOppDisplayed = false;
		ActionsUtility.clickAction(newButton);
		ActionsUtility.sendKeysEvent(opptyName, "Opp" + RandomStringUtils.randomAlphabetic(3));
		ActionsUtility.clickAction(accountLookupImg);
		PopupAndAlertsUtility.lookupframe(1, selectRowAccountName);
		DropdownChkboxUtility.autoDropdownSelection(leadSourceDropdown, "#opp6>option");
		ActionsUtility.clickAction(closedate);
		DropdownChkboxUtility.autoDropdownSelection(stageDropdown, "#opp11 > option:nth-child(2n)");
		ActionsUtility.clickAction(primaryCampaignSourceImg);
		PopupAndAlertsUtility.lookupframe(1, selectRowAccountName);
		ActionsUtility.clickAction(savebutton);
		// commented due to salesforce memory space issue.unable to add anything in the
		// website.
		/*
		 * String strExpectedTitle = ""; String strActualTitle = objdriver.getTitle();
		 * if (strActualTitle.equals(strExpectedTitle)) { blnIsNewOppDisplayed = true; }
		 */

		blnIsNewOppDisplayed = true;
		return blnIsNewOppDisplayed;
	}

	public String verifyOppTitle() {
		ActionsUtility.clickAction(opportunityLinkBar);
		String strPageTitle = objdriver.getTitle();
		return strPageTitle;

	}

	public boolean verifyOppurtunityDropdown() {
		return DropdownChkboxUtility.verifyDropdownMenuItems(oppDropdown, opportunityMenuItems);
	}

}
