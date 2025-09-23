Feature: Home page

  Scenario: Open the site
    Given I open the home page
    Then I see the heading Welcome to the-internet
    Then I see the sub-heading Available Examples
    Then I count all the clickable elements (links) in the page
