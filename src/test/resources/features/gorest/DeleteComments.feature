Feature: Delete User

  Scenario: Delete comments without id
    Given Delete comments without id
    When Send request delete comments
    Then Status code should be 404

    Scenario Outline: Delete comments with valid id
      Given Delete comments with id "<id>"
      When Send request delete comments with id
      Then Status code should be 204
      Examples:
        | id    |
        | 74060 |

     Scenario Outline: Delete comments with unregistered id
       Given Delete comments with unregistered id "<id>"
       When Send request delete comments with id
       Then Status code should be 404
       Examples:
         | id    |
         | 88888 |