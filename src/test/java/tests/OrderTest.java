package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import static io.restassured.RestAssured.given;

public class OrderTest extends BaseTest {

    @Test
    public void createOrderTest() {

        String payload = """
        {
          "id": 10,
          "petId": 1,
          "quantity": 2,
          "shipDate": "2026-06-13T10:00:00Z",
          "status": "placed",
          "complete": true
        }
        """;

        Response response =
                given()
                    .contentType(ContentType.JSON)
                    .body(payload)
                .when()
                    .post("/store/order")
                .then()
                    .statusCode(200)
                    .extract().response();

        // ✅ VALIDATIONS
        Assert.assertEquals(response.jsonPath().getInt("id"), 10);
        Assert.assertEquals(response.jsonPath().getString("status"), "placed");
        Assert.assertTrue(response.jsonPath().getBoolean("complete"));
    }
}
