package pageActions;

import java.io.FileInputStream;
import base.BaseTest;
import pageObjects.LogInPageElements;
import utils.ElementFetch;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LogInPageActions extends BaseTest {

	ElementFetch ele = new ElementFetch();
	BaseTest base;
	private Properties properties;

	// Method to load properties from a file
	private void loadProperties() {
		properties = new Properties();
		String ProjectPath = System.getProperty("user.dir");
		try (InputStream inputStream = new FileInputStream(ProjectPath + LogInPageElements.property_path)) {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception according to your application's error handling strategy
		}
	}

	public void verifyPageLoad() {
		logger.info("Launching application in browser");
		ele.getWebElement("XPATH", LogInPageElements.Uid_field).isDisplayed();
		ele.getWebElement("XPATH", LogInPageElements.pwd_field).isDisplayed();
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).isEnabled();
		logger.info("All fields are visible and enabled");

	}

	public void StandardlogIn() {

		if (properties == null) {
			loadProperties(); // Load properties if not already loaded
		}
		String uid = properties.getProperty("standardUser");
		String password = properties.getProperty("password");
		logger.info("Testing login with " + uid);
		ele.getWebElement("XPATH", LogInPageElements.Uid_field).sendKeys(uid);
		ele.getWebElement("XPATH", LogInPageElements.pwd_field).sendKeys(password);
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).click();
		logger.info("Entered credential and pressed login");
	}
	
	
	public void ErrorlogIn() {

		if (properties == null) {
			loadProperties(); // Load properties if not already loaded
		}
		String uid = properties.getProperty("errorUser");
		String password = properties.getProperty("password");
		logger.info("Testing login with " + uid);
		ele.getWebElement("XPATH", LogInPageElements.Uid_field).sendKeys(uid);
		ele.getWebElement("XPATH", LogInPageElements.pwd_field).sendKeys(password);
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).click();
		logger.info("Entered credential and pressed login");
	}
	
	public void perfUserlogIn() {

		if (properties == null) {
			loadProperties(); // Load properties if not already loaded
		}
		String uid = properties.getProperty("performanceGlitchUser");
		String password = properties.getProperty("password");
		logger.info("Testing login with " + uid);
		ele.getWebElement("XPATH", LogInPageElements.Uid_field).sendKeys(uid);
		ele.getWebElement("XPATH", LogInPageElements.pwd_field).sendKeys(password);
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).click();
		logger.info("Entered credential and pressed login");
	}

	public void logInWithLockedOutusr() {

		if (properties == null) {
			loadProperties(); // Load properties if not already loaded
		}
		String lockedOutUser = properties.getProperty("lockedOutUser");
		String password = properties.getProperty("password");
		logger.info("Testing login with " + lockedOutUser);
		ele.getWebElement("XPATH", LogInPageElements.Uid_field).sendKeys(lockedOutUser);
		ele.getWebElement("XPATH", LogInPageElements.pwd_field).sendKeys(password);
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).click();
		logger.info("Entered lockedout credential and pressed login");

	}

}
