package basics;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import student.model.Student;
import studentBase.TestBase;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudent(){
        ArrayList<String> courses= new ArrayList<>();
        courses.add("java");
        courses.add("c++");
        Student student = new Student();
        student.setFirstName("Mateusz");
        student.setLastName("Nowak");
        student.setEmail("Mateusz@Nowak.com");
        student.setProgramme("IT");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .patch("101")
                .then()
                .statusCode(200);
    }
}
