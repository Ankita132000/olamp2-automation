package co.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.driver.DriverManager;

public class CommonActions {
	public static void click(By locator) {
	    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

	    try {
	        element.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) DriverManager.getDriver())
	            .executeScript("arguments[0].click();", element);
	    }
	}

    public static void type(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }
    
    public static void clearAndType(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public static void selectDropdown(By dropdown, String value) {

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(30));

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(dropdown));

        wait.until(driver -> {

            Select select = new Select(element);

            for (WebElement option : select.getOptions()) {

                String optionText = option.getText()
                        .trim()
                        .replaceAll("\\s+", " ");

                String expectedText = value
                        .trim()
                        .replaceAll("\\s+", " ");

                if (optionText.equalsIgnoreCase(expectedText)) {
                    return true;
                }
            }

            return false;
        });

        Select select = new Select(element);

        for (WebElement option : select.getOptions()) {

            String optionText = option.getText()
                    .trim()
                    .replaceAll("\\s+", " ");

            String expectedText = value
                    .trim()
                    .replaceAll("\\s+", " ");

            if (optionText.equalsIgnoreCase(expectedText)) {
                select.selectByVisibleText(option.getText());
                return;
            }
        }

        throw new RuntimeException(
                "Dropdown option not found: " + value);
    }
    
    public static void selectDropValue(By dropdown, String value) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdown));

        Select select = new Select(element);

        // ✅ WAIT until options are loaded
        wait.until(driver -> select.getOptions().size() > 1);

        select.selectByValue(value);
    }
    
    public static void selectCustomDropdown(By dropdown, String value) {

    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));

        // Step 1: Click dropdown
        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dd.click();

        // Step 2: Wait for dropdown container (Select2 renders globally)
        By resultsContainer = By.xpath("//ul[contains(@class,'select2-results__options')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsContainer));

        // Step 3: Type in search box (if present)
        try {
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[contains(@class,'select2-search__field')]")));
            searchBox.clear();
            searchBox.sendKeys(value);
        } catch (Exception e) {
            // no search box, ignore
        }

        // Step 4: Select correct option (VERY IMPORTANT FIX)
        By option = By.xpath(
            "(//ul[contains(@class,'select2-results__options')])[last()]//li[contains(@class,'select2-results__option') and normalize-space()='" + value + "']"
        );

        WebElement opt = wait.until(ExpectedConditions.elementToBeClickable(option));
        opt.click();
    }
    
    public static void clickwait(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public static void scrollHorizontal(By locator) {

        WebElement element = DriverManager.getDriver().findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element);
    }
    public static void setDateByJS(By locator, String dateValue) {
        WebElement element = DriverManager.getDriver().findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value='" + dateValue + "'", element);
    } 
    public static void selectSelect2Dropdown(By dropdown, String value) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        // 1. Click dropdown
        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
        dd.click();

        // 2. Type in search box
        By searchBox = By.xpath("//input[contains(@class,'select2-search__field')]");
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        input.sendKeys(value);

        // 3. Select option
        By option = By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'" + value + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

}
