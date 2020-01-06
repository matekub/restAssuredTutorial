package proxy;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class StaticProxyConfiguration {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
        RestAssured.basePath = "/student";
        RestAssured.proxy("localhost", 5555);
    }
    @Test
    public void getAllStudentsInformation() {
        given()
                .when()
                .get("/list")
                .then()
                .log()
                .body();
    }
}
