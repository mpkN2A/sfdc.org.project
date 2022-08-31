package sfdc.org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DropdownChkboxUtility {
	public static void selectValueFromDropdown(WebElement elementDropDown , String strValue) {
		Select oSelect = new Select(elementDropDown);
		oSelect.selectByValue(strValue);

	}

}
