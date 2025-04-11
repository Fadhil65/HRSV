@Login
Feature: Login
  As a user, I want to login

  @LGI001
  Scenario: LGI001 - User want to login with invalid password
    Given The User go to login page
    Then User input valid username
    And User input invalid password
    When User click button login
    Then Notification appear

  @LGI002
  Scenario: LGI002 - User want to login with valid credential
    Given The User input valid password
    When User click button login
    Then Username appear

  
  @LGI003
  Scenario: LGI003 - User want to login 2 attempt
  Given The User go to login page
  When User performs two login attempts
  
  