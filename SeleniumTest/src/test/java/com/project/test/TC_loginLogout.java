package com.project.test;

import org.testng.annotations.Test;
import base.BaseTest;
import pageActions.HomePageActions;
import pageActions.LogInPageActions;
import pageObjects.LogInPageElements;
import utils.ElementFetch;

public class TC_loginLogout extends BaseTest {

	ElementFetch ele = new ElementFetch();
	HomePageActions homepage = new HomePageActions();
	LogInPageActions login = new LogInPageActions();

	@Test(priority = 0, enabled = true)
	public void defaultLogInLogOut() {
		login.verifyPageLoad();
		login.StandardlogIn();
		homepage.verifyLoginSuccess();
		homepage.verifyLogoutSuccess();
	}

	@Test(priority = 1, enabled = true)
	public void logInWithLockedOutusr() {
		login.verifyPageLoad();
		login.logInWithLockedOutusr();
		ele.getWebElement("XPATH", LogInPageElements.err_msg_locked_out).isDisplayed();
	}

}
