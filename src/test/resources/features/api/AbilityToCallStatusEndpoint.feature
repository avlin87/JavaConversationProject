@api
Feature: Status code endpoint

  Scenario: Verify 200 response
    When I request status code 200 with expectRedirect false
    Then I verify response status is 200

  Scenario: Verify 301 response
    When I request status code 301 with expectRedirect true
    Then redirect location is none and status is 301

  Scenario: Verify 404 response
    When I request status code 404 with expectRedirect false
    Then I verify response status is 404

  Scenario: Verify 500 response
    When I request status code 500 with expectRedirect false
    Then I verify response status is 500