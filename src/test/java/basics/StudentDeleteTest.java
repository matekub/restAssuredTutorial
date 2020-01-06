package basics;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import studentBase.TestBase;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteStudent(){
        given()
                .when()
                .delete("101")
                .then()
                .statusCode(204);
    }
}
