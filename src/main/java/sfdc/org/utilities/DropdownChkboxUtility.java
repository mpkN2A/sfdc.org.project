package sfdc.org.utilities;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sfdc.org.PageObjects.BaseClassPage;

public class DropdownChkboxUtility extends BaseClassPage {

	public static boolean verifyDropdownMenuItems(WebElement element, String[] strArrMenuitems) {
		boolean blnIsAllMenuItemsPresent = true;
		int i = 0;
		WebDriverWait wait = new WebDriverWait(objdriver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		List<WebElement> lstElements = select.getOptions();
		for (WebElement we : lstElements) {
			String strOption = we.getText();
			try {
				Assert.assertEquals(strOption, strArrMenuitems[i],
						"The item " + strArrMenuitems[i] + " is missing in the displayed dropdownMenu");
				i++;
			} catch (Exception e) {
				blnIsAllMenuItemsPresent = false;
			}

		}
		return blnIsAllMenuItemsPresent;

	}

	public static void selectValueFromDropdown(WebElement elementDropDown, String strValue) {
		Select oSelect = new Select(elementDropDown);
		oSelect.selectByValue(strValue);

	}

	public static void selectbyVisibleTextFromDropdown(WebElement elementDropDown, String strValue) {
		Select oSelect = new Select(elementDropDown);
		oSelect.selectByVisibleText(strValue);

	}
	
	public static void checkIfSelectedElseSelect(WebElement elementDropDown, String strValue) {
		Select oSelect = new Select(elementDropDown);
		String strSelected = oSelect.getFirstSelectedOption().getText();
		if(!strSelected.equals(strValue))
		{
		oSelect.selectByVisibleText(strValue);
		}

	}

	public static boolean checkDropdownValues(WebElement element, String strValue) {

		boolean blnisValuePresent = false;
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();

		if (defaultItem.equals(strValue)) {
			blnisValuePresent = true;
		}

		return blnisValuePresent;
	}

	// Select any value fromdropdown
	public static boolean autoDropdownSelection(WebElement element, String strValue)

	{
		boolean blnSuccess = true;
		try {

			Select select = new Select(element);

			int iDropdown = objdriver.findElements(By.cssSelector(strValue)).size();
			Random random = new Random();
			int i = random.nextInt(iDropdown);
			select.selectByIndex(i);
		} catch (Exception ex) {
			blnSuccess = false;
		}

		return blnSuccess;

	}

	public static void checkCheckbox(WebElement element) {

		if (!element.isSelected()) {
			element.click();
		}

	}

	public static void uncheckCheckbox(WebElement element) {
		if (element.isSelected()) {
			element.click();
		}

	}

}
