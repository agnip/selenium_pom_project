package pageObjects;

public interface LogInPageElements {
	String Uid_field = "//*[@id='user-name']";
	String pwd_field = "//*[@id='password']";
	String logIn_btn = "//*[@name='login-button']";
	String property_path = "/testdata/credentials.properties";
	String err_msg_locked_out = "//*[@data-test='error' and contains(text(), 'Epic sadface: Sorry, this user has been locked out.')]";

}
