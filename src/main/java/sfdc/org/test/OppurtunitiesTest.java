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
import sfdc.org.PageObjects.OppurtunitiesPage;
import sfdc.org.utilities.PageObjectUtility;

public class OppurtunitiesTest extends BaseClassPage {
	public static ExtentReports extent;
	public static ExtentTest test;
	public String strPageTitle = "Opportunities: Home ~ Salesforce - Developer Edition";

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
	public void dropdownOpportunitiesTC15(String strUsername, String strPassword) {
		ExtentTest test = extent.createTest("START - TC 15 VALIDATE  OPPORTUNITIES DROPDOWN");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		OppurtunitiesPage opportunitypage = new OppurtunitiesPage(objdriver);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		test.log(Status.INFO, "Verify if all menuitems is displayed in opportunity");
		Assert.assertEquals(opportunitypage.verifyOppTitle(),strPageTitle,"opportunity page is not seen");
		test.log(Status.INFO, "Opportunities home page is displayed");
		Assert.assertTrue(opportunitypage.verifyOppurtunityDropdown(),"Displayed menuItems does not match with the expected menu items");
		test.log(Status.INFO,"Menu Items verified Succesfully");	
		test.log(Status.PASS, "PASSED -TC 15 VALIDATE  OPPORTUNITIES DROPDOWN");
		
	}
	

	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void CreateNewOptyTC16(String strUsername, String strPassword) throws InterruptedException {
		ExtentTest test = extent.createTest("START - TC 16 CREATE NEW OPPORTUNITY");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		OppurtunitiesPage opportunitypage = new OppurtunitiesPage(objdriver);
		PageObjectUtility.waitTimeForPageTitle(SFDeveloperPageTitle);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertEquals(opportunitypage.verifyOppTitle(),strPageTitle,"opportunity page is not seen");
		test.log(Status.INFO, "Opportunities home page is displayed");
		Assert.assertTrue(opportunitypage.verifyNewoppIsDisplayed(),"New opportunity not displayed");
		test.log(Status.INFO, "New Opportunity page is displayed with Opportunity details.");
		test.log(Status.PASS, "PASSED -TC 16 CREATE NEW OPPORTUNITY");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void opportunityPipelineReportTC17(String strUsername, String strPassword) throws InterruptedException {
		ExtentTest test = extent.createTest("START - TC 17 CREATE OPPORTUNITY PIPELINE REPORT");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		OppurtunitiesPage opportunitypage = new OppurtunitiesPage(objdriver);
		PageObjectUtility.waitTimeForPageTitle(SFDeveloperPageTitle);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertEquals(opportunitypage.verifyOppTitle(),strPageTitle,"opportunity page is not seen");
		test.log(Status.INFO, "Opportunities home page is displayed");
		Assert.assertTrue(opportunitypage.verifyReportPageIsDisplayed(),"Report Page is not displayed");
		test.log(Status.INFO, "Report Page with the Opportunities that are pipelined is be displayed.");
		test.log(Status.PASS, "PASSED -TC 17 CREATE OPPORTUNITY PIPELINE REPORT");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void stuckOpportunitiesTC18(String strUsername, String strPassword) throws InterruptedException {
		ExtentTest test = extent.createTest("START - TC 18 CREATE STUCK OPPORTUNITY REPORT");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		OppurtunitiesPage opportunitypage = new OppurtunitiesPage(objdriver);
		PageObjectUtility.waitTimeForPageTitle(SFDeveloperPageTitle);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertEquals(opportunitypage.verifyOppTitle(),strPageTitle,"opportunity page is not seen");
		test.log(Status.INFO, "Opportunities home page is displayed");
		Assert.assertTrue(opportunitypage.verifyStuckReportPageIsDisplayed(),"Report Page is not displayed");
		test.log(Status.INFO, "Report Page with the Opportunities that are Stuck is displayed.");
		test.log(Status.PASS, "PASSED -TC 18 CREATE STUCK OPPORTUNITY REPORT");
	}
	@Test(dataProvider = "ValidCredentials", dataProviderClass = sfdc.org.utilities.ReadExcelData.class)
	public void quarterlySummaryReportTC19(String strUsername, String strPassword) throws InterruptedException {
		ExtentTest test = extent.createTest("START - TC 19 CREATE Q4 SUMMARY REPORT");
		LoginPage loginpage = new LoginPage(objdriver);
		loginpage.loginToApp(strUsername, strPassword);
		HomePage objHomePage = new HomePage(objdriver);
		OppurtunitiesPage opportunitypage = new OppurtunitiesPage(objdriver);
		PageObjectUtility.waitTimeForPageTitle(SFDeveloperPageTitle);
		Assert.assertTrue(objHomePage.getHomePageTitle().equals(SFDeveloperPageTitle));
		test.log(Status.INFO, "Sales force home page is displayed");
		Assert.assertEquals(opportunitypage.verifyOppTitle(),strPageTitle,"opportunity page is not seen");
		test.log(Status.INFO, "Opportunities home page is displayed");
		Assert.assertTrue(opportunitypage.verifyQuarterlyReportPage(),"Q4 Summary Report Page is not displayed");
		test.log(Status.INFO, "Report Page with the Opportunities that satisfies the search criteria will be displayed.");
		test.log(Status.PASS, "PASSED -TC 19 CREATE Q4 SUMMARY REPORT");
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
