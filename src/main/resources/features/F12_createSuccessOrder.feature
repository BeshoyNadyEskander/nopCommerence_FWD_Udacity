@smoke
Feature: F12 create success order| validate that create order successfully

# you should make register before run this feature
    Background: user go to loggin page
      Given user go to login page
      When user could enter valid email and valid password
      And user could press on login button

    Scenario Outline: : user could make  order by clicking on checkout
      Given user could go to field of search
      And user could search with valid product "<productName>"
      And user select products and click it
      When user could click on add cart shopping button
      And user navigate to shopping cart page to make order
      And user should agree with the terms of service before pressing checkout
      And user could press on checkout button to make order
      And user select his country
      And user should enter his city
      And user should enter his address
      And user should enter his postalCode
      And user could phone number
      And create successful order
      Then validate that create order is made successfully


      Examples:
        |productName|
        | macbook |
#        |   HTC One M8 Android L 5.0 Lollipop |
#        |    Flower Girl Bracelet             |


