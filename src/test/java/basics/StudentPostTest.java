package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import student.model.Student;
import studentBase.TestBase;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StudentPostTest extends TestBase {

    @Test
    public void createNewStudent(){
        Student student = Student.create();

        given()
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .post()
                .then()
                .statusCode(201);
    }
}
