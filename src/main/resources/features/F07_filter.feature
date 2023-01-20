@smoke
Feature: F07_filter feature | can filter products by color

    Scenario: user can filter products by using color in shoes subcategory
      Given user should hover Apparel category and click on shoes subcategory
      When user choose filter the products by color
      Then validate that the product is displayed relative the color which is choosen