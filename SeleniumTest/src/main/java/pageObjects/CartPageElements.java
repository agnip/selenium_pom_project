package pageObjects;

public interface CartPageElements {
	String cart_page_title = "//*[@class='title' and contains(text(), 'Your Cart')]";
	String cart_price_sauce_labs_fleece_jacket = "//*[@id='remove-sauce-labs-fleece-jacket']/preceding-sibling::div[@class='inventory_item_price']";
    String cart_price_sauce_labs_onesie = "//*[@id='remove-sauce-labs-onesie']/preceding-sibling::div[@class='inventory_item_price']"; 
    String cart_remove_sauce_labs_onesie = "//*[@id='remove-sauce-labs-onesie']";
    String cart_icon = "//*[@data-test='shopping-cart-badge']";
    String btn_checkout = "//*[@id='checkout']";
    String menu_btn = "//*[@id='react-burger-menu-btn']";
    String cart_quantity_labs_fleece_jacket = "//*[@class='inventory_item_name' and contains(text(), 'Sauce Labs Fleece Jacket')]/parent::a/parent::div/parent::div/div[@class='cart_quantity']";
}
