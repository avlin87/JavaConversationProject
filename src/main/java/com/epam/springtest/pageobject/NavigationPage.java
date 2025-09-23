package com.epam.springtest.pageobject;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.springtest.util.AppProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
  private final ElementsCollection links = $("#content").$$("a");

  public void openHomePage() {
    open(properties.getBaseUrl());
  }

  /*
   This could be changed in order to use the getter annotation, but I'd like to keep the message that the amount of
   links that were found
   */
  public void getListOfClickableLinks() {
    log.info("The page currently has {} clickable links:", getLinks().size());
    for (SelenideElement link : links) {
      log.info(link.getText());
    }
  }
}
