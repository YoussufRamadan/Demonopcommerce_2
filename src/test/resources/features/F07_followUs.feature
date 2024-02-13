@Smoke
Feature: Follow us Feature

  Scenario: verify user can open facebook link
    Given user is at home page
    When user opens facebook link
    Then "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: Verify user can open twitter link
    When user opens twitter link
    Then "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: Verify user can open youtube link
  When user opens youtube link
  Then "https://www.youtube.com/user/nopCommerce" is opened in new tab

  Scenario: Verify user can open rss link
  When user opens rss link
  Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab
