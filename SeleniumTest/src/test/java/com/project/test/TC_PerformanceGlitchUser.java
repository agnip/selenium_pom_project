package com.project.test;

import org.testng.annotations.Test;
import base.BaseTest;
import pageActions.CustomerDetailsPageActions;
import pageActions.HomePageActions;
import pageActions.LogInPageActions;
import pageActions.PaymentPageActions;
import pageObjects.CartPageElements;
import pageObjects.HomePageElements;
import pageObjects.SideNavPageElements;
import utils.ElementFetch;

public class TC_PerformanceGlitchUser extends BaseTest {
	
	ElementFetch ele = new ElementFetch();
	HomePageActions homepage = new HomePageActions();
	LogInPageActions login = new LogInPageActions();
	CustomerDetailsPageActions cust = new CustomerDetailsPageActions();
	PaymentPageActions payment = new PaymentPageActions();
	
	
	@Test(priority = 0, enabled = true)
	public void testWithPerfUser() {
		login.verifyPageLoad();
		login.perfUserlogIn();
		homepage.verifyLoginSuccess();
		ele.getWebElement("XPATH", HomePageElements.Sauce_lab_bag).click();
		ele.getWebElement("XPATH", HomePageElements.cart_icon).click();
		ele.getWebElement("XPATH", CartPageElements.cart_page_title).isDisplayed();
		logger.info("We are in cart page");
		ele.getWebElement("XPATH", CartPageElements.menu_btn).click();
		ele.getWebElement("XPATH", SideNavPageElements.all_item_btn).click();
		homepage.verifyLoginSuccess();
		logger.info("Successfully returned back to homepage");
		ele.getWebElement("XPATH", HomePageElements.remove_bag).click();
		homepage.verifyLogoutSuccess();

	}

}


