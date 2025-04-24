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
    And user add product to cart
    Then product is added to cart
    And "ADD TO CART" button is changed to "REMOVE"

  Scenario: User want to remove product from cart
    Given user already logged in successfully
    And user add product to cart
    When user remove product from cart
    Then product is removed from cart
    And "REMOVE" button is changed to "ADD TO CART"
