package basics;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import studentBase.TestBase;

import static io.restassured.RestAssured.given;

public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInformation() {
        /*Response response = given()
                .when()
                .get("/list");
        System.out.println(response.body().prettyPrint());*/
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentInformation1() {
        Response response =
                given()
                        .when()
                        .get("/1");
        System.out.println(response.body().prettyPrint());
    }

    @Test
    public void getStudentInformation2() {
        /*Response response =
                given()
                        .when()
                        .get("/107");
        System.out.println(response.body().prettyPrint());*/
        given()
                .when()
                .get("107")
                .then()
                .statusCode(404);
    }

    @Test
    public void getStudentFromFinancialAnalysisProgramme() {
        given().param("programme", "Financial Analysis")
                .param("limit", "2")
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentFromFinancialAnalysisProgrammeSecondTest() {
        Response response = given()
                .when()
                .get("/list?programme=Financial Analysis&limit=2");
        System.out.println(response.prettyPrint());
    }
}
