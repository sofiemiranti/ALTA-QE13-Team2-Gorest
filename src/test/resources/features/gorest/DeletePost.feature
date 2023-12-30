Feature: Delete posts
  Scenario Outline: Delete post with valid id
    Given Delete post with valid <id>
    When Send request delete posts
    Then Status code should be 204
    Examples:
      | id    |
      | 91100 |

  Scenario Outline: Delete post with non exist id
    Given Delete post with non exist <id>
    When Send request delete posts
    Then Status code should be 404
    And Response body message was "<message>"
    And Validate json schema "DEP001Schema.json"
    Examples:
      | id    | message            |
      | 10000 | Resource not found |

  Scenario Outline: Delete post with invalid id
    Given Delete post with invalid "<id>"
    When Send request delete posts
    Then Status code should be 404
    And Response body message was "<message>"
    And Validate json schema "DEP002Schema.json"
    Examples:
      | id | message            |
      | aaaaa  | Resource not found |