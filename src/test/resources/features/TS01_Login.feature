Feature: TS01 User Login

  As a user
  I want to log in to the system
  So that i can access my account securely

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the Inventory Page
