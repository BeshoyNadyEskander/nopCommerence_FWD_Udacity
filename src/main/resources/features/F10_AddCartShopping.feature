@smoke
Feature: F10_Add cartShop Feature | add products inside cart shopping successfully

   Scenario Outline: user could add products inside cart shopping
     When user could go to field of search
     And user could search with valid product "<productName>"
      And user select products and click it
     And user could click on add cart shopping button
     Then validate that the message of adding product is displayed
     And  verify that the quantity of cart shopping bigger than zero

     Examples:
       |productName|
      | macbook |
     |   HTC One M8 Android L 5.0 Lollipop |
    | Flower Girl Bracelet             |

