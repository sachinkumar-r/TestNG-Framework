
@tag
Feature: Purchase the Order from Ecommerce application.
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce page.

  @tag2
  Scenario Outline: Positive test for submitting the order.
    Given Logged in with username <name> and password <password>
    When I add <productName> to the cart.
    And Checkout <productName> and submit the order
    Then "THANK YOU FOR THE ORDER." message is displayed on confirmation page.

    Examples: 
      | name  									 | password   | productName |
      | testautomation@yahoo.com |   Test@123 | ZARA COAT 3 |
      
