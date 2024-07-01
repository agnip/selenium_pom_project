package pageObjects;

public interface SideNavPageElements {
	
	String cross_btn = "//*[@id='react-burger-cross-btn']";
	String logout_btn = "//*[@id='logout_sidebar_link']";
	String reset_app_state_btn = "//*[@id='reset_sidebar_link']";
	String all_item_btn = "//*[@id='inventory_sidebar_link' and contains(text(),'All Items')]";

}
