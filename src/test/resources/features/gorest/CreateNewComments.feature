Feature: Create new comments

  Scenario: Create new comments with valid data
    Given Create new comments with valid json "CNC001.json"
    When Send request post create new comments
    Then Status code should be 201
    And Validate json schema "CNC001Schema.json"

  Scenario Outline: Create new comments with invalid post_id
    Given Create new comments with invalid json "<json>"
    When Send request post create new comments
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "CNC002Schema.json"
    Examples:
        | json        | field | message    |
        | CNC002.json | post  | must exist |

  Scenario Outline: Create new comments with empty name
    Given Create new comments with invalid json "<json>"
    When Send request post create new comments
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "CNC003Schema.json"
    Examples:
          | json        | field | message        |
          | CNC003.json | name  | can't be blank |

  Scenario Outline: Create new comments with empty email
    Given Create new comments with invalid json "<json>"
    When Send request post create new comments
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "CNC004Schema.json"
    Examples:
            | json        | field | message                    |
            | CNC004.json | email | can't be blank, is invalid |

  Scenario Outline: Create new comments with empty body
    Given Create new comments with json "<json>"
    When Send request post create new comments
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "CNC005Schema.json"
    Examples:
      | json        | field | message        |
      | CNC005.json | body  | can't be blank |