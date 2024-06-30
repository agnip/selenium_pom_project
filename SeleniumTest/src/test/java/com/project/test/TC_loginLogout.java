package com.project.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pageActions.HomePageActions;
import pageActions.LogInPageActions;
import utils.ElementFetch;

public class TC_loginLogout extends BaseTest {

	ElementFetch ele = new ElementFetch();
	HomePageActions homepage = new HomePageActions();
	LogInPageActions login = new LogInPageActions();

	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void defaultLogInLogOut() {
		login.verifyPageLoad();
		login.StandardlogIn();
		homepage.verifyLoginSuccess();
		homepage.verifyLogoutSuccess();
	}

	@AfterClass
	public void tearDown() {
		// Close WebDriver
		if (driver != null) {
			driver.quit();
		}
	}
}
