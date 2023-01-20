@smoke
Feature: F08_tags feature| ensure that popular tags work correctly

 Scenario: user can search on products by using tags
   Given user selects random category from main category
   And user should scroll down to get list of tags
   When user selects random tags
   Then validate that tag is displayed relative products