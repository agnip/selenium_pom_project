package pageActions;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.HomePageElements;
import pageObjects.LogInPageElements;
import utils.ElementFetch;

public class LogInPageActions extends BaseTest {
	
	ElementFetch ele  = new ElementFetch();
	
	public void verifyPageLoad() {
		logger.info("Launching application in browser");
		ele.getWebElement("XPATH", LogInPageElements.Uid_field).isDisplayed();	
		ele.getWebElement("XPATH", LogInPageElements.pwd_field).isDisplayed();
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).isEnabled();
		logger.info("Check credital spaces are enabled");
	
	}
	
	public void logIn() {
		 ele.getWebElement("XPATH", LogInPageElements.Uid_field).sendKeys("standard_user");
		 ele.getWebElement("XPATH", LogInPageElements.pwd_field).sendKeys("secret_sauce");
		 ele.getWebElement("XPATH", LogInPageElements.logIn_btn).click();
		 logger.info("Entered credential and pressed login");
	}

}
