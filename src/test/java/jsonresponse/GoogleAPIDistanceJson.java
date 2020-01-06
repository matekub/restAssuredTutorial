package jsonresponse;

import io.restassured.RestAssured;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GoogleAPIDistanceJson {
    public static final String KEY = "AIzaSyBIlZQymJvjXP4hQpRZy7KP7QYLeBgPYzg";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com/maps/api";
        RestAssured.basePath = "/distancematrix";
    }

    @Test
    public void getBody() {
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .log()
                .body();
    }

    @Test
    public void firstTest() {
        String status = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .extract().path("status");
        System.out.println(status);
    }

    @Test
    public void secondTest() {
        String distance = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .extract().jsonPath().getString("rows.elements.distance.text");
        System.out.println(distance);
    }

    @Test
    public void thirdTest() {
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .body("rows[0].elements[0].distance.value", greaterThan(100));
    }

    @Test
    public void verifyDistanceTextElement() {
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .body("rows[0].elements[0].distance.text", equalTo("225 mi"));
       /* System.out.println(distance.size());
        System.out.println(distance.get("text"));
        System.out.println(distance.get("value"));*/
    }

    @Test
    public void verifyElementFoundByOtherElement() {

        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .body("rows[0].elements.distance.findAll{it.text=='225 mi'}[0].value", equalTo(361959));
    }

    @Test
    public void verifyElements() {
        String result = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .extract().jsonPath().getString("rows[0].elements[0].distance.text");
        System.out.println(result);
    }

    @Test
    public void getElementByFieldValue() {

        List<Integer> values = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .extract().jsonPath().getList("rows[0].elements.distance.findAll{it.text=='225 mi'}.value");
        Assert.assertEquals(361959, (int) values.get(0));
        System.out.println(values);
    }

    @Test
    public void getElementByFieldValueWithCondition() {

        List<Integer> values = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .extract().jsonPath().getList("rows[0].elements.distance.findAll{it.value > 100}.text");
        System.out.println(values);
    }

    @Test
    public void getElementByFieldValueStartingWith() {

        List<Integer> values = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .extract().jsonPath().getList("rows[0].elements.distance.findAll{it.text==~/22.*/}.value");
        System.out.println(values);
    }

    @Test
    public void getMapElements() {
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .body("rows[0].elements[0].distance", hasKey("text"))
                .body("rows[0].elements[0].distance", hasKey("value"))
                .statusCode(200);
    }

    @Test
    public void rootPath() {
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .rootPath("rows[0].elements[0].distance")
                .body("text", equalTo("225 mi"),
                        "value", equalTo(361959));
    }

    @Test
    public void rootPath2() {
        given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .rootPath("rows[0].elements[0].distance")
                .body("text", equalTo("225 mi"),
                        "value", equalTo(361959));
    }
}