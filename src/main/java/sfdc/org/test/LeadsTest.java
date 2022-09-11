package sfdc.org.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import sfdc.org.PageObjects.BaseClassPage;
import sfdc.org.PageObjects.HomePage;
import sfdc.org.PageObjects.LeadsPage;
import sfdc.org.PageObjects.LoginPage;
import sfdc.org.PageObjects.OppurtunitiesPage;
import sfdc.org.utilities.PageObjectUtility;

public class LeadsTest extends BaseClassPage {
	public static ExtentReports extent;
	public static ExtentTest test;
	public String strPageTitle = "Leads: Home ~ Salesforce - Developer Edition";

	@BeforeTest
	public void createExtentReport() {
		String strdateformat = new SimpleDateFormat("yyyy_mm_dd_hhmmss").format(new Date());
		String strReportPath = System.getProperty("user.dir") + "/src/main/resources/TestReports/" + strdateformat
				+ "UserMenuReport.html";
		extent = new ExtentReports();
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(strReportPath);
		extent.attachReporter(htmlreport);
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void leadsTabTC20(String strUsername, String strPassword) throws InterruptedException {
		ExtentTest test = extent.createTest("START - TC 20 LEADS TAB");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		PageObjectUtility.waitTimeForPageTitle(SFDeveloperPageTitle);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		LeadsPage leadspage=new LeadsPage(objdriver);
		Assert.assertEquals(leadspage.verifyTitle(), strPageTitle);
		test.log(Status.INFO, "Link home page is displayed");
		test.log(Status.PASS, "PASSED -TC 20 LEADS TAB");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void leadsSelectViewTC21(String strUsername, String strPassword) throws InterruptedException {
		ExtentTest test = extent.createTest("START - TC 21 LEADS SELECTVIEW");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		test.log(Status.INFO, "Sales force home page is displayed");
		LeadsPage leadspage=new LeadsPage(objdriver);
		Assert.assertEquals(leadspage.verifyTitle(), strPageTitle);
		test.log(Status.INFO, "Leads home page is displayed");
		Assert.assertTrue(leadspage.verifyOppurtunityDropdown(),"Displayed menuItems does not match with the expected menu items");
		test.log(Status.INFO,"Menu Items verified Succesfully");	
		
		test.log(Status.PASS, "PASSED -TC 21 LEADS SELECTVIEW");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void goButtonTC22(String strUsername, String strPassword){
		ExtentTest test = extent.createTest("START - TC 22 GO BUTTON FUNCTIONALITY");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		test.log(Status.INFO, "Sales force home page is displayed");
		LeadsPage leadspage=new LeadsPage(objdriver);
		Assert.assertEquals(leadspage.verifyTitle(), strPageTitle);
		test.log(Status.INFO, "Leads home page is displayed");
		Assert.assertTrue(leadspage.selectTodaysleadAndLogout(),"SF loginPage is not displayed");
		test.log(Status.PASS, "Todays leads' is selected from the drop down and the salesforce login page appeared");
		loginpage.loginToApp(strUsername, strPassword);
		PageObjectUtility.waitTimeForPageTitle(SFDeveloperPageTitle);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertEquals(leadspage.verifyTitle(), strPageTitle);
		test.log(Status.INFO, "Leads home page is displayed");
		Assert.assertTrue(leadspage.goButtonFunctionalityCheck(),"Displayed View does not match with the previous selection option");
		test.log(Status.INFO,"Page displayes previously selected view.");
		test.log(Status.PASS, "PASSED -TC 22 GO BUTTON FUNCTIONALITY");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void todaysLeadListTC23(String strUsername, String strPassword){
		ExtentTest test = extent.createTest("START - TC 23 Today's Lead");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		test.log(Status.INFO, "Sales force home page is displayed");
		LeadsPage leadspage=new LeadsPage(objdriver);
		Assert.assertEquals(leadspage.verifyTitle(), strPageTitle);
		test.log(Status.INFO, "Leads home page is displayed");
		Assert.assertTrue(leadspage.selectTodaysleadAndLogout(),"SF loginPage is not displayed");
		test.log(Status.INFO, "Todays leads' is selected from the drop down and the salesforce login page appeared");
		// ??????????????????
		
		
	}
	
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void todaysLeadNewTC24(String strUsername, String strPassword){
		ExtentTest test = extent.createTest("START - TC 24 Today's Lead NEW functionality");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		test.log(Status.INFO, "Sales force home page is displayed");
		LeadsPage leadspage=new LeadsPage(objdriver);
		Assert.assertEquals(leadspage.verifyTitle(), strPageTitle);
		test.log(Status.INFO, "Leads home page is displayed");
		Assert.assertTrue(leadspage.isNewLeadViewPageisOpened(),"New lead page is not opened");
		test.log(Status.INFO,"New lead page is opened");
		Assert.assertTrue(leadspage.isNewLeadViewisSaved(),"New lead view is not saved");
		test.log(Status.INFO,"New lead is saved and the newly created lead view page is opened");
		test.log(Status.PASS, "PASSED -TC 24 Today's Lead NEW functionality");
		
	}
		
	

	
	
	@AfterMethod
	public void getResult(ITestResult result) {
		ExtentTest test = extent.createTest("Failed Test Case Log");
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		}

	}

	@AfterTest
	public void reportTearDown() throws IOException {
		extent.flush();
	}
}
