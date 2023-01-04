@smoke
Feature: FollowUs | users could open followUs links
  Scenario: users click on facebook link
    Given user click on "facebook" link
    When  user opens new tab
    And   user can switch between tabs
    Then  "https://www.facebook.com/nopCommerce" is opened in new tab


  Scenario: users click on twitter link
    Given user click on "twitter" link
    When  user opens new tab
    And   user can switch between tabs
    Then  "https://twitter.com/nopCommerce" is opened in new tab


  Scenario: users click on rss link
    Given user click on "rss" link
    When  user opens new tab
    And   user can switch between tabs
    Then  "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab


  Scenario: users click on youtube link
    Given user click on "youtube" link
    When  user opens new tab
    And   user can switch between tabs
    Then  "https://www.youtube.com/user/nopCommerce" is opened in new tab