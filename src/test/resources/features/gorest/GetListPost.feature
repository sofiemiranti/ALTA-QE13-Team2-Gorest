Feature: Get List Post
  Scenario Outline: Get list post with valid param page
    Given Get list post with valid param <page>
    When Send request get list post
    Then Status code should be 200
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario Outline: Get list post with invalid param page
    Given Get list post with invalid param "<page>"
    When Send request get list post
    Then Status code should be 404
    Examples:
      | page |
      | a    |
      | @    |

  Scenario Outline: Get list post with non exist page
    Given Get list post with non exist <page>
    When Send request get list post
    Then Status code should be 404
    Examples:
      | page |
      | 1000 |
      | 2000 |