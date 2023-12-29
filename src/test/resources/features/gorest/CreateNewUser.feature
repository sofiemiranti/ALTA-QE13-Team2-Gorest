Feature: Create New User

#  @Users
#  Scenario: Create new user with valid name, email, gender, and status
#    Given Create new user with json "CreateNewUserValid.json"
#    When Send request post create new user
#    Then Status code should be 201
#    And Validate json schema "CreateNewUserValidSchema.json"

  @Users
  Scenario: Create new user with email has been registered before
    Given Create new user with json "CNUEmailAlreadyTaken.json"
    When Send request post create new user
    Then Status code should be 422
    And Response body field was "email" and message was "has already been taken"
    And Validate json schema "CNUEmailAlreadyTakenSchema.json"

  @Users
  Scenario: Create new user with invalid email
    Given Create new user with json "CNUInvalidEmail.json"
    When Send request post create new user
    Then Status code should be 422
    And Response body field was "email" and message was "is invalid"
    And Validate json schema "CNUInvalidEmailSchema.json"

#  @Users
#  Scenario: Create new user with invalid name
#    Given Create new user with json "CNUInvalidName.json"
#    When Send request post create new user
#    Then Status code should be 422
#    And Response body field was "name" and message was "is invalid"

  @Users
  Scenario: Create new user with invalid status
    Given Create new user with json "CNUInvalidStatus.json"
    When Send request post create new user
    Then Status code should be 422
    And Response body field was "status" and message was "can't be blank"
    And Validate json schema "CNUInvalidStatusSchema.json"

   @Users
   Scenario: Create new user with blank name
     Given Create new user with json "CNUBlankName.json"
     When Send request post create new user
     Then Status code should be 422
     And Response body field was "name" and message was "can't be blank"
     And Validate json schema "CNUBlankNameSchema.json"

   @Users
   Scenario: Create new user with invalid gender and status
     Given Create new user with json "CNUInvalidGenderStatus.json"
     When Send request post create new user
     Then Status code should be 422
     And Response body field was "gender" and message was "can't be blank, can be male of female"
     And Response body second field was "status" and message was "can't be blank"
     And Validate json schema "CNUInvalidGenderStatusSchema.json"


