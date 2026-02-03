package com.epam.springtest.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.springtest.api.requests.StatusCodeRequest;
import com.epam.springtest.api.responce.ApiResponse;
import com.epam.springtest.util.AppProperties;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Step definitions for API scenarios. */
public class ApiSteps extends ApiBase {

  private static final Logger log = LoggerFactory.getLogger(ApiSteps.class);
  private ApiResponse lastResponse;
  private final StatusCodeRequest statusCodeRequest;

  public ApiSteps(AppProperties properties) {
    super(properties);
    this.statusCodeRequest = new StatusCodeRequest(properties);
  }

  @When("^I request status code (\\d+) with expectRedirect (true|false)$")
  public void iRequestStatusCode(int statusCode, boolean expectRedirect) {
    lastResponse = new ApiResponse(statusCodeRequest.getStatusCode(statusCode, expectRedirect));
    log.info("GET /status_codes/{} -> {}", statusCode, lastResponse.statusCode());
  }

  @Then("^redirect location is (.*) and status is (\\d+)$")
  public void redirectLocationIsAndStatusIs(String expectedLocation, int status) {
    assertThat(lastResponse).isNotNull();
    assertThat(lastResponse.statusCode()).isEqualTo(status);

    String actualLocation = lastResponse.raw().getHeader("Location");
    if ("none".equalsIgnoreCase(expectedLocation)) {
      assertThat(actualLocation).isNull();
    } else {
      assertThat(actualLocation).isEqualTo(expectedLocation);
    }
  }

  @Then("^I verify response status is (\\d+)$")
  public void iVerifyResponseStatusIs(int status) {
    assertThat(lastResponse).isNotNull();
    assertThat(lastResponse.statusCode()).isEqualTo(status);
  }
}
