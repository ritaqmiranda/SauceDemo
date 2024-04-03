Feature: Product Checkout

  Scenario: I can buy a product and checkout
    Given I open the web page
    When I login as a "standard" user
    And I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Onesie" to the cart
    And I click on the cart
    And I checkout
    And I enter my information to continue
      | firstName | lastName | zipCode  |
      | John      | Doe      | 37188 |
    Then I confirm my order