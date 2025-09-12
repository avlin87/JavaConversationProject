package com.epam.springtest.pageobject;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import com.epam.springtest.util.AppProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Page Object representing the main navigation (home) page.
 *
 * <p>Encapsulates common actions and elements, such as opening the base URL and reading the welcome
 * message.
 */
@Getter
@Component
@RequiredArgsConstructor
public class NavigationPage {

  private final AppProperties properties;
  private final SelenideElement welcomeMessage = $(byTagName("h1"));

  public void openHomePage() {
    open(properties.getBaseUrl());
  }
}
