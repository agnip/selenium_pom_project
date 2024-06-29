package com.project.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import base.BaseTest;
import pageActions.HomePageActions;
import pageActions.LogInPageActions;
import utils.ElementFetch;

public class TC_login extends BaseTest {
	
	ElementFetch ele = new ElementFetch();
	HomePageActions homepage = new HomePageActions();
	LogInPageActions login = new LogInPageActions();
  @Test (retryAnalyzer = utils.RetryAnalyzer.class )
  public void methodLoginValidation() {
	  login.verifyPageLoad();
	  login.logIn();
	  homepage.verifyLoginSuccess();
  }
}
