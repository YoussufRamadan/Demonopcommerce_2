Feature: Currencies Feature
@Smoke
  Scenario: verify that all products prices are in same currency as chosen
    Given user is at home page
    When user choose currency to "Euro"
    And user slide down in page
    Then all four products prices must contain € sign
