Feature: Login Feature
  @Smoke
  Scenario Outline: Verify user can login with valid email and password
    Given user is at home page
    When user click on login tab
    And user enters his valid email "<email>"
    And user enters his valid PW "<password>"
    And user click on login button
    Then user is logged in
    Examples:
    |email| |password|
    |tets52@example.com||123456|

  Scenario Outline:user could login with invalid email and password
    Given user is at home page
    When user click on login tab
    And user enter invalid email "<email>"
    And user enter invalid password "<password>"
    And user click on login button
    Then user Cannot login to the system
    Examples:
      |email| |password|
      |invalid_tets@example.com||123456|


