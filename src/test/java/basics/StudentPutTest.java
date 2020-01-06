package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import student.model.Student;
import studentBase.TestBase;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StudentPutTest  {
    @BeforeClass
    public static void setup(){
        RestAssured.baseURI ="http://localhost";
        RestAssured.port=8082;
        RestAssured.basePath="/student";
    }
    @Test
    public void updateStudent(){
        ArrayList<String> courses= new ArrayList<>();
        courses.add("java");
        courses.add("c++");
        Student student = new Student();
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setEmail("jan@kowalski.com");
        student.setProgramme("IT");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .put("101")
                .then()
                .statusCode(200);
    }
}
