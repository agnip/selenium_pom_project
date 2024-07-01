package pageObjects;

public interface HomePageElements {
	String product_sort = "//*[@class='product_sort_container']";
	String sort_low_to_high = "//*[@data-test='active-option' and contains(text(), 'Price (low to high)')]";
	String menu_btn = "//*[@id='react-burger-menu-btn']";
	String product_prices = "//*[@class='inventory_item_price']";
	String sauce_labs_onesie = "//*[@id='add-to-cart-sauce-labs-onesie' and contains(text(), 'Add to cart')]";
	String sauce_labs_fleece_jacket = "//*[@id='add-to-cart-sauce-labs-fleece-jacket' and contains(text(), 'Add to cart')]";
	String sauce_labs_bike_light = "//*[@id='add-to-cart-sauce-labs-bike-light']";
	String sauce_lab_bolt_t_shirt = "//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']";
	String Sauce_lab_bag= "//*[@id='add-to-cart-sauce-labs-backpack']";
	String remove_sauce_labs_onesie = "//*[@id='remove-sauce-labs-onesie']";
	String remove_sauce_labs_fleece_jacket = "//*[@id='remove-sauce-labs-fleece-jacket']";
	String remove_bolt_t_shirt = "//*[@id='remove-sauce-labs-bolt-t-shirt']";
	String remove_bag = "//*[@id='remove-sauce-labs-backpack']";
    String price_sauce_labs_fleece_jacket = "//*[@id='remove-sauce-labs-fleece-jacket']/preceding-sibling::div[@class='inventory_item_price']";
    String price_sauce_labs_onesie = "//*[@id='remove-sauce-labs-onesie']/preceding-sibling::div[@class='inventory_item_price']";
    String tc3_cart_value = "//*[@data-test='shopping-cart-badge' and contains(text(),'2')]";
    String cart_icon = "//*[@data-test='shopping-cart-badge']";
    String cart_icon_post_refresh = "//*[@id='shopping_cart_container']";
    String bolt_shirt_cart_or_remove_btn_space = "//div[@class='inventory_item_name ' and contains(text(), 'Sauce Labs Bolt T-Shirt')]/ancestor::div[contains(@class, 'inventory_item')]//button[contains(@class, 'btn_primary')]";
}
