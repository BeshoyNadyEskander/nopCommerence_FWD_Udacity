@smoke
Feature: F03_recovery password | user could recover his password successfully by valid email

Scenario: user could recover his password by email
Given user should press on forget your password
When user enter his valid email
When user click on recover button
Then validate that the message of recovery is displayed