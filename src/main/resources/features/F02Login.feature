@smoke
Feature: Login | users could use login functionality to use their accounts

  Background:
  Given user go to login page

  Scenario: user could login with valid email and password
  When user login with "megadiab84@gmail.com" and "Heg@zy"
  And user press on login button
  Then user login to the system successfully

  Scenario: user could login with invalid email and password
  When  user login with "megadiab8444@gmail.com" and "Heg@zy"
  And user press on login button
  Then user could not login to the system