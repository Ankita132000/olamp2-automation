package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.pages.UserPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UserSteps {

	LoginPage loginPage = new LoginPage();
	UserPage userPage = new UserPage(); 
	
	@Given("User is logged into O-LAMP application")
	public void user_is_logged_into_o_lamp_application() {
	    
	}

	@Given("User navigates to User Management")
	public void user_navigates_to_user_management() {
	    userPage.AddUser();
	}

	@Given("User clicks on User menu")
	public void user_clicks_on_user_menu() {
	    
	}

	@Given("User clicks on Add New button")
	public void user_clicks_on_add_new_button() {
	   
	}

	@When("User selects Title")
	public void user_selects_title() {
	    userPage.UserDetails();
	}

	@When("User enters First Name")
	public void user_enters_first_name() {
	    
	}

	@When("User enters Middle Name")
	public void user_enters_middle_name() {
	   
	}

	@When("User enters Last Name")
	public void user_enters_last_name() {
	    
	}

	@When("User selects Employee Type")
	public void user_selects_employee_type() {
		userPage.EmployeeType();
	   
	}

	@When("User selects Employee Organisation Type")
	public void user_selects_employee_organisation_type() {
		userPage.EmpOrgType();
	   
	}

	@When("User selects Position")
	public void user_selects_position() {
	    userPage.EmployeePosition();
	    
	}

	@When("User selects Designation")
	public void user_selects_designation() {
	    
	}

	@When("User enters Employee Number")
	public void user_enters_employee_number() {
	    userPage.EmployeeMob();
	}

	@When("User enters Primary Mobile Number")
	public void user_enters_primary_mobile_number() {
	    
	}

	@When("User enters Alternative Mobile Number")
	public void user_enters_alternative_mobile_number() {
	    
	}

	@When("User selects From Date")
	public void user_selects_from_date() {
	    userPage.Date();
	}

	@When("User selects To Date")
	public void user_selects_to_date() {
	  
	}

	@When("User selects Zone")
	public void user_selects_zone() {
	    userPage.selectZone();
	}

	@When("User selects Circle")
	public void user_selects_circle() throws InterruptedException {
	    userPage.selectCircle();
	}

	@When("User selects Division")
	public void user_selects_division() throws InterruptedException {
	    userPage.selectDivision();
	}

	@When("User selects Sub Division")
	public void user_selects_sub_division() throws InterruptedException {
	    userPage.selectSubDivision();
	}

	@When("User selects Section")
	public void user_selects_section() {
	    userPage.selectSection();
	    
	}

	@When("User clicks Save button")
	public void user_clicks_save_button() throws InterruptedException {
		userPage.SaveUser();
		userPage.AddRecord();
	}
	@Then("User should be added successfully")
	public void user_should_be_added_successfully() {
	    
	}


}
