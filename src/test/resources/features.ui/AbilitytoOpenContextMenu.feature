Feature: Context Menu page

  Scenario: Open the site
    Given I open the home page
    And I click CONTEXT_MENU link
    And I verify CONTEXT_MENU page is properly displayed
    When I right-click the rectangle present
    Then I verify alert is displayed with message You selected a context menu
    And I accept alert message