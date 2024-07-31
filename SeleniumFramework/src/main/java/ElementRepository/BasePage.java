package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
         @FindBy(partialLinkText = "Register")
         private WebElement Registerlink;
         
         @FindBy(partialLinkText = "Log in")
         private WebElement Loginlink;
         
         @FindBy(partialLinkText = "Shopping cart")
         private WebElement shoppingcartlink;
         
         @FindBy(partialLinkText = "Wishlist")
         private WebElement wishtlistlink;
         
         @FindBy(partialLinkText = "BOOKS")
         private WebElement bookslink;
         
         @FindBy(partialLinkText = "COMPUTERS")
         private WebElement computerslink;
         
         /**
          * This Method is used to access the Registerlink
          * @return WebElement
          */
         public WebElement getRegisterlink() {
        	
			return Registerlink;
		}
         
         /**
          * This method is used to Access The Loginlink
          * @return WebElement
          */
		public WebElement getLoginlink() {
			return Loginlink;
		}
		
		/**
		 * This method is used to access Shoppingcartlink
		 * @return WebElement
		 */

		public WebElement getShoppingcartlink() {
			return shoppingcartlink;
		}

		public WebElement getWishtlistlink() {
			return wishtlistlink;
		}

		public WebElement getBookslink() {
			return bookslink;
		}

		public WebElement getComputerslink() {
			return computerslink;
		}

		public WebElement getElectronicslink1() {
			return electronicslink;
		}

		public WebElement getApparalandshowslink() {
			return apparalandshowslink;
		}

		public WebElement getElectronicslink() {
			return Electronicslink;
		}

		public WebElement getJewelrylink() {
			return jewelrylink;
		}

		public WebElement getGiftcardslink() {
			return giftcardslink;
		}

		public WebElement getSearchbox() {
			return searchbox;
		}

		public WebElement getSearchbutton() {
			return searchbutton;
		}

		@FindBy(partialLinkText = "ELECTRONICS")
         private WebElement electronicslink;
		
		@FindBy(partialLinkText = "Cell phones")
        private WebElement cellponelink;
		
		@FindBy(linkText  = "Smartphone")
       private WebElement smartphonelink;
         
         @FindBy(partialLinkText = "APPARAL & SHOES")
         private WebElement apparalandshowslink;
         
         @FindBy(partialLinkText = "DIGITAL DOWNLOADS")
         private WebElement Electronicslink;
         
         @FindBy(partialLinkText = "JEWELRY")
         private WebElement jewelrylink;
         
         @FindBy(partialLinkText = "GIFTCARDS")
         private WebElement giftcardslink;
         
         @FindBy(id = "small-searchterms")
         private WebElement searchbox;
         
         @FindBy(xpath = "//input[@value='Search']")
         private WebElement searchbutton;
         
         @FindBy(partialLinkText = "Log out")
         private WebElement logoutLink;
         
         public WebElement getLogoutLink() {
			return logoutLink;
		}

		public void setLogoutLink(WebElement logoutLink) {
			this.logoutLink = logoutLink;
		}

		public WebElement getCellponelink() {
			return cellponelink;
		}

		public WebElement getSmartphonelink() {
			return smartphonelink;
		}

		public BasePage(WebDriver driver){
        	 PageFactory.initElements(driver,this);
         }
         
         
         
         
         
         
}
