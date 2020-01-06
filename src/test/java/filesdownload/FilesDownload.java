package filesdownload;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

import static io.restassured.RestAssured.given;

public class FilesDownload {

    @Test
    public void verifyDownloadedFile(){

        //https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-win64.zip
        //Read input file
        File inputFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver-v0.26.0-win64.zip");

        //Length of the input file
        long expectedSize = inputFile.length();
        System.out.println(expectedSize);

        //Read the downloaded file
        byte[] actualValue = given()
                .when()
                .get("https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-win64.zip")
                .then()
                .extract()
                .asByteArray();
        Assert.assertEquals(actualValue.length, expectedSize);
    }
}
