package com.epam.springtest.steps;

import com.epam.springtest.enums.HomePageLink;
import com.epam.springtest.pageobject.NavigationPage;
import com.epam.springtest.util.AppProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step definitions for navigation-related Cucumber scenarios.
 *
 * <p>Delegates UI interactions to {@link NavigationPage} and verifies the welcome message on the
 * home page.
 */
@Slf4j
@RequiredArgsConstructor
public class NavigationSteps {

  private final AppProperties properties;
  private final NavigationPage navigationPage;

  @When("^I open the home page$")
  public void iOpenTheHomePage() {
    navigationPage.openHomePage();
  }

  @Then("^I verify visibility of heading with (.*)$")
  public void iVerifyVisibilityOfHeadingWith(String message) {
    assertThat(navigationPage.getHeadingMessage().getText())
            .isEqualToIgnoringCase(message);
  }

  @Then("^I verify visibility of sub-heading with (.*)$")
  public void iVerifyVisibilityOfSubHeadingWith(String message) {
    assertThat(navigationPage.getSubHeadingMessage().getText())
            .isEqualToIgnoringCase(message);
  }

  @Then("^I verify there are (.*) links in the page$")
  public void iVerifyThereAreLinksInThePage(int amountOfLinks) {
    navigationPage.logPresentLinks();

    assertThat(navigationPage.getLinks().size())
            .isEqualTo(amountOfLinks);
  }

  @Then("^I see the footer (.*)$")
  public void iSeeTheFooter(String message) {
    assertThat(navigationPage.getFooterMessage().getText())
            .isEqualToIgnoringCase(message);
  }

  @And("I see the Fork me on Github badge")
  public void iSeeTheForkMeOnGithubBadge() {
    assertThat(navigationPage.getForkMeBadge().isDisplayed())
            .isTrue();
  }

  @And("^I click (.*) link$")
  public void iClickLink(HomePageLink link) {
    navigationPage.clickLink(link);
  }

  @And("^I verify (.*) page is properly displayed$")
  public void iVerifyPageIsProperlyDisplayed(HomePageLink link) {
    assertThat(url()).isEqualTo(properties.getBaseUrl().concat(link.getPath()));
  }

  @When("I right-click the rectangle present")
  public void iRightClickTheRectanglePresent() {
      navigationPage.rightClickRectangle();
  }

  @Then("^I verify alert is displayed with message (.*)$")
  public void iVerifyAlertIsDisplayed(String alertMessage) {
    SoftAssertions softAssert= new SoftAssertions();

    softAssert.assertThat(navigationPage.isAlertPresent())
            .isTrue();
    softAssert.assertThat(switchTo().alert().getText())
            .isEqualTo(alertMessage);

    softAssert.assertAll();
  }

  @And("I accept alert message")
  public void iAcceptAlertMessage() {
    navigationPage.acceptAlert();
  }
}
