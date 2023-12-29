Feature: Create New User

  Scenario: Create new user with valid name, email, gender, and status
    Given Create new user with json "CreateNewUserValid.json"
    When Send request post create new user
    Then Status code should be 201
    And Validate json schema "CreateNewUserValidSchema.json"

