@smoke
Feature: hover on one of main categories then click on sub category
  Scenario: user will select randomly from three main category
    Given select one of three main category
    And User can select on of sub category if exist
    Then sub-category title equals the one you get it while selecting random sub-category