package pageActions;

import base.BaseTest;
import pageObjects.HomePageElements;
import pageObjects.OrderSuccessPageElements;
import pageObjects.PaymentPageElements;
import utils.ElementFetch;

public class PaymentPageActions extends BaseTest {
	ElementFetch ele = new ElementFetch();
	
	public void finishPayment() {
		ele.getWebElement("XPATH", PaymentPageElements.btn_finish).click();
		ele.getWebElement("XPATH", OrderSuccessPageElements.order_success).isDisplayed();		
		logger.info("You have successfully completed the order");
		
	}
}
