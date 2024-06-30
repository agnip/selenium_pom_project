package pageObjects;

public interface CustomerDetailsPageElements {
	
	String cust_details_page_title = "//*[@class='title' and contains(text(), 'Checkout: Your Information')]";
	String plchldr_first_name = "//*[@placeholder='First Name']";
	String cust_first_name = "Agnip";
	String cust_last_name = "Karmakar";
	String cust_pin_code = "713104";
 	String plchldr_last_name = "//*[@placeholder='Last Name']";
	String plchldr_zip_code = "//*[@id='postal-code']";
	String btn_continue = "//*[@id='continue']";
	
	

}
