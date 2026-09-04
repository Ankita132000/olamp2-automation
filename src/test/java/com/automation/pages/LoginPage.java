package com.automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.automation.driver.DriverManager;

import co.automation.utils.CommonActions;


public class LoginPage {

    By mobile = By.xpath("//input[@name='phone']");
    By password = By.xpath("//input[@name='password']");
    By captchaInput = By.xpath("//input[@id='userInput']");
    By captchaText = By.id("captcha");
    By LoginButton = By.xpath("//button[text()='Login']");
    By dashboardText = By.xpath("//li[contains(text(),'Dashboard')]");
    
    By loginFailedMsg = By.xpath("//div[contains(@class,'toast-message')]");

    public void enterMobile(String user) {
        CommonActions.type(mobile, user);
    }

    public void enterPassword(String pass) {
        CommonActions.type(password, pass);
    }

    public void enterCaptcha() {

        WebElement captcha =
                DriverManager.getDriver().findElement(captchaText);

        String captchaValue = captcha.getText();

        System.out.println("Captcha : " + captchaValue);

        CommonActions.type(captchaInput, captchaValue);
    }
    public void loginButton() {
    	CommonActions.click(LoginButton);
    }
    public boolean isDashboardDisplayed() {

        return DriverManager.getDriver()
                .findElement(dashboardText)
                .isDisplayed();
    }
    public String getLoginFailedMessage() {

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(3));

        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".toast-message")))
                .getText();
    }
}