Feature: home slider
  @smoke
  Scenario Outline: verify when user Click on home slider it opens corresponding page
    Given user is at home page
    When click on home "<slider>"
    Then the iphone or galaxy page opens
    Examples:
    |slider|
    |   galaxy   |
    |  iphone    |

