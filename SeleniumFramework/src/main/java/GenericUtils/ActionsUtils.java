package GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;

public class ActionsUtils {

	Actions actions;

	public ActionsUtils(WebDriver driver) {
		actions = new Actions(driver);
	}

	/**
	 * this funtion is used to click on element
	 * 
	 * @param ele
	 */

	public void ClickOnElement(WebElement ele) {
		actions.click(ele).perform();
	}

	/**
	 * this method is used to passing the data to element
	 * 
	 * @param ele
	 * @param data
	 */
	public void passDataForElement(WebElement ele, CharSequence... data) {
		actions.sendKeys(ele, data).perform();
	}

	/**
	 * this funtion is used to move to a an element
	 * 
	 * @param ele
	 */

	public void mouseOverOnElement(WebElement ele) {
		actions.moveToElement(ele).perform();
	}

	/**
	 * this funtion is used to double click on element
	 * 
	 * @param ele
	 */

	public void doubleClickOnElemet(WebElement ele) {
		actions.doubleClick(ele).perform();
	}
	/**
	 * this f is used to perform right click on element
	 * @param ele
	 */
	public void rightClickOnElemet(WebElement ele) {
		actions.contextClick(ele).perform();
	}
	/**
	 * 
	 * @param src
	 * @param dest
	 */

	public void dragAndDropElement(WebElement src, WebElement dest) {
		actions.dragAndDrop(src, dest).perform();
	}

	public void dragAndDropElemet(WebElement ele, int XOffset, int YOffset) {
		actions.dragAndDropBy(ele, XOffset, YOffset).perform();
	}

	public void scrollBasedOnAxis(int XOffset, int YOffset) {
		actions.scrollByAmount(XOffset, YOffset).perform();
	}

	public void scrollUntilElementIsVisible(WebElement ele) {
		actions.scrollToElement(ele).perform();
	}

	public void scrollUntilElementVisible(WebElement ele, int XOffset, int YOffset) {
		ScrollOrigin origin = ScrollOrigin.fromElement(ele);
		actions.scrollFromOrigin(origin, XOffset, YOffset).perform();
	}
}
