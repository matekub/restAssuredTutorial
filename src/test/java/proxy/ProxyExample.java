package proxy;

import io.restassured.RestAssured;
import io.restassured.specification.ProxySpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProxyExample {
    private static final String SERVER_NAME = "localhost";
    private static final int SERVER_PORT = 5555;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
        RestAssured.basePath = "/student";
    }
    @Test
    public void getAllStudentsInformation() {
        given()
                .when()
                .proxy(SERVER_NAME, SERVER_PORT)
                .get("/list")
                .then()
                .log()
                .body();
    }
    @Test
    public void getAllStudentsInformation2() {
        ProxySpecification ps = new ProxySpecification(SERVER_NAME, SERVER_PORT, "http");
        given()
                .when()
                .proxy(ps)
                .get("/list")
                .then()
                .log()
                .body();
    }
}
