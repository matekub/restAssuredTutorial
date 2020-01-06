package jsonlibraryassertions;

import io.restassured.response.ResponseBody;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
import studentBase.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class JsonAssertions extends TestBase {

    @Test
    public void validateStudentTest() throws JSONException {
        String expected = "{\"id\":1,\"firstName\":\"Vernon\",\"lastName\":\"Harper\"," +
                "\"email\":\"egestas.rhoncus.Proin@massaQuisqueporttitor.org\",\"programme\":\"Financial Analysis\"," +
                "\"courses\":[\"Accounting\",\"Statistics\"]}";
      String response =  given()
                .when()
                .get("/1").asString();
        JSONAssert.assertEquals(expected, response, JSONCompareMode.STRICT);
    }

    @Test
    public void validateAllStudentsTest() throws IOException, JSONException {
        String expected = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\students.txt")));
        String response =  given()
                .when()
                .get("/list").asString();
        JSONAssert.assertEquals(expected, response, JSONCompareMode.LENIENT);
    }
}
