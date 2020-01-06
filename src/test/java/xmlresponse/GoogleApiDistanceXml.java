package xmlresponse;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static jsonresponse.GoogleAPIDistanceJson.KEY;

public class GoogleApiDistanceXml {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://maps.googleapis.com/maps/api";
        RestAssured.basePath = "/distancematrix";
    }

    @Test
    public void getBody() {
        Response response = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/xml");
        response.prettyPrint();
    }

    @Test
    public void getStatus() {
        String status = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/xml")
                .then()
                .extract()
                // .path("DistanceMatrixResponse.status");
                .xmlPath().get("DistanceMatrixResponse.status");
        System.out.println(status);
    }

    @Test
    public void getStatus2() {
        String xml = given()
                .queryParam("units", "imperial")
                .queryParam("origins", "Washington,DC")
                .queryParam("destinations", "New York City,NY")
                .queryParam("key", KEY)
                .when()
                .get("/xml").asString();
        String status = XmlPath.with(xml).getString("DistanceMatrixResponse.status");
        System.out.println(status);
    }
}
