package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import static io.restassured.RestAssured.given;

public class InventoryTest extends BaseTest {

    @Test
    public void getInventory() {

        Response res =
                given()
                .when()
                    .get("/store/inventory")
                .then()
                    .statusCode(200)
                    .extract().response();

        Assert.assertTrue(res.asString().contains("sold"));
    }
}