package com.epam.springtest.steps;

import com.epam.springtest.pageobject.NavigationPage;
import com.epam.springtest.util.AppProperties;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.SoftAssertions;

/**
 * Step definitions for navigation-related Cucumber scenarios.
 *
 * <p>Delegates UI interactions to {@link NavigationPage} and verifies the welcome message on the
 * home page.
 */
@RequiredArgsConstructor
public class NavigationSteps {

  private final AppProperties properties;
  private final NavigationPage navigationPage;

  @When("^I open the home page$")
  public void iOpenTheHomePage() {
    navigationPage.openHomePage();
  }

  @Then("^I see the heading (.*)$")
  public void iSeeTheHeading(String message) {
    var softAssertions = new SoftAssertions();

    softAssertions
            .assertThat(navigationPage.getHeadingMessage().getText())
            .isEqualToIgnoringCase(message);

    softAssertions.assertAll();
  }

  @Then("^I see the sub-heading (.*)$")
  public void iSeeTheSubHeading(String message) {
    var softAssertions = new SoftAssertions();

    softAssertions
            .assertThat(navigationPage.getSubHeadingMessage().getText())
            .isEqualToIgnoringCase(message);

    softAssertions.assertAll();
  }

  @Then("I count all the clickable elements \\(links) in the page")
  public void iCountAllTheClickableElementsLinksInThePage() {
    navigationPage.getListOfClickableLinks();

    var softAssertions = new SoftAssertions();

    softAssertions
            .assertThat(navigationPage.getLinks().size())
            .isEqualTo(properties.getTotalOfLinks());

    softAssertions.assertAll();
  }
}
