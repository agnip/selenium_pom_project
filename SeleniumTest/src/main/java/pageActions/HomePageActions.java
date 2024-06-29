package pageActions;

import org.testng.Assert;
import base.BaseTest;
import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageActions extends BaseTest {
	ElementFetch ele = new ElementFetch();
	
	// public static WebDriver driver;

	public void verifyLoginSuccess() {
		Assert.assertTrue(ele.getWebElements("XPATH", HomePageElements.product_sort).size() > 0, "Element Not Found");
		logger.info("login successful");
		driver.close();
	}

}
