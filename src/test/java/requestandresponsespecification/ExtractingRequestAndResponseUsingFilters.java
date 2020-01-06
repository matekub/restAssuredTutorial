package requestandresponsespecification;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import studentBase.TestBase;

import java.io.PrintStream;
import java.io.StringWriter;
import java.io.Writer;

import static io.restassured.RestAssured.given;

public class ExtractingRequestAndResponseUsingFilters extends TestBase {

    public static StringWriter requestWriter;
    public static PrintStream requestCapture;

    public static StringWriter responseWriter;
    public static PrintStream responseCapture;

    @Test
    public void getAllStudentsInformation() {

        given()
                .filter(new RequestLoggingFilter(requestCapture))
                .filter(new ResponseLoggingFilter(responseCapture))
                .when()
                .get("/list");

        System.err.println(requestWriter.toString());
        System.err.println(responseWriter.toString());
    }
    @BeforeMethod
    public void beforeEachTest(){
        requestWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);

        responseWriter = new StringWriter();
        responseCapture = new PrintStream(new WriterOutputStream(responseWriter), true);
    }
}
