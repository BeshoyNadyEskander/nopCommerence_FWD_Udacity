@smoke
Feature: F04_ search feature | validate that search works exactly

    Background: user go to loggin page
      Given user go to login page
      When user could enter valid email and valid password
      And user could press on login button

    Scenario Outline: user could search on any product
      When user could go to field of search
      And user could search with valid product "<productName>"
      Then verify that the user could find a product relative for result "<productName>"
      Examples:
        |productName|
        | macbook |
#        | Laptop  |
#        | Android |

    Scenario Outline: user could search for product with sku
      When user could search with valid sku "<serialNumber>"
      Then click on picture of product to navigate details for product
      And verify that user could find product relative for sku of result "<serialNumber>"
      And verify that main sku relative for sku for searching product "<serialNumber>"
      Examples:
         |  serialNumber      |
         |       SCI_FAITH             |
#         |                APPLE_CAM    |
#         |                SF_PRO_11    |
