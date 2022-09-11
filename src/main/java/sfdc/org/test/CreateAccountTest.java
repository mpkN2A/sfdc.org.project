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

import sfdc.org.PageObjects.AccountPage;
import sfdc.org.PageObjects.BaseClassPage;
import sfdc.org.PageObjects.HomePage;
import sfdc.org.PageObjects.LoginPage;


public class CreateAccountTest extends BaseClassPage {
	public static ExtentReports extent;
	public static ExtentTest test;

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
	public void fncreateAccount10(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 10 CREATE ACCOUNT");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		AccountPage accountPage = new AccountPage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertTrue(accountPage.isAccountPageDisplayed(), "Account page is not displayed");
		test.log(Status.INFO, "Accounts page is displayed with correct <username>");
		Assert.assertTrue(accountPage.isAccountEditPageDisplayed(), "Account Edit page is not displayed");
		test.log(Status.INFO, "Accounts  Edit page is displayed ");
		
		
		test.log(Status.INFO, "create a New Account");
		Assert.assertTrue(accountPage.isNewAccountPageDisplayLastname(),
				"Account  page cannot display updated account details.");
		test.log(Status.INFO, "New Account Page id displayed with the Account details.");
		test.log(Status.PASS, "TC 10 CREATE ACCOUNT PASSED");

	}

	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public static void fncreateNewViewTC11(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 11 CREATE NEW VIEW");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		AccountPage accountPage = new AccountPage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertTrue(accountPage.isAccountPageDisplayed(), "Account page is not displayed");
		test.log(Status.INFO, "Accounts page is displayed with correct <username>");
		Assert.assertTrue(accountPage.checkNewlyAddedView(), "Newly added view is not displayed");
		test.log(Status.INFO, "Newely added View is displayed in the account view list");
		test.log(Status.PASS, "TC 11 CREATE NEW VIEW PASSED");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public static void fnEditAccountViewTC12(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 12 EDIT ACCOUNT VIEW");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		AccountPage accountPage = new AccountPage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertTrue(accountPage.isAccountPageDisplayed(), "Account page is not displayed");
		test.log(Status.INFO, "Accounts page is displayed with correct <username>");
		Assert.assertTrue(accountPage.selectViewFromDropdown(),"updating  view and view added in last Activity  column failed");
		test.log(Status.INFO,"View page with new view name in the drop down is displayed. View will have Last activity column added");
		test.log(Status.PASS,"TC 12 EDIT ACCOUNT VIEW");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public static void fnMergeAccountsTC13(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 13 MERGE ACCOUNT");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		AccountPage accountPage = new AccountPage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertTrue(accountPage.isAccountPageDisplayed(), "Account page is not displayed");
		test.log(Status.INFO, "Accounts page is displayed with correct <username>");
		
		test.log(Status.PASS,"TC 13 MERGE ACCOUNT");
	}
	
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public static void fnCreateAccountReportTC14(String strUsername, String strPassword) throws InterruptedException {
		ExtentTest test = extent.createTest("START - TC 14 CREATE ACCOUNT REPORT");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		AccountPage accountPage = new AccountPage(objdriver);
		Assert.assertTrue(accountPage.isAccountPageDisplayed(), "Account page is not displayed");
		test.log(Status.INFO, "Accounts page is displayed with correct <username>");
		Assert.assertTrue(accountPage.createReport(), "unsaved page doesnot displayed");
		test.log(Status.INFO, "Unsaved Repoet page is displayed");
		Assert.assertTrue(accountPage.reportOptions(),"Failed to display List of accounts");
		test.log(Status.INFO,"List of accounts qualified is displayed");
		Assert.assertTrue(accountPage.saveReport(),"Failed to display report name");
		test.log(Status.INFO,"Report page with details and <report name>is displayed.");
		test.log(Status.PASS,"TC 14 CREATE ACCOUNT REPORT");
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
