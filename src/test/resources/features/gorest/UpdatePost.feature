Feature: Update Post
  Scenario Outline: Update post with valid id and data
    Given Update post with valid <id> and "<json>"
    When Send request put update post
    Then Status code should be 200
    And Response body id was <id>
    And Validate json schema "PUP001Schema.json"
    Examples:
      | id    | json        |
      | 91383 | PUP001.json |

  Scenario Outline: Update post with id and invalid user_id
    Given Update post with <id> and invalid "<json>"
    When Send request put update post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "PUP002Schema.json"
    Examples:
      | id    | field | message    | json        |
      | 91420 | user  | must exist | PUP002.json |

  Scenario Outline: Update post with id and user id using character
    Given Update post with <id> and "<json>" using character
    When Send request put update post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "PUP003Schema.json"
    Examples:
      | id    | field | message    | json        |
      | 91420 | user  | must exist | PUP003.json |

  Scenario Outline: Update post with id and user id using special character
    Given Update post with <id> and "<json>" using special character
    When Send request put update post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "PUP004Schema.json"
    Examples:
      | id    | field | message    | json        |
      | 91420 | user  | must exist | PUP004.json |

  Scenario Outline: Update post with non exist id
    Given Update post with non exist <id>
    When Send request put update post
    Then Status code should be 404
    And Response body message was "<message>"
    Examples:
      | id    | message            |
      | 10000 | Resource not found |

  Scenario Outline: Modify post with id and valid title
    Given Modify post with <id> and valid title "<json>"
    When Send request patch modify post
    Then Status code should be 200
    And Response body id was <id>
    And Validate json schema "PUP005Schema.json"
    Examples:
      | id    | json        |
      | 91383 | PUP005.json |

  Scenario Outline: Modify post with id and valid body
    Given Modify post with <id> and valid body "<json>"
    When Send request patch modify post
    Then Status code should be 200
    And Response body id was <id>
    And Validate json schema "PUP006Schema.json"
    Examples:
      | id    | json        |
      | 91383 | PUP006.json |

  Scenario Outline: Modify post with id and empty title
    Given Modify post with <id> and empty title "<json>"
    When Send request patch modify post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "PUP007Schema.json"
    Examples:
      | id    | json        | field | message        |
      | 91383 | PUP007.json | title | can't be blank |

  Scenario Outline: Modify post with id and empty body
    Given Modify post with <id> and empty body "<json>"
    When Send request patch modify post
    Then Status code should be 422
    And Response body field was "<field>" and message was "<message>"
    And Validate json schema "PUP008Schema.json"
    Examples:
      | id    | json        | field | message        |
      | 91383 | PUP008.json | body  | can't be blank |
