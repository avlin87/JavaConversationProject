package com.epam.springtest.api.requests;

import static io.restassured.RestAssured.given;

import com.epam.springtest.util.AppProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/** Base request class for API endpoints. */
public abstract class ApiRequestBase {

  private final AppProperties properties;

  protected ApiRequestBase(AppProperties properties) {
    this.properties = properties;
  }

  protected RequestSpecification baseSpec() {
    return new RequestSpecBuilder().setBaseUri(properties.getApiBaseUrl()).build();
  }

  protected Response get(String path) {
    return given().spec(baseSpec()).when().get(path);
  }
}
