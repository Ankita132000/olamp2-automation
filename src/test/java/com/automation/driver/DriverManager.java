package com.automation.driver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	 public static WebDriver driver;

	    public static void init() {

	        WebDriverManager.chromedriver().setup();

	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        options.addArguments("--remote-allow-origins=*");

	        driver = new ChromeDriver(options);

	        driver.get("https://olampstag.secuodsoft.com/");

	        // ✅ WAIT FOR PAGE LOAD
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(webDriver ->
	                ((JavascriptExecutor) webDriver)
	                        .executeScript("return document.readyState").equals("complete")
	        );
	    }

	    public static WebDriver getDriver() {
	        return driver;
	    }

	    public static void quit() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }

}
