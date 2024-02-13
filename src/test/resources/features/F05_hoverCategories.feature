Feature: hoverCategories Feature
  Scenario: verify hover on main category and click on sub category
    Given user is at home page
    When user hover on categories
    And user click on random sub category
    Then user is at sub category page
