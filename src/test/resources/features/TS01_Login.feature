Feature: TS01 User Login

  As a user
  I want to log in to the system
  So that i can access my account securely

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username "standard_user" and password "secret_sauce"
    And clicks the login button
    Then the user should be redirected to the Inventory Page

  Scenario Outline: Failed login with invalid credentials
    Given the user is on the login page
    When the user enters invalid username "<username>" and password "<password>"
    And clicks the login button
    Then the error message "<message>" should be displayed

    Examples:
    | username | password | message |
    | random   | ugtfdjek | Username and password do not match any user in this service |
    |          | fhbyduji | Username is required                                        |
    | random   |          | Password is required                                        |
    |          |          | Username is required                                        |
    | locked_out_user | secret_sauce | Sorry, this user has been locked out.            |
