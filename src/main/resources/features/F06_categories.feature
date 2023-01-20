@smoke
Feature: F06 categories feature | choose main category and sub category if found successfully

  Scenario: user could choose random main category and sub category if found

    When user selects random category from main category
    Then verify that page of category is displayed
    And verify that the title of category belongs to the title of random category