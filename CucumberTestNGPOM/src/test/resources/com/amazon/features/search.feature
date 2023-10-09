Feature: Search on Amazon

  Scenario: User searches for a valid product
    Given User is on the Amazon homepage
    When User enters "American Tourister Spin 49 cms Teal Laptop Backpack" in the search bar
    And User clicks the search button
    Then User should see expected product is displayed

  Scenario: User searches for an invalid product
    Given User is on the Amazon homepage
    When User enters "xgb8@qnz0Ppliadsxyty765dfhg" in the search bar
    And User clicks the search button
    Then User should see error message indicating try to check again

  Scenario: User searches with an empty query
    Given User is on the Amazon homepage
    When User leaves the search bar empty
    And User clicks the search button
    Then User should see that page gets refreshed and user have to provide search query

  Scenario: User tests auto-suggestions for a word
    Given User is on the Amazon homepage
    When User starts typing "Headphones" in the search bar
    Then User should see auto-suggestions related to "Headphones"
