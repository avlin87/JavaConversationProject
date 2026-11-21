@ui
Feature: Home page landing

  Scenario: Verify heading on home page
    Given I open the home page
    Then I verify visibility of heading with Welcome to the-internet
    And I verify visibility of sub-heading with Available Examples
    And I verify there are 76 links in the page
    And I see the footer Powered by Elemental Selenium and Sauce Labs
