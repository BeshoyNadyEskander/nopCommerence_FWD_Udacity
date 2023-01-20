@smoke
Feature: F09_Wishlist | user could add products in wishlist

  Scenario: user could add product to store in wishlist successfully and quantity is increased
    Given user could scroller down until gets the list of products
    When user could press on wishlist button where it exists below the product
    Then verify that the successful message appears after pressing on the button
    When user scroller up  wishlist where exist on Tab on the top of the page that ensure the message dissapear
    Then verify that the quantity of wishlist bigger than zero


