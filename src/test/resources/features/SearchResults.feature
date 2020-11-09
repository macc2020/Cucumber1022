Feature: Search functionality on the users page


@ColumnNames
Scenario: Table columns names
Given I am on the login page
And Login as a Librarian
And I click on the "users" link
Then table should have following column names:
| Actions   |
| User ID   |
| Full Name |
| Email     |
| Group     |
| Status    |
