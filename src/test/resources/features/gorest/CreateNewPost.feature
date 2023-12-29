Feature: Create new post
  @Posts
  Scenario Outline: Create new post with valid data
    Given Create new post with valid "<json>"
    When Send request post create new post
    Then Status code should be 201
    And Response body title was "<title>" and body was "<body>"
    And Validate json schema "CNP001Schema.json"
    Examples:
      | json        | title | body             |
      | CNP001.json | Demo  | Ini adalah body. |

  @Posts
  Scenario Outline: Create new post with invalid user id
    Given Create new post with invalid "<json>"
    When Send request post create new post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "CNP002Schema.json"
    Examples:
      | json        | field | message    |
      | CNP002.json | user  | must exist |

  @Posts
  Scenario Outline: Create new post with empty title
    Given Create new post with empty title "<json>"
    When Send request post create new post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "CNP003Schema.json"
    Examples:
      | json        | field | message        |
      | CNP003.json | title | can't be blank |

  @Posts
  Scenario Outline: Create new post with empty body
    Given Create new post with empty body "<json>"
    When Send request post create new post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "CNP004Schema.json"
    Examples:
      | json        | field | message        |
      | CNP004.json | body  | can't be blank |

  @Posts
  Scenario Outline: Create new post with user id using character
    Given Create new post with user id using character "<json>"
    When Send request post create new post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Response body second field was "<field2>" and message was "<message2>"
    And Validate json schema "CNP005Schema.json"
    Examples:
      | json        | field | message    | field2  | message2        |
      | CNP005.json | user  | must exist | user_id | is not a number |