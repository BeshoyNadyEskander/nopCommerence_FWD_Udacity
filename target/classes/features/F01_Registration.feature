@smoke
Feature: F01_Registration | user can register a new account

    Scenario: user could register with valid data successfully
      Given user should go to registration page
      Then validate that user could navigate register page successfully
      When user could select on gender type
      When user could enter valid firstname "beshoy" and lastname "nady"
      When user could enter date of birth
      When user could enter valid Email
      When user may enter name of company "Egal's company"
      When user could enter valid password
      When user colud enter valid confirmation password
      When user could press on register button
      Then validate that user could register a new account successfully




