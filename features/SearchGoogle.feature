Feature: Google search

  Scenario: Verify user is able to perform search on google
  Given I navigate to google
  When I enter a keyword
  Then I click search
