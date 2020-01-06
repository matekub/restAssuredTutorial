package loggingsamples;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import student.model.Student;
import studentBase.TestBase;

import static io.restassured.RestAssured.given;

public class LoggingRequestValues extends TestBase {

    //print out request headers
    @Test
    public void printHeadersTest(){
        given()
                .log()
                .headers()
                .when()
                .get("/2")
                .then()
                .statusCode(200);
    }

    //print out request parameters
    @Test
    public void printRequestParametersTest(){
        given()
                .param("programme", "Computer science")
                .param("limit", 2)
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void printRequestBody(){
        Student student = Student.create();

        given()
                .contentType(ContentType.JSON)
                .body(student)
                .log()
                .body()
                .when()
                .post()
                .then()
                .statusCode(201);
    }

    @Test
    public void printAll(){
        Student student = Student.create();

        given()
                .contentType(ContentType.JSON)
                .body(student)
                .log()
                .all()
                .when()
                .post()
                .then()
                .statusCode(201);
    }

    @Test
    public void printAllIFails(){
        Student student = Student.create();

        given()
                .contentType(ContentType.JSON)
                .body(student)
                .log()
                .ifValidationFails()
                .when()
                .post()
                .then()
                .statusCode(2012);
    }
}
