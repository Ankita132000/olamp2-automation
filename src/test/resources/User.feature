Feature: Add User Functionality

  Background:
    When User enters valid mobile number
    And User enters valid password
    And User enters valid captcha
    And User clicks on Login button
    Then User should be redirected to Dashboard
    

  @Positive
  Scenario: Add user with valid details
  And User navigates to User Management
    And User clicks on User menu
    And User clicks on Add New button
    When User selects Title 
    And User enters First Name 
    And User enters Middle Name 
    And User enters Last Name 
    And User selects Employee Type 
    And User selects Employee Organisation Type 
    And User selects Position
    And User selects Designation 
    And User enters Employee Number 
    And User enters Primary Mobile Number 
    And User enters Alternative Mobile Number 
    And User selects From Date 
    And User selects To Date 
    And User selects Zone 
    And User selects Circle 
    And User selects Division 
    And User selects Sub Division 
    And User selects Section 
    And User clicks Save button
    Then User should be added successfully