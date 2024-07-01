package com.project.test;

import org.testng.annotations.Test;
import base.BaseTest;
import pageActions.CustomerDetailsPageActions;
import pageActions.HomePageActions;
import pageActions.LogInPageActions;
import pageActions.PaymentPageActions;
import pageObjects.CartPageElements;
import pageObjects.HomePageElements;
import utils.ElementFetch;

public class TC_ErrorUser extends BaseTest {

	ElementFetch ele = new ElementFetch();
	HomePageActions homepage = new HomePageActions();
	LogInPageActions login = new LogInPageActions();
	CustomerDetailsPageActions cust = new CustomerDetailsPageActions();
	PaymentPageActions payment = new PaymentPageActions();

	@Test(priority = 0, enabled = true)
	public void testWithErrlogin() {
		login.verifyPageLoad();
		login.ErrorlogIn();
		homepage.verifyLoginSuccess();
		ele.getWebElement("XPATH", HomePageElements.sauce_labs_bike_light).click();
		ele.getWebElement("XPATH", HomePageElements.cart_icon).click();
		ele.getWebElement("XPATH", CartPageElements.cart_page_title).isDisplayed();
		logger.info("We are in Cart page");
		ele.getWebElement("XPATH", CartPageElements.btn_checkout).click();
		cust.enterCustomerDetails();
		payment.finishPaymentCompleOrder();
	}
	
}
