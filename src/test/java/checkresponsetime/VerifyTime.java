package checkresponsetime;

import io.restassured.RestAssured;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VerifyTime {
    public static final String KEY = "AIzaSyBIlZQymJvjXP4hQpRZy7KP7QYLeBgPYzg";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com/maps/api";
        RestAssured.basePath = "/distancematrix";
    }

    @Test
    public void verifyTimeTest() {
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .time(lessThan(5L), TimeUnit.SECONDS);

    }

    @Test
    public void verifyTimeTest2() {
        long responseTime = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .timeIn(TimeUnit.SECONDS);

        System.out.println(responseTime);
    }
}
