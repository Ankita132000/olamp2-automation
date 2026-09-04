package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automation.driver.DriverManager;

import co.automation.utils.CommonActions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserPage {
	By UserManagement = By.xpath("//a[normalize-space()='User Management']");
	By User = By.xpath("//a[@href='/user_management']");
	By AddNew = By.xpath("//button[contains(text(),'Add New')]");
	By Title = By.xpath("//select[@id='title']");
	By FirstName = By.xpath("//input[@id='first_name']");
	By MiddleName = By.xpath("//input[@id='middle_name']");
	By LastName = By.xpath("//input[@id='last_name']");
	By EmployeeType = By.xpath("//select[@id='employeetype']");
	By EmployeeOrganisationType = By.xpath("//select[@id='organisationtype']");
	By Position = By.xpath("//select[@id='designation']");
	By Designation = By.xpath("//select[@id='position']");
	By UserRole = By.xpath("//select[@id='userrole']");
	By EmployeeNumber = By.xpath("//input[@id='employee_number']");
	By PrimaryNumber = By.xpath("//input[@name='name' and @id='mobile']");
	By AlternativeNumber = By.xpath("//input[@id='alternative_mobile']");
	By Email = By.xpath("//input[@id='mail']");
	By FromDate = By.xpath("//input[@id='startdate']");
	By ToDate = By.xpath("//input[@id='enddate']");
	By Zone = By.xpath("//select[@id='addZone']");
	By Circle = By.xpath("//select[@id='addCircle']");
	By Division = By.xpath("//select[@id='addDivision']");
	By SubDivision = By.xpath("//select[@id='addSubDivision']");
	By Section= By.xpath("//select[@id='addJurisdiction']");
	By Save= By.xpath("//button[@id='adduser']");
	By AddUser= By.xpath("//button[contains(@class,'swal2-confirm') and contains(.,'Add Record')]");
			
	   public void AddUser () {
		CommonActions.click(UserManagement);
		CommonActions.click(User);
        CommonActions.click(AddNew);
	}

       public void UserDetails () {
		CommonActions.selectDropValue(Title, "Miss");
		CommonActions.clearAndType(FirstName, "Damayanti");
		CommonActions.clearAndType(MiddleName, "Kumar");
		CommonActions.clearAndType(LastName, "Sahu");
}
       public void EmployeeType() {
		CommonActions.selectDropValue(EmployeeType, "ET1");
       }
       public void EmpOrgType() {
		CommonActions.selectDropValue(EmployeeOrganisationType, "optcl");
       } 
       public void EmployeePosition() {
		CommonActions.selectDropdown(Position, "SDO");
		CommonActions.selectDropValue(Designation, "P1");
       }
       public void EmployeeMob() {
		CommonActions.clearAndType(EmployeeNumber, "User435");
		CommonActions.clearAndType(PrimaryNumber, "7897897895");
//		CommonActions.clearAndType(AlternativeNumber, "7897897896");
		CommonActions.clearAndType(Email, "ranjankumarsahu4@gmail.com");
       }
       public void Date() {
		CommonActions.setDateByJS(FromDate, "2026-06-30");
		CommonActions.setDateByJS(ToDate, "2030-06-30");
       }
       public void selectZone() {
    	    CommonActions.selectDropdown(Zone, "CENTRAL ZONE");
    	}

    	public void selectCircle() throws InterruptedException {
    	    CommonActions.selectDropdown(Circle, "EHT(O&M) CIRCLE,CUTTACK");
    	    Thread.sleep(3000);
    	    
    	    
    	}

    	public void selectDivision() throws InterruptedException {
    	    CommonActions.selectDropdown(Division, "EHT(O&M)DIVISION,PARADEEP");
    	    Thread.sleep(5000);    	}

    	public void selectSubDivision() throws InterruptedException {
    	    CommonActions.selectDropdown(SubDivision,
    	            "TL & SUBSTATION SUB-DIVISION,CHANDIKHOL(132/33 KV)");
    	    Thread.sleep(3000);
    	}

    	public void selectSection() {
    	    CommonActions.selectDropdown(Section, "CHANDIKHOL");
   
    	}

    	public void SaveUser() throws InterruptedException {

    	    WebElement save = DriverManager.getDriver().findElement(By.id("adduser"));


    	    ((JavascriptExecutor)DriverManager.getDriver())
    	            .executeScript("arguments[0].scrollIntoView(true);", save);

    	    Thread.sleep(1000);

    	    save.click();

    	     Thread.sleep(3000);
    	     
    	}
    	public void AddRecord() {

    	    WebDriverWait wait = new WebDriverWait(
    	            DriverManager.getDriver(),
    	            Duration.ofSeconds(20));

    	    // Click Add Record
    	    WebElement addRecord = wait.until(
    	            ExpectedConditions.elementToBeClickable(
    	                    By.xpath("//button[contains(@class,'swal2-confirm') and normalize-space()='Add Record']")));

    	    ((JavascriptExecutor) DriverManager.getDriver())
    	            .executeScript("arguments[0].click();", addRecord);

    	    System.out.println("Clicked Add Record");

    	    // Wait until the Add Record button disappears
    	    wait.until(ExpectedConditions.invisibilityOf(addRecord));

    	    // Wait for the OK button of the success popup
    	    WebElement ok = wait.until(
    	            ExpectedConditions.elementToBeClickable(
    	                    By.xpath("//button[contains(@class,'swal2-confirm') and normalize-space()='OK']")));

    	    ok.click();

    	    System.out.println("Clicked OK");
    	}
	
		
		
		
}
			
			


