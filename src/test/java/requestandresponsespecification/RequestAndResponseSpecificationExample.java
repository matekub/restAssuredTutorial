package requestandresponsespecification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RequestAndResponseSpecificationExample {
    public static final String KEY = "AIzaSyBIlZQymJvjXP4hQpRZy7KP7QYLeBgPYzg";
    static RequestSpecBuilder requestSpecBuilder;
    static RequestSpecification requestSpecification;
    static ResponseSpecBuilder responseSpecBuilder;
    static ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com/maps/api";
        RestAssured.basePath = "/distancematrix";

        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addQueryParam("units", "imperial");
        requestSpecBuilder.addQueryParam("origins", "Washington,DC");
        requestSpecBuilder.addQueryParam("destinations", "New York City,NY");
        // requestSpecBuilder.addQueryParam("key", KEY);
        requestSpecBuilder.addHeader("Accept", "*/*");

        requestSpecification = requestSpecBuilder.build();

        responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Content-Type", "application/json; charset=UTF-8");
        responseSpecBuilder.expectHeader("Server", "mafe");
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.rootPath("rows[0].elements[0].distance");
        responseSpecBuilder.expectBody("text", equalTo("225 mi"));
        responseSpecBuilder.expectBody("value", equalTo(361959));

        responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void verifyDistance() {
        //String distance =
        given()
                .spec(requestSpecification)
                .queryParam("key", KEY)
                .when()
                .get("/json")
                .then()
                .spec(responseSpecification)
                //.extract().jsonPath().getString("rows.elements.distance.text");
                .log()
                .all();
        // System.out.println(distance);
    }
}
