package com.epam.springtest.pageobject;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.springtest.enums.HomePageLink;
import com.epam.springtest.util.AppProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoAlertPresentException;
import org.springframework.stereotype.Component;

/**
 * Page Object representing the main navigation (home) page.
 *
 * <p>Encapsulates common actions and elements, such as opening the base URL and reading the welcome
 * message.
 */
@Slf4j
@Getter
@Component
@RequiredArgsConstructor
public class NavigationPage {

  private final AppProperties properties;
  private final SelenideElement headingMessage = $(byTagName("h1"));
  private final SelenideElement subHeadingMessage = $(byTagName("h2"));
  private final SelenideElement footerMessage = $("#page-footer");
  private final SelenideElement forkMeBadge = $("a").$("img[alt='Fork me on GitHub']");
  private final ElementsCollection links = $("#content").$$("a");
  private final String LINK_TEMPLATE = "#content a";
  private final SelenideElement dottedRectangle = $("#hot-spot");
  private final SelenideElement contextMenuItem =  $(".context-menu-list");

  public void openHomePage() {
    open(properties.getBaseUrl());
  }

  public void logPresentLinks() {
    log.info("The page currently has {} clickable links:", getLinks().size());
    for (SelenideElement link : links) {
      log.info(link.getText());
    }
  }

  public void clickLink(HomePageLink link) {
    $$(LINK_TEMPLATE)
            .findBy(text(link.getAltText()))
            .click();
  }

  public void rightClickRectangle() {
    dottedRectangle.contextClick();
  }

  public boolean isAlertPresent() {
    try {
      switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void acceptAlert() {
    switchTo().alert().accept();
  }
}
