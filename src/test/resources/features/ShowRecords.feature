
Feature: Show records functionality

Scenario: verify default values in users page When I click on "users" link
Given I am on the login page
  And Login as a Librarian
  When I click on the "users" link
Then show records default value should be 10
  And show records should have following options:
  | 5  |
  | 10 |
  | 15 |
  | 50 |
  | 100 |
  | 200 |
  | 500 |
