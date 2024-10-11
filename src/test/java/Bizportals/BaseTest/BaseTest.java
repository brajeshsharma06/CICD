package Bizportals.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Bizportals.PageObject.LoginPageMicrosoft;

public class BaseTest {
	WebDriver driver;

	public void intializeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public LoginPageMicrosoft goToApplication() {
		driver.get("https://m365x72141392.sharepoint.com/sites/QA-Brajesh/SitePages/Testing.aspx");
		LoginPageMicrosoft loginpage = new LoginPageMicrosoft(driver);
		return loginpage;
	}

	@BeforeMethod
	public void launchApplication() {
		intializeDriver();
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}
}
