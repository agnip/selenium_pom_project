package pageActions;

import org.testng.Assert;
import base.BaseTest;
import pageObjects.HomePageElements;
import pageObjects.LogInPageElements;
import utils.ElementFetch;

public class HomePageActions extends BaseTest {
	ElementFetch ele = new ElementFetch();

	// public static WebDriver driver;

	public void verifyLoginSuccess() {
		Assert.assertTrue(ele.getWebElements("XPATH", HomePageElements.product_sort).size() > 0, "Element Not Found");
		logger.info("login successful");

	}

	public void verifyLogoutSuccess() {
		logger.info("Logging out ...");
		ele.getWebElement("XPATH", HomePageElements.menu_btn).click();
		ele.getWebElement("XPATH", HomePageElements.logout_btn).click();
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).isDisplayed();
		logger.info("Logout Successful");
		driver.close();

	}

}
