package com.epam.springtest.api.requests;

import com.epam.springtest.util.AppProperties;
import io.restassured.response.Response;

/** Simple GET request wrapper for arbitrary paths. */
public class GenericGetRequest extends ApiRequestBase {

  public GenericGetRequest(AppProperties properties) {
    super(properties);
  }

  @Override
  public Response get(String path) {
    return super.get(path);
  }
}
