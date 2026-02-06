Feature: Home page landing

  Scenario: Verify heading on home page
    Given I open the home page
    Then I verify visibility of heading with Welcome to the-internet

  Scenario: Verify only sub-heading is visible on home page
    Given I open the home page
    Then I verify visibility of sub-heading with Available Examples

  Scenario: Verify number of links on home page
    Given I open the home page
    Then  I verify there are 44 links in the page

  Scenario: Verify footer on home page
    Given I open the home page
    Then I see the footer Powered by Elemental Selenium

  Scenario: Verify Github badge on home page
    Given I open the home page
    Then I see the Fork me on Github badge