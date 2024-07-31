package com.groupExecutionClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class vickyKaushal {
	@Test(groups="Bollywood")
	public void execute(){
	Reporter.log("vickyKaushal",true);
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.instagram.com/vickykaushal09/?hl=en");
    }
}
