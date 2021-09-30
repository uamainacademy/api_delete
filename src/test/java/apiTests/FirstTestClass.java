package apiTests;

import static framework.Endpoints.GET_USERS;
import static framework.Endpoints.GET_USER_BY_ID;

import framework.models.UserProfileModel;
import io.restassured.RestAssured;
import java.util.Objects;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.plugin.util.UserProfile;

public class FirstTestClass extends BaseTest {

  @Test(dataProvider = "getLimit")
  public void isTenUsersTest(int expectedLimit) {
    RestAssured
        .given()
        .queryParam("limit", expectedLimit)
        .get(GET_USERS)
        .then()
        .statusCode(200);
  }

  @DataProvider
  public Object[][] getLimit() {
    return new Object[][]{
        {10}, {20}, {30}
    };
  }

  @Test
  public void isMsTest() {
    UserProfileModel response = RestAssured
        .given()
        .pathParam("id","60d0fe4f5311236168a109ca")
        .get(GET_USER_BY_ID)
        .then()
        .statusCode(200)
        .extract()
        .body()
        .as(UserProfileModel.class);

    Assert.assertEquals(response.getTitle(),"ms");
  }

  @Test
  public void createSmtTest() {

    UserProfileModel build = UserProfileModel.builder()
        .firstName("fdfdf")
        .lastName("dssdsd")
        .gender("fdfdf").build();

    UserProfileModel response = RestAssured
        .given()
        .body(build)
        .when()
        .post("create_user")
        .then()
        .statusCode(201)
        .extract().as(UserProfileModel.class);

  }
}



