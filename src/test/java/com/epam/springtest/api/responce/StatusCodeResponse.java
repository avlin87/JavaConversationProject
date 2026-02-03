package com.epam.springtest.api.responce;

import io.restassured.response.Response;

/** Example response object for status code endpoints. */
public class StatusCodeResponse extends ApiResponse {

  public StatusCodeResponse(Response response) {
    super(response);
  }
}
