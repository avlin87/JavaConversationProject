package com.epam.springtest.api.requests;

import com.epam.springtest.api.endpoints.ApiEndpoints;
import com.epam.springtest.util.AppProperties;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

/** Example request object for /status_codes endpoints. */
public class StatusCodeRequest extends ApiRequestBase {

  public StatusCodeRequest(AppProperties properties) {
    super(properties);
  }

  public Response getStatusCode(int code, boolean expectRedirect) {
    return io.restassured.RestAssured.given()
        .spec(baseSpec())
        .config(
            RestAssuredConfig.config()
                .redirect(RedirectConfig.redirectConfig().followRedirects(!expectRedirect)))
        .pathParam("id", code)
        .when()
        .get(ApiEndpoints.STATUS_CODES);
  }
}
