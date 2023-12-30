Feature: Get comments details

  Scenario: Get comments details with valid id
    Given Get comments details with valid id 74011
    When Send request get comments details with valid id
    Then Status code should be 200
    And Validate json schema "GCD002Schema.json"

  Scenario Outline: Get comments detail with invalid id
    Given Get comments details with invalid id "<id>"
    When Send request get comments details with invalid id
    Then Status code should be 404
    And Response body message was "<message>"
    And Validate json schema "GCD003Schema.json"
    Examples:
        | id    | message            |
        | 12345 | Resource not found |

  Scenario Outline: Get comments detail with alphabet id
    Given Get comments details with alphabet id "<id>"
    When Send request get comments details with alphabet id
    Then Status code should be 404
    And Response body message was "<message>"
    And Validate json schema "GCD004Schema.json"
    Examples:
      | id    | message            |
      | abcde | Resource not found |

  Scenario Outline: Get comments detail with special character id
    Given Get comments details with special character id "<id>"
    When Send request get comments details with special character id
    Then Status code should be 404
    And Response body message was "<message>"
    And Validate json schema "GCD005Schema.json"
    Examples:
      | id     | message            |
      | /@#$%^ | Resource not found |

  Scenario: Get comments detail with valid name parameter
    Given Get comments details with valid parameter name is "Rohit"
    When Send request get comments details with name parameter
    Then Status code should be 200
    And Validate json schema "GCD006Schema.json"

  Scenario: Get comments detail with invalid name parameter
    Given Get comments details with parameter name is "Tohir"
    When Send request get comments details
    Then Status code should be 200
    And Validate json schema "GCD007Schema.json"

  Scenario: Get comments details with invalid parameter
    Given Get commants with invalid parameter is "invalid_parameter"
    When Send request get comments details with invalid parameter
    Then Status code should be 404