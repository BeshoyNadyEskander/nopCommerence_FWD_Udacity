@smoke
Feature: F02_login page | user should login page with his valid email and password

     Scenario: user could login successfully with valid data
       Given user go to login page
       When user could enter valid email and valid password
       And user could press on login button
       Then validate that user navigate home page successfully


