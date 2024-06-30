package pageObjects;

public interface PaymentPageElements {

	String total_without_tax = "//*[@class='summary_subtotal_label']";
	String payment_info_label  = "//*[@data-test='payment-info-label']";
	String btn_finish = "//*[@id='finish']";
}
