Feature: Home page landing

  Scenario: Open the site
    Given I open the home page
    Then I verify visibility of heading with Welcome to the-internet
    And I verify visibility of sub-heading with Available Examples
    And I verify there are 44 links in the page
    And I see the footer Powered by Elemental Selenium
    And I see the Fork me on Github badge