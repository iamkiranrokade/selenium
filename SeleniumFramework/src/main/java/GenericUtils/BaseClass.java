package GenericUtils;

import java.io.File;
//import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ElementRepository.BasePage;
import ElementRepository.LoginPage;

public class BaseClass implements IAutoConstants, ITestListener {
	public static WebDriver driver;
	public FileLiabrary flib;
	public LoginPage lp;
	public BasePage bp;

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("BeforeSuite", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("BeforeTest", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("AfterSuite", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("AfterTest", true);
	}

	@Parameters("bname")
	@BeforeClass
	public void launchingBrowser(@Optional("chrome") String browserName) {

		Reporter.log("BeforeClass", true);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		}
		lp = new LoginPage(driver);
		bp = new BasePage(driver);
		flib = new FileLiabrary();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeOut));

	}

	@AfterClass
	public void tearDownBrowser() {
		Reporter.log("AfterClass", true);
		driver.close();
		driver.quit();
	}

	@BeforeMethod
	public void navigateAndLoginToDWS() {
		Reporter.log("BeforeMethod", true);
		driver.get(flib.fetchDataFromProperties(propertyFilePath, "url"));
		lp.getLoginlink().click();
		lp.getEmailtestbox().sendKeys(flib.fetchDataFromProperties(propertyFilePath, "email"));
		lp.getPassword().sendKeys(flib.fetchDataFromProperties(propertyFilePath, "password"));
		lp.getLoginbutton().click();

	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("AfterMethod", true);
		lp.getLoginlink().click();
	}

	// Listners

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("[Test case--" + result.getName() + "--is Started]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("[Test case--" + result.getName() + "--is Passed]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("[Test case--" + result.getName() + "--is failed]");
		LocalDateTime ldt = LocalDateTime.now();
		String time = ldt.toString().replace(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(ScreenShotPath, "ScreenShotPath" + time + ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (Exception e) {

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("[Test case--" + result.getName() + "--is Skipped]");
	}
	
	@Override
	public void onStart(ITestContext context) {
		Reporter.log("[Test case--" + context.getName() + "--is Started]");
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("[Test case--" + context.getName() + "--is Finished]");
	}
}
