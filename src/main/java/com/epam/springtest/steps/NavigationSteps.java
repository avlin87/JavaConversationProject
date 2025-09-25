package com.epam.springtest.steps;

import com.epam.springtest.enums.Links;
import com.epam.springtest.pageobject.NavigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;

/**
 * Step definitions for navigation-related Cucumber scenarios.
 *
 * <p>Delegates UI interactions to {@link NavigationPage} and verifies the welcome message on the
 * home page.
 */
@Slf4j
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

  @Then("^I verify there are (.*) links in the page$")
  public void iCountAllTheClickableElementsLinksInThePage(int amountOfLinks) {
    navigationPage.listPresentLinks();
    var softAssertions = new SoftAssertions();
    softAssertions
            .assertThat(navigationPage.getLinks().size())
            .isEqualTo(amountOfLinks);
    softAssertions.assertAll();
  }

  @Then("^I see the footer (.*)$")
  public void iSeeTheFooter(String message) {
    var softAssertions = new SoftAssertions();
    softAssertions
            .assertThat(navigationPage.getFooterMessage().getText())
            .isEqualToIgnoringCase(message);
    softAssertions.assertAll();
  }

  @And("I see the Fork me on Github badge")
  public void iSeeTheForkMeOnGithubBadge() {
    var softAssertions = new SoftAssertions();
    softAssertions
            .assertThat(navigationPage.getForkMeBadge().isDisplayed())
            .isTrue();
    softAssertions.assertAll();
  }

  @And("^I click (.*) link$")
  public void iClickLink(Links link) {
    navigationPage.clickLink(link);
  }
}
