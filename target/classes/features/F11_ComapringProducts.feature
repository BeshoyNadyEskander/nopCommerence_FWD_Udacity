@smoke
Feature: F11_comparing products | users can compare between products and other successfully

    Scenario: user could select different products and do comparing between them
    Given user selects random category from main category
      And user could scroller down until getting the list of products
      When user could choose product from products and hover on product
      And user could click on comparing products button
      And user selects random category from main category
      And user could scroller down until getting the list of products
      And user could choose product from products and hover on product
      And user could click on comparing products button
      And user selects random category from main category
      And user could scroller down until getting the list of products
      And user could choose product from products and hover on product
      And user could click on comparing products button
      Then validate that the products are selected to compare storing inside list of comapring

