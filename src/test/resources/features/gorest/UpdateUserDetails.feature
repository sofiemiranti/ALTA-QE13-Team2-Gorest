Feature: Update User Details

  Scenario: Update user details without id parameter
    Given Update user with json "UUD001.json" without id parameter
    When Send request update user
    Then Status code should be 404

  Scenario Outline: Update user details with valid data
    Given Update user with valid id <id> and json "<json>"
    When Send request put for update user
    Then Status code should be 200
    And Response body email was "<email>", name was "<name>", gender was "<gender>", and status was "<status>"
    And Validate json schema "UUD002Schema.json"
    Examples:
      | json        | id      | email               | name      | gender | status   |
      | UUD002.json | 5872371 | sofieedit@yahoo.com | sofieEdit | male   | inactive |

    Scenario Outline: Update user details with invalid email and gender
      Given Update user with valid id <id> and json "<json>"
      When Send request put for update user
      Then Status code should be 422
      And Response body field was "<field>" and message was "<message>"
      And Response body second field was "<field2>" and message was "<message2>"
      And Validate json schema "<jsonSchema>"
      Examples:
        | id      | json        | field  | message                               | field2 | message2   | jsonSchema        |
        | 5872371 | UUD003.json | gender | can't be blank, can be male of female | email  | is invalid | UUD003Schema.json |

      Scenario Outline: Update user details unregistered user id
        Given Update user with valid id <id> and json "<json>"
        When Send request put for update user
        Then Status code should be 404
        And Response body message was "Resource not found"
        And Validate json schema "<jsonSchema>"
        Examples:
          | id        | json        | jsonSchema        |
          | 587237167 | UUD004.json | UUD004Schema.json |

        Scenario Outline: Update user details with invalid path
          Given Update user with invalid path and id <id>
          When Send request put with invalid path
          Then Status code should be 404
          Examples:
            | id      |
            | 5872371 |

        Scenario Outline: Modify user details with valid gender and status
          Given Update user with valid id <id> and json "<json>"
          When Send request patch for modify user
          Then Status code should be 200
          And Response body gender was "<gender>" and status was "<status>"
          And Validate json schema "<jsonSchema>"
          Examples:
            | id      | json        | gender | status | jsonSchema        |
            | 5872371 | UUD006.json | female | active | UUD006Schema.json |

        Scenario Outline: Modify user details with invalid email
          Given Update user with valid id <id> and json "<json>"
          When Send request patch for modify user
          Then Status code should be 422
          And Response body field was "email" and message was "is invalid"
          And Validate json schema "<jsonSchema>"
          Examples:
            | id      | json        | jsonSchema        |
            | 5872371 | UUD007.json | UUD007Schema.json |


