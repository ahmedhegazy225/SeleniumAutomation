@smoke
Feature: Register | users could register with new accounts

  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When  user select gender type
    And user enter first name "Ahmed" and last name "Hegazy"
    And user enter date of birth
    And user enter email field
    And user fills Password fields "Heg@zy" "Heg@zy"
    And user clicks on register button
    Then success message is displayed


