Feature: Get Single Post
  Scenario Outline: Get single post with valid id
    Given Get single post with valid <id>
    When Send request get single post
    Then Status code should be 200
    And Response body id was <id>
    And Validate json schema "GSP001Schema.json"
    Examples:
      | id    |
      | 91476 |

  Scenario Outline: Get single post with id using character
    Given Get single post with "<id>" using character
    When Send request get single post
    Then Status code should be 404
    And Response body message was "<message>"
    And Validate json schema "GSP002Schema.json"
    Examples:
      | id | message            |
      | a  | Resource not found |
      | b  | Resource not found |

  Scenario Outline: Get single post with id using special character
    Given Get single post with "<id>" using special character
    When Send request get single post
    Then Status code should be 404
    And Response body message was "<message>"
    And Validate json schema "GSP003Schema.json"
    Examples:
      | id | message            |
      | @  | Resource not found |
      | #  | Resource not found |

  Scenario Outline: Get single post with non exist id
    Given Get single post with non exist <id>
    When Send request get single post
    Then Status code should be 404
    And Response body message was "<message>"
    And Validate json schema "GSP004Schema.json"
    Examples:
      | id | message            |
      | 1  | Resource not found |
      | 2  | Resource not found |