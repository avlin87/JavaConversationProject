package com.epam.springtest.api.requests;

import com.epam.springtest.api.endpoints.ApiEndpoints;
import com.epam.springtest.util.AppProperties;
import io.restassured.response.Response;
import java.util.Map;

/** Example request object for /status_codes endpoints. */
public class StatusCodeRequest extends ApiRequestBase {

  public StatusCodeRequest(AppProperties properties) {
    super(properties);
  }

  public Response getStatusCode(int code, boolean expectRedirect) {
    return get(ApiEndpoints.STATUS_CODES, Map.of("id", code), !expectRedirect);
  }
}
