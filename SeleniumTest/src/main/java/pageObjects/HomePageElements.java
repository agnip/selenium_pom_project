package pageObjects;

public interface HomePageElements {
	String product_sort = "//*[@class='product_sort_container']";
	String sort_low_to_high = "//*[@data-test='active-option' and contains(text(), 'Price (low to high)')]";
	String menu_btn = "//*[@id='react-burger-menu-btn']";
	String logout_btn = "//*[@id='logout_sidebar_link']";
	String product_prices = "//*[@class='inventory_item_price']";
	String sauce_labs_onesie = "//*[@id='add-to-cart-sauce-labs-onesie' and contains(text(), 'Add to cart')]";
	String sauce_labs_fleece_jacket = "//*[@id='add-to-cart-sauce-labs-fleece-jacket' and contains(text(), 'Add to cart')]";
	String remove_sauce_labs_onesie = "//*[@id='remove-sauce-labs-onesie']";
	String remove_sauce_labs_fleece_jacket = "//*[@id='remove-sauce-labs-fleece-jacket']";
    String price_sauce_labs_fleece_jacket = "//*[@id='remove-sauce-labs-fleece-jacket']/preceding-sibling::div[@class='inventory_item_price']";
    String price_sauce_labs_onesie = "//*[@id='remove-sauce-labs-onesie']/preceding-sibling::div[@class='inventory_item_price']";
    String tc3_cart_value = "//*[@data-test='shopping-cart-badge' and contains(text(),'2')]";
    String cart_icon = "//*[@data-test='shopping-cart-badge']";
}
