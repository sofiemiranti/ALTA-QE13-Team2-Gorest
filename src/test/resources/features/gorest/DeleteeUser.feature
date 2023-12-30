Feature: Delete User

  Scenario Outline: Delete user with valid user id
    Given Delete user with id <id>
    When Send request delete user with id
    Then Status code should be 204
    Examples:
      | id      |
      | 5850574 |

  Scenario Outline: Delete user with unregistered user id
    Given Delete user with id <id>
    When Send request delete user with id
    Then Status code should be 404
    And Response body message was "Resource not found"
    And Validate json schema "<jsonSchema>"
    Examples:
      | id     | jsonSchema    |
      | 100000 | DEU003Schema.json |

  Scenario Outline: Delete user with invalid path
    Given Delete user with id <id> and invalid path
    When Send request delete user with invalid path
    Then Status code should be 404
    Examples:
      | id |
      | 10000  |