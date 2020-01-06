package loggingsamples;

import org.testng.annotations.Test;
import studentBase.TestBase;

import static io.restassured.RestAssured.given;

public class LoggingResponseValues extends TestBase {

    @Test
    public void printResponseHeaders(){
        given()
                .param("programme", "Computer science")
                .param("limit", 2)
                .when()
                .get("/list")
                .then()
                .log()
                .headers();
    }

    @Test
    public void printResponseStatus(){
        given()
                .param("programme", "Computer science")
                .param("limit", 2)
                .when()
                .get("/list")
                .then()
                .log()
                .status();
    }

    @Test
    public void printResponseBody(){
        given()
                .param("programme", "Computer science")
                .param("limit", 2)
                .when()
                .get("/list")
                .then()
                .log()
                .body();
    }

    @Test
    public void printResponseBodyAfterFailure(){
        given()
                .param("programme", "Computer science")
                .param("limit", -2)
                .when()
                .get("/list")
                .then()
                .log()
                .ifError();
    }
}
