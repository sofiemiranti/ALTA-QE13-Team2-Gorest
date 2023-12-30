Feature: Get User Details

  Scenario: Get user details with valid email
    Given Get user details with parameter email is "sofie5@yahoo.com"
    When Send request get user details with parameter email
    Then Status code should be 200
    And Validate json schema "GUD002Schema.json"

  Scenario: Get user details with unregistered user id
    Given Get user details with user id 5800000
    When Send request get user details with user id
    Then Status code should be 404
    And Response body message was "Resource not found"
    And Validate json schema "GUD003Schema.json"

  Scenario: Get user details with invalid id
    Given Get user details with user id "hehehe"
    When Send request get user details with invalid user id
    Then Status code should be 404
    And Response body message was "Resource not found"
    And Validate json schema "GUD003Schema.json"

  Scenario: Get user details with valid name and gender parameter
    Given Get user details with parameter name is "devi" and gender is "female"
    When Send request get user details with name and gender parameter
    Then Status code should be 200

  Scenario: Get user details with unavailable name and available gender parameter
    Given Get user details with parameter name is "deeev" and gender is "female"
    When Send request get user details with name and gender parameter
    Then Status code should be 200
    And Validate json schema "GUD007Schema.json"

  Scenario: Get user details with invalid parameter
    Given Get user with invalid parameter is "invalid_parameter"
    When Send request get user details with invalid parameter
    Then Status code should be 404



