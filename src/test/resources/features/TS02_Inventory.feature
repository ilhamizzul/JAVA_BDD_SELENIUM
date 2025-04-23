Feature: TS02 Inventory

  As a user
  I want to interact with available product
  So that i can know better about the product available to buy

  Scenario: Verify Inventory page is loaded
    Given user already logged in successfully
    Then inventory page is fully loaded

  Scenario: User want to add product to cart
    Given user already logged in successfully
    When user add product to cart
    Then product is added to cart
#    And product is added to cart
    And "ADD TO CART" button is changed to "REMOVE"
