package sfdc.org.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.org.utilities.ActionsUtility;

/**
 * @author athiranihit
 *
 */
/**
 * @author athiranihit
 *
 */
/**
 * @author athiranihit
 *
 */
public class LoginPage extends BaseClassPage {

	public LoginPage(WebDriver objdriver) {
		PageFactory.initElements(objdriver, this);
	}

	// Textbox 'User Name'
	@FindBy(id = "username")
	public WebElement user_name;

	// Textbox 'Password'
	@FindBy(id = "password")
	public WebElement user_password;

	// Button 'Log in'
	@FindBy(id = "Login")
	public WebElement loginbutton;

	// label 'login error message'
	@FindBy(id = "error")
	public WebElement login_errormessage;

	// Checkbox 'Remember Me'*********
	@FindBy(id = "rememberUn")
	public WebElement login_rememberme;

	// TextLink 'UserName ID'
	@FindBy(id = "idcard-identity")
	public WebElement username_idcard;

	// TextLink 'Forgot Password'
	@FindBy(xpath = "//*[@id=\"forgot_password_link\"]")
	public WebElement forgot_password;

	public void enterUsername(String strUsername) {
		user_name.sendKeys(strUsername);
	}

	public void enterPassword(String strPassword) {
		user_password.sendKeys(strPassword);
	}

	public void clickLogin() {
		ActionsUtility.clickAction(loginbutton);
		// loginbutton.click();
	}

	public void clearPassword() {
		user_password.clear();
	}

	public String getErrorMessage() {

		String strErrormsg = ActionsUtility.getTextValue(login_errormessage);
		return strErrormsg;
	}

	public boolean isFreeTrailSeen() {
		return false;
	}

	/**
	 * This POM method will be exposed in test case to login in SFDC application
	 * 
	 * @param strUsername
	 * 
	 * @param strPassword
	 * 
	 * @return
	 * 
	 */
	public void loginToApp(String strUsername, String strPassword) {
		// Fill Username
		enterUsername(strUsername);
		// Fill password
		enterPassword(strPassword);
		// Click Login button
		clickLogin();
	}

	/**
	 * This POM method will be exposed in test case to login in SFDC application
	 * with remember me check box options
	 * 
	 * @param strUsername
	 * 
	 * @param strPassword
	 * 
	 * @return
	 * 
	 */
	public void loginToApp(String strUsername, String strPassword, boolean blnCheckRememberMe) {
		// Fill Username
		enterUsername(strUsername);
		// Fill password
		enterPassword(strPassword);
		// Click Login button
		if (blnCheckRememberMe) {
			ActionsUtility.checkUncheckBox(login_rememberme, blnCheckRememberMe);
		}

		clickLogin();
	}

	// Get the title of Login Page

	public String getLoginTitle() {

		return objdriver.getTitle();
	}
	public boolean isSavedUsernameSeen() {
		
		boolean blnresult=ActionsUtility.verifyIfDisplayed(username_idcard);
		
		return blnresult;
		
	}

	public String getSavedUsername() {
		return username_idcard.getText();
	}

}
