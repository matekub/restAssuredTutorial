package authenticationexamples.paypal;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class OAuth2Base {

    private static final String USERNAME = "";
    private static final String KEY = "";
    static String accessToken;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://api.sandbox.paypal.com";
        RestAssured.basePath = "/v1";
        accessToken = getToken();
    }

    private static String getToken() {
        return given()
                .param("grant_type", "client_credentials")
                .auth()
                .preemptive()
                .basic(USERNAME, KEY)
                .when()
                .post("/oauth2/token")
                .then()
                .extract()
                .jsonPath()
                .getString("access_token");
    }
}