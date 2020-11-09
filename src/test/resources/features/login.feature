

  Feature: Login feature



    @Librarian
    Scenario: Login as a Librarian
      Given I am on the login page
      When I login as a Librarian
      Then dashboard should be displayed
      @student
      Scenario: Login as a student
        Given I am on the login page
        When I login as a student
        Then books should be displayed
