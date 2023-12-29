Feature: Update comments details

  Scenario: Update comments details without id
    Given Update comments details without id "UCD001.json"
    When Send request put update comments
    Then Status code should be 404

  Scenario: Update comments details with valid data
    Given Update comments details with valid data "UCD002.json"
    When Send request put update comments
    Then Status code should be 404

  Scenario: Update comments details with invalid email
    Given Update comments details with invalid json "UCD003.json"
    When Send request put update comments
    Then Status code should be 404

    Scenario: Modify comments details with valid name
      Given Modify comments details with valid json "UCD004.json"
      When Send request patch modify comments
      Then Status code should be 404

      Scenario: Modify comments details with invalid email
        Given Modify comments details with invalid json "UCD005.json"
        When Send request patch modify comments
        Then Status code should be 404