package pageActions;

import base.BaseTest;
import pageObjects.CustomerDetailsPageElements;
import pageObjects.PaymentPageElements;
import utils.ElementFetch;

public class CustomerDetailsPageActions extends BaseTest {
	ElementFetch ele = new ElementFetch();

	public void enterCustomerDetails() {
		ele.getWebElement("XPATH", CustomerDetailsPageElements.cust_details_page_title).isDisplayed();
		ele.getWebElement("XPATH", CustomerDetailsPageElements.plchldr_first_name)
				.sendKeys(CustomerDetailsPageElements.cust_first_name);
		ele.getWebElement("XPATH", CustomerDetailsPageElements.plchldr_last_name)
				.sendKeys(CustomerDetailsPageElements.cust_last_name);
		ele.getWebElement("XPATH", CustomerDetailsPageElements.plchldr_zip_code)
				.sendKeys(CustomerDetailsPageElements.cust_pin_code);
		ele.getWebElement("XPATH", CustomerDetailsPageElements.btn_continue).click();
		ele.getWebElement("XPATH", PaymentPageElements.payment_info_label).isDisplayed();
	}

}
