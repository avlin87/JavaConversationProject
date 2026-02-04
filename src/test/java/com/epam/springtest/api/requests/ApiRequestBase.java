package com.epam.springtest.api.requests;

import static io.restassured.RestAssured.given;

import com.epam.springtest.util.AppProperties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

/** Base request class for API endpoints. */
public abstract class ApiRequestBase {

  private final AppProperties properties;

  protected ApiRequestBase(AppProperties properties) {
    this.properties = properties;
  }

  protected RequestSpecification baseSpec() {
    return new RequestSpecBuilder().setBaseUri(properties.getApiBaseUrl()).build();
  }

  protected Response get(String path, Map<String, ?> pathParams, boolean followRedirects) {
    return given()
        .spec(baseSpec())
        .config(
            RestAssuredConfig.config()
                .redirect(RedirectConfig.redirectConfig().followRedirects(followRedirects)))
        .pathParams(pathParams)
        .when()
        .get(path);
  }
}
