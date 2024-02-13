@Smoke
Feature: Search Feature

  Scenario Outline: user could search using product name

    Given user is at home page
    When user enters product name "<name>" in search box
    And user click on search button
    Then search contains relevant results "<name>"
    Examples:
    |name|
    | book   |
    | laptop |
    | nike   |

  Scenario Outline: user could search using product SKU

    Given user is at home page
    When user enters product sku "<sku>" in search box
    And user click on search button

    Then product details contain relevant results "<sku>"
    Examples:
      |     sku     |
      |  SCI_FAITH  |
      |  APPLE_CAM  |
      |  SF_PRO_11  |
