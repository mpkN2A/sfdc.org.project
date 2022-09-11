package sfdc.org.utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.org.PageObjects.BaseClassPage;

public class PopupAndAlertsUtility extends BaseClassPage {
	public static void checkIfAlertisShown() {
		WebDriverWait wait = new WebDriverWait(objdriver, Duration.ofSeconds(50));
		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			System.out.println("alert was not present");
		} else {
			Alert alert = objdriver.switchTo().alert();
			alert.accept();
			System.out.println("alert was present and accepted");
		}

	}

	public static void switchtoDefaultFrame() {
		try {
			// "Navigated back to webpage from frame"
			objdriver.switchTo().defaultContent();

		} catch (Exception e) {
			System.out.println("unable to navigate back to main webpage from frame" + e.getStackTrace());
		}
	}

	public static void switchToFrame(String ParentFrame, String ChildFrame) {
		try {
			objdriver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			System.out.println("Navigated to innerframe with id " + ChildFrame + "which is present on frame with id"
					+ ParentFrame);
		} catch (NoSuchFrameException e) {
			System.out
					.println("Unable to locate frame with id " + ParentFrame + " or " + ChildFrame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to innerframe with id " + ChildFrame
					+ "which is present on frame with id" + ParentFrame + e.getStackTrace());
		}
	}

	public static void lookupframe(int strFrameID, WebElement element)

	{
		String parentwindow = objdriver.getWindowHandle();
		Set<String> childwindows = objdriver.getWindowHandles();
		for (String wh : childwindows) {
			if (!wh.equals(parentwindow)) {

				objdriver.switchTo().window(wh);
				objdriver.switchTo().frame(1);
				ActionsUtility.clickAction(element);

			}
		}
		objdriver.switchTo().window(parentwindow);
		

	}
}
