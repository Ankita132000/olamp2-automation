Feature: O-LAMP Login Functionality

  Background:
    Given User launches the O-LAMP application

  @Positive
  Scenario: Successful login with valid credentials
    When User enters valid mobile number
    And User enters valid password
    And User enters valid captcha
    And User clicks on Login button
    Then User should be redirected to Dashboard
    
    @Negative
  Scenario: Login with invalid password
    When User enters valid mobile number
    And User enters invalid password
    And User enters valid captcha
    And User clicks on Login button
    Then User should see an invalid credentials error message
    

 