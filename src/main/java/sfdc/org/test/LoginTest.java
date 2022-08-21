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
import sfdc.org.PageObjects.LoginPage;
import sfdc.org.PageObjects.UserMenuPage;
import sfdc.org.utilities.FileUtility;

public class LoginTest extends BaseClassPage {
 //test 12.45am
	public String LoginPageTitle = "Login | Salesforce";
	public String SFDeveloperPageTitle = "Home Page ~ Salesforce - Developer Edition";
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void createExtentReport() {
		String strdateformat = new SimpleDateFormat("yyyy_mm_dd_hhmmss").format(new Date());
		String strReportPath = System.getProperty("user.dir") + "/src/main/resources/TestReports/" + strdateformat
				+ "LoginReport.html";
		extent = new ExtentReports();
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(strReportPath);
		extent.attachReporter(htmlreport);
	}

	@Test(dataProvider = "sfdcCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void LoginErrorMessage_TC01(String strUsername, String strPassword) throws IOException {
		ExtentTest test = extent.createTest("Test Case 01 - Login Error Message ");
		test.log(Status.INFO, "TC 01 Login Error Message START");
		LoginPage loginpage = new LoginPage(objdriver);
		String loginPageTitle = loginpage.getLoginTitle();
		Assert.assertTrue(loginPageTitle.equals(LoginPageTitle));
		test.log(Status.INFO, "Salesforce application page is displayed.");
		loginpage.enterUsername(strUsername);
		test.log(Status.INFO, "User Name is displayed in username field");
		loginpage.clearPassword();
		test.log(Status.INFO, "Password field is Empty");
		loginpage.clickLogin();
		Assert.assertEquals(loginpage.getErrorMessage(), FileUtility.readPropertiesFile("login.error.emptypassword"));
		test.log(Status.INFO, "Error Message is displayed");
		test.log(Status.PASS, "TC 01 Login Error Message PASSED");

	}

	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void LoginToSalesForce_TC02(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("Test Case 02 - Login in To SalesForce ");
		test.log(Status.INFO, "TC 02 Login To SalesForce START");
		LoginPage loginpage = new LoginPage(objdriver);
		String loginPageTitle = loginpage.getLoginTitle();
		Assert.assertTrue(loginPageTitle.equals(LoginPageTitle));
		test.log(Status.INFO, "SFDC login page is opened");
		loginpage.loginToApp(strUsername, strPassword);
		test.log(Status.INFO, "Valid credentials are entered.");
		test.log(Status.INFO, "Verifying if Free Trial message is displayed");
		Assert.assertTrue(loginpage.isFreeTrailSeen(), "Free trial option should be available");
		test.log(Status.INFO, "Free Trial Message is displayed");
		test.log(Status.PASS, "TC 02 Login To SalesForce PASSED");
	}

	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void checkRememberMe_TC03(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("Test Case 03 - Check Remember Me");
		test.log(Status.INFO, "TC 03 START");
		LoginPage loginpage = new LoginPage(objdriver);
		UserMenuPage usermenupage = new UserMenuPage(objdriver);
		String loginPageTitle = loginpage.getLoginTitle();
		Assert.assertTrue(loginPageTitle.equals(LoginPageTitle));
		test.log(Status.INFO, "SFDC login page is opened");
		loginpage.loginToApp(strUsername, strPassword, true);
		HomePage objHomePage = new HomePage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		test.log(Status.INFO, "Verify if User menu is displayed");
		Assert.assertTrue(usermenupage.isUserMenuSeen(), "User menu options should be seen");
		test.log(Status.INFO, "User menu is displayed");
		usermenupage.clickOnUserMenu();
		Assert.assertTrue(usermenupage.selectOptionInUserMenuDropDown(objdriver, "Logout"),
				"logout option should be visible and clickable");
		test.log(Status.INFO, "Logout is Clicked");
		Assert.assertTrue(loginpage.isSavedUsernameSeen(), "username should be saved");
		test.log(Status.INFO, "Login sales force page is displayed with" + loginpage.getSavedUsername()
				+ "populated and remember user name checked)");
		Assert.assertEquals(loginpage.getSavedUsername(), strUsername,
				"Saved username and entered username should be same");
		test.log(Status.INFO, "User Name " + loginpage.getSavedUsername() + " is displayed");
		test.log(Status.PASS, "TC 03 PASSED");

	}
	

	@Test(dataProvider = "sfdcCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void ForgotPassword4A(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("TC 04 Forgot Password 4A");
		test.log(Status.INFO, "TC 04 START");
		LoginPage loginpage = new LoginPage(objdriver);
		String loginPageTitle = loginpage.getLoginTitle();
		Assert.assertTrue(loginPageTitle.equals(LoginPageTitle));
		test.log(Status.INFO, "SFDC login page is opened");
		
	
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
