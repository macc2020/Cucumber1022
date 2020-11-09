Feature: Login with parameters
  @LibrarianParam
  Scenario: Login as a librarian1
    Given I am on the login page
    When I enter username "librarian11@library"
    And I enter password 'I61FFPPf'
    And Click the sign in button
    And there should be 1449 users
    Then dashboard should be displayed

    @Librarian12
  Scenario: Login as Librarian12
    Given I am on the login page
    When I enter username "librarian12@library"
    And I enter password 'AOYKYTMJ'
    And Click the sign in button
    And there should be 1449 users
    Then dashboard should be displayed



  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian12@library"and "AOYKYTMJ"
    And there should be 1449 users
    Then dashboard should be displayed


