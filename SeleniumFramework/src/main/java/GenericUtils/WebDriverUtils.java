package GenericUtils;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtils {
	WebDriver driver;

	public WebDriverUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToAWindowBasedOnTitle(String title) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	public void switchToAWindowBasedOnURL(String url) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if (driver.getCurrentUrl().equals(url)) {
				break;
			}
		}
	}

	public void switchToAlertAndClickOnOk() {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndClickOnCancel() {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public void passValueForAlertTextBox(String data) {
		driver.switchTo().alert().sendKeys(data);
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String nameorid) {
		driver.switchTo().frame(nameorid);
	}

	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
}
