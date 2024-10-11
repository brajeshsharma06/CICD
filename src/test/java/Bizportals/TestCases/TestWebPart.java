package Bizportals.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Bizportals.BaseTest.BaseTest;
import Bizportals.PageObject.LandingPage;
import Bizportals.PageObject.LoginPageMicrosoft;

public class TestWebPart extends BaseTest {
	// Add Web Part
	// Edit Web Part
	// Copy Web Part
	// Add instance web part
	// Delete Web Part
	// Add different web part (Two different web parts)

	@Test
	public void testCrudFunctionality() throws InterruptedException {
		LoginPageMicrosoft loginpage = goToApplication();
		LandingPage landingPage = loginpage.login("bsharma@M365x72141392.onmicrosoft.com", "Batch@123");
		landingPage.addWebPart("Bizportals Spotlight");
		String placeholderText = landingPage.webPartAddMessage();
		Assert.assertEquals(placeholderText, "Configure BizPortals Spotlight");
		landingPage.deleteWebPart();
		Assert.assertNotSame(placeholderText, "Configure BizPortals Spotlight");
	}
}
