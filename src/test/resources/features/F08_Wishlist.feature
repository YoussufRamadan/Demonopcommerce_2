@Smoke
Feature: Wishlist
  Scenario: user can add an item to wishlist
    When user click on wishlist button for a product
    Then success message "The product has been added to your wishlist" should must appear
    And the background of message is green (#4bb07a)

  Scenario: user find the product he added when opens wishlist tab
    When  user click on wishlist button for a product
    And user opens wishlist tab
    Then then wishlist quanitiy value should be greater than zero
