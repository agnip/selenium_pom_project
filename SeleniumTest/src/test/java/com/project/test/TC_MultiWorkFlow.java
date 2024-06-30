package com.project.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import base.BaseTest;
import org.testng.Assert;
import pageActions.CustomerDetailsPageActions;
import pageActions.HomePageActions;
import pageActions.LogInPageActions;
import pageActions.PaymentPageActions;
import pageObjects.CartPageElements;
import pageObjects.HomePageElements;
import pageObjects.PaymentPageElements;
import utils.ElementFetch;

public class TC_MultiWorkFlow extends BaseTest {

	ElementFetch ele = new ElementFetch();
	HomePageActions homepage = new HomePageActions();
	LogInPageActions login = new LogInPageActions();
	CustomerDetailsPageActions cust = new CustomerDetailsPageActions();
	PaymentPageActions payment = new PaymentPageActions();

	@Test(priority = 0, enabled = true)
	public void multiFlow() throws InterruptedException {
		login.verifyPageLoad();
		login.StandardlogIn();
		homepage.verifyLoginSuccess();
		homepage.verifyLowToHighSort();
		WebElement onesie_add_to_cart = ele.getWebElement("XPATH", HomePageElements.sauce_labs_onesie);
		WebElement fleece_jacket_add_to_cart = ele.getWebElement("XPATH", HomePageElements.sauce_labs_fleece_jacket);
		onesie_add_to_cart.click();
		logger.info("first add to cart complete");
		BaseTest.scrollToPosition(driver, 0, 250);
		logger.info("scroll successful");
		fleece_jacket_add_to_cart.click();
		logger.info("Both Itmes added to cart");
		By cart1_stale_locator = By.xpath(HomePageElements.sauce_labs_onesie);
		By cart2_stale_locator = By.xpath(HomePageElements.sauce_labs_onesie);
		List<WebElement> cart1 = driver.findElements(cart1_stale_locator);
		List<WebElement> cart2 = driver.findElements(cart2_stale_locator);

		if (!cart1.isEmpty() && !cart2.isEmpty()) {
			System.out.println("Elements are present on the page.");
		} else {
			System.out.println("Elements are not present on the page.");
		}
		ele.getWebElement("XPATH", HomePageElements.remove_sauce_labs_onesie).isEnabled();
		ele.getWebElement("XPATH", HomePageElements.remove_sauce_labs_fleece_jacket).isEnabled();
		logger.info("Both of the remove buttons are enabled");
		String price1 = ele.getWebElement("XPATH", HomePageElements.price_sauce_labs_onesie).getText().trim();
		String price2 = ele.getWebElement("XPATH", HomePageElements.price_sauce_labs_fleece_jacket).getText().trim();
		logger.info("price for labs_onesie is " + price1);
		logger.info("price for labs_fleece_jacket is " + price2);
		ele.getWebElement("XPATH", HomePageElements.tc3_cart_value).isDisplayed();
		logger.info("cart value is 2");
		ele.getWebElement("XPATH", HomePageElements.cart_icon).click();
		ele.getWebElement("XPATH", CartPageElements.cart_page_title).isDisplayed();
		logger.info("We are in Cart page");
		String price1_cart = ele.getWebElement("XPATH", CartPageElements.cart_price_sauce_labs_onesie).getText().trim();
		String price2_cart = ele.getWebElement("XPATH", CartPageElements.cart_price_sauce_labs_fleece_jacket).getText()
				.trim();
		Assert.assertEquals(price1.toString().toLowerCase(), price1_cart.toString().toLowerCase(),
				"price_sauce_labs_onesie does not match in both pages");
		Assert.assertEquals(price2.toString().toLowerCase(), price2_cart.toString().toLowerCase(),
				"price_sauce_labs_fleece_jacket does not match in both pages");
		logger.info("Both the price in cart page matches respectively with item page price");
		ele.getWebElement("XPATH", CartPageElements.cart_remove_sauce_labs_onesie).click();
		String qty_in_list_fleece_jacket = ele.getWebElement("XPATH", CartPageElements.cart_quantity_labs_fleece_jacket)
				.getText().trim();
		String current_cart_quantity = ele.getWebElement("XPATH", CartPageElements.cart_icon).getText().trim();
		Assert.assertEquals(qty_in_list_fleece_jacket.toString().toLowerCase(),
				current_cart_quantity.toString().toLowerCase(), "Quantity of jacket in both place are not same");
		logger.info("Cart quantity is matching at both places");
		ele.getWebElement("XPATH", CartPageElements.btn_checkout).click();
		cust.enterCustomerDetails();
		String total_payment_page = ele.getWebElement("XPATH", PaymentPageElements.total_without_tax).getText().trim();
		logger.info(total_payment_page);
		String final_price = total_payment_page.substring(total_payment_page.indexOf("$"));
		logger.info(final_price);
		Assert.assertEquals(price2.toString().toLowerCase(), final_price.toString().toLowerCase(),
				"price of home page and payment page not matching");
		logger.info("price of home page and payment page are matching");
		payment.finishPayment();

	}

	@AfterClass
	public void tearDown() {
		// Close WebDriver
		if (driver != null) {
			driver.quit();
		}
	}

}
