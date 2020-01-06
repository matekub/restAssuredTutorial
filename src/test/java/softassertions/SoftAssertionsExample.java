package softassertions;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static jsonresponse.GoogleAPIDistanceJson.KEY;
import static org.hamcrest.Matchers.*;

public class SoftAssertionsExample {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com/maps/api";
        RestAssured.basePath = "/distancematrix";
    }

    @Test
    public void softAssertionsTest() {
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .rootPath("rows[0].elements[0].distance")
                .body("value", greaterThan(100),
                        "value", lessThan(1000),
                        "text", equalTo("2225 mi"));
    }
}
