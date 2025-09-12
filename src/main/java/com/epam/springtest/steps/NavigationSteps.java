package com.epam.springtest.steps;

import com.epam.springtest.pageobject.NavigationPage;
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

  private final NavigationPage navigationPage;

  @When("^I open the home page$")
  public void iOpenTheHomePage() {
    navigationPage.openHomePage();
  }

  @Then("^I see the heading (.*)$")
  public void iSeeTheHeading(String message) {
    var softAssertions = new SoftAssertions();

    softAssertions
        .assertThat(navigationPage.getWelcomeMessage().getText())
        .isEqualToIgnoringCase(message);

    softAssertions.assertAll();
  }
}
