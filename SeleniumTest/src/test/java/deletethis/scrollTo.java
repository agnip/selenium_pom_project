package deletethis;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageActions.HomePageActions;
import pageActions.LogInPageActions;
import pageObjects.LogInPageElements;
import utils.ElementFetch;

public class scrollTo extends BaseTest {
	ElementFetch ele = new ElementFetch();
	HomePageActions homepage = new HomePageActions();
	LogInPageActions login = new LogInPageActions();
	
	public static void scrollToPosition(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(arguments[0], arguments[1])", x, y);
    }
  @Test
  @Parameters("browser")
  public void f() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		//driver.manage().timeouts().implicitlyWait(3, java.util.concurrent.TimeUnit.SECONDS);
		ele.getWebElement("XPATH", LogInPageElements.Uid_field).sendKeys("standard_user");
		ele.getWebElement("XPATH", LogInPageElements.pwd_field).sendKeys("secret_sauce");
		ele.getWebElement("XPATH", LogInPageElements.logIn_btn).click();
		homepage.verifyLoginSuccess();
		scrollToPosition(driver,0,250);
		System.out.println("Scroll successful");
		
	  
  }
}
