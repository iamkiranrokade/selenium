package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	

	@FindBy(id ="Email")
	private WebElement emailtestbox;
	
	@FindBy(id ="Password")
	private WebElement password;
	
	@FindBy(id = "RememberMe")
	private WebElement remembermecheckbox;
	
	@FindBy(partialLinkText = "Forgot password?")
	private WebElement forgotpasswordlink;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginbutton;
    
	/**
	 * this method is used to get emailtextbox
	 * @return WebElement
	 */
	public WebElement getEmailtestbox() {
		return emailtestbox;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getRemembermecheckbox() {
		return remembermecheckbox;
	}

	public WebElement getForgotpasswordlink() {
		return forgotpasswordlink;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	

}
