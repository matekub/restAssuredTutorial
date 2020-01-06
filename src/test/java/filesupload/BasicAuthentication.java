package filesupload;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BasicAuthentication {
    public static final String KEY = "key";

    @Test
    public void uploadFile() {
        given()
                .auth()
                .basic(KEY, "")
                .multiPart(new File("path/to/file"))
                .when()
                .post("endpoint")
                .then()
                .log()
                .all();
    }
}
