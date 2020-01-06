package studentBase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void setup(){
        RestAssured.baseURI ="http://localhost";
        RestAssured.port=8081;
        RestAssured.basePath="/student";
    }
}