package com.project.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageActions.CustomerDetailsPageActions;
import pageActions.HomePageActions;
import pageActions.LogInPageActions;
import pageActions.PaymentPageActions;
import pageObjects.HomePageElements;
import pageObjects.SideNavPageElements;
import utils.ElementFetch;

public class TC_BrowserRefresh extends BaseTest {

	ElementFetch ele = new ElementFetch();
	HomePageActions homepage = new HomePageActions();
	LogInPageActions login = new LogInPageActions();
	CustomerDetailsPageActions cust = new CustomerDetailsPageActions();
	PaymentPageActions payment = new PaymentPageActions();
	

	@Test(priority = 0, enabled = true)
	public void testBrowserRefresh() {
		login.verifyPageLoad();
		login.StandardlogIn();
		homepage.verifyLoginSuccess();
		ele.getWebElement("XPATH", HomePageElements.sauce_lab_bolt_t_shirt).click();
		ele.getWebElement("XPATH", HomePageElements.menu_btn).click();
		ele.getWebElement("XPATH", SideNavPageElements.reset_app_state_btn).click();
		ele.getWebElement("XPATH", SideNavPageElements.cross_btn).click();
		driver.navigate().refresh();
		String current_option_visible = ele.getWebElement("XPATH", HomePageElements.bolt_shirt_cart_or_remove_btn_space).getText().trim();
		Assert.assertEquals(current_option_visible.toString(),
				"Add to cart", "Remove Button is still enabled"); // Checking the visible text in the space of remove/add to cart. 
		ele.getWebElement("XPATH", HomePageElements.sauce_lab_bolt_t_shirt).isEnabled();
		logger.info("The Remove button is not visible and Add to cart again got enabled");
		String cart_value = ele.getWebElement("XPATH", HomePageElements.cart_icon_post_refresh).getText().trim();
		Assert.assertEquals(cart_value, "");// There should be no value in the cart
		logger.info("cart value is nothing or zero as expected");
		
		
	}
	
	


}
