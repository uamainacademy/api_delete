package apiTests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class BaseTest {

  static {
    RestAssured.requestSpecification = new RequestSpecBuilder()
        .build()
        .filter(new RequestLoggingFilter())
        .filter(new ResponseLoggingFilter())
        .header("app-id", "6112dc7c3f812e0d9b6679dd")
        .baseUri("https://dummyapi.io/")
        .basePath("data/v1/");
  }
}
