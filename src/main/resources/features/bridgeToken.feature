Feature: Demo

  Scenario: Validate the Bridge Token Card Present on the home screen
    Given You are on the login screen
    Then Enter username as "jewelautomation"
    And Enter Password as 'dummy_test@123'
    Then Verify if the Bridge token card is visible

  Scenario: Validate the content of Bridge Token Card
    Given You are on the login screen
    Then Enter username as "jewelautomation"
    And Enter Password as 'dummy_test@123'
    Then Validate the content of the Bridge Token card

  Scenario: Check if the change token button is clickable or not
    Given You are on the login screen
    Then Enter username as "jewelautomation"
    And Enter Password as 'dummy_test@123'
    Then Validate if there is change token button available ,if so click it

  Scenario: Verify The Bridge Token screen is opening or not
    Given You are on the login screen
    Then Enter username as "jewelautomation"
    And Enter Password as 'dummy_test@123'
    Then Verify the Bridge Token Button is clickable or not

  Scenario: Copy Bridge Token
    Given You are on the login screen
    Then Enter username as "jewelautomation"
    And Enter Password as 'dummy_test@123'
    Then Click on Copy Bridge Token

  Scenario: Alert validation for Change Token
    Given You are on the login screen
    Then Enter username as "jewelautomation"
    And Enter Password as 'dummy_test@123'
    Then Verify the Alert when Change Token button is clicked

  Scenario: Check the alert and time of Change Token button
    Given You are on the login screen
    Then Enter username as "jewelautomation"
    And Enter Password as 'dummy_test@123'
    Then Verify the date and time when Change Token button is clicked

  Scenario: Verify Logout Button
    Given Navigate to login-screen
    When Enter credentials for login
    And Click login
    Then Verify Logout button visibility
    And Click and verify Logout button

  Scenario: Validate not a user button
    Given Navigate to login-screen
    Then Click not a user button and validate navigation to signup screen

  Scenario: Login to Jewel (Positive)
    Given Navigate to login-screen
    When Enter credentials for login
    And Click login
    Then Validate login is successful