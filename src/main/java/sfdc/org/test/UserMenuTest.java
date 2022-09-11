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
import com.github.dockerjava.api.model.Driver;

import sfdc.org.PageObjects.BaseClassPage;
import sfdc.org.PageObjects.HomePage;
import sfdc.org.PageObjects.LoginPage;
import sfdc.org.PageObjects.UserMenuPage;
import sfdc.org.utilities.FileUtility;

public class UserMenuTest extends BaseClassPage {
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String ProfileFileUploadPath = "/Users/athiranihit/Desktop/TestImage1.png";

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
	public void SelectUserMenuDropdownTC05(String strUsername, String strPassword) throws IOException {
		ExtentTest test = extent.createTest("Test Case 05 - Select user menu for <username> drop down");
		test.log(Status.INFO, "TC 05 START");
		LoginPage loginpage = new LoginPage(objdriver);
		UserMenuPage usermenupage = new UserMenuPage(objdriver);
		HomePage homepage = new HomePage(objdriver);
		String loginPageTitle = loginpage.getLoginTitle();
		Assert.assertTrue(loginPageTitle.equals(FileUtility.readPropertiesFile("title.loginPage")));
		test.log(Status.INFO, "SFDC login page is opened");
		loginpage.loginToApp(strUsername, strPassword, true);

		Assert.assertTrue(homepage.getHomePageTitle().equals(FileUtility.readPropertiesFile("title.homepage")));
		test.log(Status.INFO, "Sales force home page is displayed");
		test.log(Status.INFO, "Verify if corect User Name is displayed in the Home Page");
		// Assert.assertTrue(homepage.isHomePageHasCorrectUsername(strUsername));
		// test.log(Status.INFO, "Home Page is displayed with correct User Name");
		test.log(Status.INFO, "Check if all User menu items is displayed");
		Assert.assertTrue(usermenupage.verifyUserMenuDropdownItems(),
				"User Menu options are missing  or does not match with the expected options");
		test.log(Status.PASS, "TC 05 PASSED");
	}

	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void myProfileTC06(String strUsername, String strPassword) throws IOException {
		ExtentTest test = extent.createTest("Test Case 06 - Select My Profile");
		test.log(Status.INFO, "TC 06 START");
		LoginPage loginpage = new LoginPage(objdriver);
		UserMenuPage usermenupage = new UserMenuPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword, true);
		test.log(Status.INFO, "Check if all User menu items is displayed");
		Assert.assertTrue(usermenupage.verifyUserMenuDropdownItems(),
				"User Menu options are missing  or does not match with the expected options");
		test.log(Status.INFO, "User menu options are verified");
		Assert.assertTrue(usermenupage.selectOptionInUserMenuDropDown(objdriver, "My Profile"),
				"My profile should be clickable");
		test.log(Status.INFO, "My Profile page is displayed");
		Assert.assertTrue(usermenupage.openEditProfilePopUp(),
				"Edit profile page should display About and COntact Tab");
		test.log(Status.INFO, "Edit Profile pop up window displayed with About and Contact tab");
		Assert.assertTrue(usermenupage.changeLastNameInAboutTab(), "Last name is not modified");
		test.log(Status.INFO, "User profile with last name is displayed ");
		test.log(Status.INFO, "Verifying if Post is shared");
		Assert.assertTrue(usermenupage.createAPost(objdriver, "Posting  "), "Post is not shared");
		test.log(Status.INFO, "Post created successfully");
		test.log(Status.INFO, "Verifying File upload");
		Assert.assertTrue(usermenupage.uploadFile(ProfileFileUploadPath), "Failed to upload file");
		test.log(Status.INFO, "File uploaded successfully");
		test.log(Status.INFO, "Verifying Add Photo ");
		Assert.assertTrue(usermenupage.addPhoto(ProfileFileUploadPath), "Failed to upload file");
		test.log(Status.INFO, "Profile photo Added succesfully ");
		test.log(Status.PASS, "TC 06 PASSED");
	}

	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void mySettingsTC07(String strUsername, String strPassword) throws IOException {
		ExtentTest test = extent.createTest("Test Case 07 - My Settings");
		test.log(Status.INFO, "TC 06 START");
		LoginPage loginpage = new LoginPage(objdriver);
		UserMenuPage usermenupage = new UserMenuPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword, true);
		test.log(Status.INFO, "Check if all User menu items is displayed");
		Assert.assertTrue(usermenupage.verifyUserMenuDropdownItems(),
				"User Menu options are missing  or does not match with the expected options");
		test.log(Status.INFO, "User menu options are verified");
		  Assert.assertTrue(usermenupage.selectOptionInUserMenuDropDown(objdriver,
		  "My Settings"), "My Settings should be clickable");
		test.log(Status.INFO, "My Setting page is displayed");
		test.log(Status.INFO, "Click on History link");
		test.log(Status.INFO, "Check if .csv file is downloaded");
		String strDownloadPath = "/Users/athiranihit/Downloads";
		String strLastAddedFile = FileUtility.returnLastAddedFileName(strDownloadPath);
		Assert.assertTrue(strLastAddedFile.startsWith("LoginHistory") && strLastAddedFile.contains(".csv"));
		test.log(Status.INFO,"Login History file with the extensions of .csv downloaded Succesfully");
		test.log(Status.INFO,"Reports added to SF home page ,SF Chatter  page,Sales and Marketing page");	
		Assert.assertTrue(usermenupage.emailSaveFunctionality(),"Email update functionality failed");
		test.log(Status.INFO,"Given details are saved as default mail options and My settings page is displayed.");
		Assert.assertTrue(usermenupage.isCalenderPopupwindowDisplayed(),"No pop up  window opened");
		test.log(Status.INFO,"Sample event pop window is dispayed.");
		test.log(Status.PASS, "TC 07 PASSED");

	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void developerConsoleTC08(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 08 Developer Console");
		LoginPage loginpage = new LoginPage(objdriver);
		UserMenuPage usermenupage = new UserMenuPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword, true);
		test.log(Status.INFO, "Check if all User menu items is displayed");
		Assert.assertTrue(usermenupage.verifyUserMenuDropdownItems(),
				"User Menu options are missing  or does not match with the expected options");
		test.log(Status.INFO, "User menu options are verified");
		Assert.assertTrue(usermenupage.selectOptionInUserMenuDropDown(objdriver, "Developer Console"),
				"Developer Console should be clickable");
		test.log(Status.INFO, "Drop down with \"My profile\", \"My Settings\", \"Developer Console\",\"Logout\" is displayed");
		Assert.assertTrue(usermenupage.isDevConsoleWindowOpened(),"Developer Console window is not opened");
		test.log(Status.INFO, "Force.com Developer Console window is displayed and closed");
		test.log(Status.PASS, "END - TC 08 Developer Console");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void logoutApplicationTC09(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 09 LOGOUT");
		LoginPage loginpage = new LoginPage(objdriver);
		UserMenuPage usermenupage = new UserMenuPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword, true);
		test.log(Status.INFO, "Check if all User menu items is displayed");
		Assert.assertTrue(usermenupage.verifyUserMenuDropdownItems(),
				"User Menu options are missing  or does not match with the expected options");
		test.log(Status.INFO, "User menu options are verified");
			Assert.assertTrue(usermenupage.loggedout(),"Log out is failed");
			test.log(Status.INFO,"Logged out Successfully");
			test.log(Status.PASS, "END - TC 09 Logout");
	
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
		objdriver.quit();

	}

}
