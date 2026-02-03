package com.epam.springtest.api;

import com.epam.springtest.util.AppProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/** Base class for API steps providing a reusable RequestSpecification. */
public abstract class ApiBase {

  private final AppProperties properties;

  protected ApiBase(AppProperties properties) {
    this.properties = properties;
  }

  protected RequestSpecification baseSpec() {
    return new RequestSpecBuilder().setBaseUri(properties.getApiBaseUrl()).build();
  }
}
