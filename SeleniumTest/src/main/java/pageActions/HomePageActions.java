package pageActions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import base.BaseTest;
import pageObjects.HomePageElements;
import pageObjects.LogInPageElements;
import pageObjects.SideNavPageElements;
import utils.ElementFetch;
import java.util.stream.Collectors;

public class HomePageActions extends BaseTest {
	ElementFetch ele = new ElementFetch();
	List<Double> prices = new ArrayList<>();

	public void verifyLoginSuccess() {
		Assert.assertTrue(ele.getWebElements("XPATH", HomePageElements.product_sort).size() > 0, "Element Not Found");
		logger.info("login successful");

	}

	public void selectOptionFromDropdown(By locator, String visibleText) {
		// method to select option from dropdown
		WebElement dropdownElement = driver.findElement(locator);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(visibleText);
	}

	public void verifyLogoutSuccess() {
		logger.info("Logging out ...");
		
		WebElement element = driver.findElement(By.xpath(HomePageElements.menu_btn));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		
		//ele.getWebElement("XPATH", HomePageElements.menu_btn).click();
		ele.getWebElement("XPATH", SideNavPageElements.logout_btn).click();
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).isDisplayed();
		logger.info("Logout Successful");

	}

	private boolean isSorted(List<Double> prices) {
		for (int i = 0; i < prices.size() - 1; i++) {
			if (prices.get(i) > prices.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public void verifyLowToHighSort() {
		By dropdownLocator = By.xpath(HomePageElements.product_sort);
		selectOptionFromDropdown(dropdownLocator, "Price (low to high)");
		ele.getWebElement("XPATH", HomePageElements.sort_low_to_high).isDisplayed();
		logger.info("Sorting by low to high is successful");
		logger.info("Store all the visible prices in a list");
		List<WebElement> priceElements = ele.getWebElements("XPATH", HomePageElements.product_prices);
		List<String> visibleTextList = priceElements.stream().map(WebElement::getText).collect(Collectors.toList());
		System.out.println(visibleTextList);

		for (String element : visibleTextList) {
			String priceText = element.replace("$", ""); // Parsing the dollar sign
			double price = Double.parseDouble(priceText);
			prices.add(price);
			// logger.info(priceText);
		}
		Assert.assertTrue(isSorted(prices), "The list of integers is not sorted in ascending order.");
		logger.info("low to high is properly sorted");
	}

}
