package com.automation.steps;

import org.openqa.selenium.WebDriver;
import com.automation.driver.BaseUtil;
import com.automation.driver.DriverManager;
import co.automation.utils.CommonActions;
import com.automation.pages.LoginPage;
import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonActions {
	LoginPage loginPage = new LoginPage();
	
	@Given("User launches the O-LAMP application")
	public void user_launches_the_o_lamp_application() {
		 WebDriver driver = DriverManager.getDriver();
		   

		   driver.get("https://olampstag.secuodsoft.com/");
		    driver.manage().window().maximize();
	    
	}

	@When("User enters valid mobile number")
	public void user_enters_valid_mobile_number() {

	    loginPage.enterMobile(
	            BaseUtil.get("admin.mobile"));
	}

	@When("User enters valid password")
	public void user_enters_valid_password() {

	    loginPage.enterPassword(
	            BaseUtil.get("admin.password"));
	}

	@When("User enters valid captcha")
	public void user_enters_valid_captcha() {

	    loginPage.enterCaptcha();
	    
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		loginPage.loginButton();
		Thread.sleep(5000);
	    
	}

	@Then("User should be redirected to Dashboard")
	public void user_should_be_redirected_to_dashboard() {
		Assert.assertTrue(
	            DriverManager.getDriver()
	                    .getCurrentUrl()
	                    .contains("/dashboard"));

	    Assert.assertTrue(
	            loginPage.isDashboardDisplayed());
	}
	@When("User enters invalid password")
	public void user_enters_invalid_password() {

	    loginPage.enterPassword("wrong123");
	}

	@Then("User should see an invalid credentials error message")
	public void user_should_see_an_invalid_credentials_error_message() {

		 String actualMessage =
		            loginPage.getLoginFailedMessage();
		 
	 Assert.assertEquals(
		            actualMessage,
		            "Login Failed."
		    );
	}



}
