package Bizportals.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Bizportals.BaseTest.BaseTest;
import Bizportals.PageObject.LandingPage;
import Bizportals.PageObject.LoginPageMicrosoft;

public class TestLoginFunctionality extends BaseTest {
	@Test
	public void TestLoginWithValidCredentials() throws InterruptedException {
		LoginPageMicrosoft loginpage = goToApplication();
		loginpage.loginPage("bsharma@M365x72141392.onmicrosoft.com", "Batch@123");
		String successMessage = loginpage.successTextMessage();
		Assert.assertEquals(successMessage, "Do this to reduce the number of times you are asked to sign in.");
	}

	@Test
	public void TestLoginWithInvalidPassword() throws InterruptedException {
		LoginPageMicrosoft loginpage = goToApplication();
		loginpage.loginPage("bsharma@M365x72141392.onmicrosoft.com", "Invalid Password");
		String errorLoginMessage = loginpage.errorMessage();
		Assert.assertEquals(errorLoginMessage,
				"Your account or password is incorrect. If you don't remember your password, reset it now.");
	}

	@Test
	public void TestLoginWithInvalidUsername() throws InterruptedException {
		LoginPageMicrosoft loginpage = goToApplication();
		loginpage.loginPage("invalidusername@M365x72141392.onmicrosoft.com", "Batch@123");
		String incorrectUsername = loginpage.usernameerrorMessage();
		Assert.assertEquals(incorrectUsername,
				"This username may be incorrect. Make sure that you typed it correctly. Otherwise, contact your admin.");
	}

	@Test
	public void TestLoginWithBlankFields() throws InterruptedException {
		LoginPageMicrosoft loginpage = goToApplication();
		loginpage.loginPage("", "");
		String incorrectUsername = loginpage.usernameerrorMessage();
		Assert.assertEquals(incorrectUsername, "Enter a valid email address, phone number or Skype name.");
	}

	@Test
	public void Logout() throws InterruptedException {
		LoginPageMicrosoft loginpage = goToApplication();
		LandingPage landingPage = loginpage.login("bsharma@M365x72141392.onmicrosoft.com", "Batch@123");
		landingPage.logout();
	}
}
