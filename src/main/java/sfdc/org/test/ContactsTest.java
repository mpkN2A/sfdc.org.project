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
import sfdc.org.PageObjects.ContactsPage;
import sfdc.org.PageObjects.HomePage;
import sfdc.org.PageObjects.LoginPage;

public class ContactsTest  extends BaseClassPage{
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
	
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class,enabled=false)
	public void fncreateNewContactTC25(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 25 CREATE NEW CONTACT");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		ContactsPage contactpage = new ContactsPage(objdriver);
		Assert.assertTrue(contactpage.isContactPageDisplayed(), "Contact page is not displayed");
		test.log(Status.INFO, "Contact Home page should be displayed");
		Assert.assertTrue(contactpage.isContactEditPageDisplayed(), "Contact Edit page is not displayed");
		test.log(Status.INFO, "Contact Edit page should be displayed");
		Assert.assertTrue(contactpage.isNewContactCreated(), "New Contact is not Saved");
		test.log(Status.INFO, "New Contact is Saved");
		test.log(Status.PASS,"PASSED -TC 25 CREATE NEW CONTACT");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class,enabled=false)
	public void fncreateNewViewTC26(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 26 CREATE NEW VIEW");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		ContactsPage contactpage = new ContactsPage(objdriver);
		Assert.assertTrue(contactpage.isContactPageDisplayed(), "Contact page is not displayed");
		test.log(Status.INFO, "Contact Home page is displayed");
		Assert.assertTrue(contactpage.checkNewlyAddedView(), "New View is not displayed in teh dropdown");
		test.log(Status.INFO, "New View is Displayed");
		test.log(Status.PASS,"PASSED -TC 26 CREATE NEW VIEW");
		
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class,enabled=false)
	public void recentlyCreatedContactTC27(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 27 CHECK RECENTLY CREATED CONTACT");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		ContactsPage contactpage = new ContactsPage(objdriver);
		Assert.assertTrue(contactpage.isContactPageDisplayed(), "Contact page is not displayed");
		test.log(Status.INFO, "Contact Home page is displayed");
		Assert.assertTrue(contactpage.checkRecentlySelected(), "Recently Created contact is not displayed");
		test.log(Status.INFO, "Recently Created contact is displayed");		
		test.log(Status.PASS,"PASSED -TC 27 CHECK RECENTLY CREATED CONTACT");
	}
	
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void myContactsTC28(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 28 MY CONTATCS");
		test.log(Status.INFO, "Login launched");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		ContactsPage contactpage = new ContactsPage(objdriver);
		Assert.assertTrue(contactpage.isContactPageDisplayed(), "Contact page is not displayed");
		test.log(Status.INFO, "Contact Home page is displayed");
		Assert.assertTrue(contactpage.isMyContactPageDisplayed(), "My Contact View is not displayed");
		test.log(Status.INFO, "My contacts View is displayed");
		test.log(Status.PASS,"PASSED -TC 28 MY CONTATCS");	
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
		//objdriver.quit();

	}
}
