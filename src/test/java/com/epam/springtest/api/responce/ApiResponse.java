package com.epam.springtest.api.responce;

import io.restassured.response.Response;

/** Basic response wrapper to centralize common accessors. */
public class ApiResponse {

  private final Response response;

  public ApiResponse(Response response) {
    this.response = response;
  }

  public int statusCode() {
    return response.getStatusCode();
  }

  public String bodyAsString() {
    return response.getBody().asString();
  }

  public Response raw() {
    return response;
  }
}
