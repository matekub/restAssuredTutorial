package authenticationexamples.paypal;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class OAuth2Example extends OAuth2Base {
    private String paymentId;

    @Test
    public void createPayment() throws IOException {

        String body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\payment.txt")));

        paymentId = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(accessToken)
                .when()
                .body(body)
                .post("/payments/payment")
                .then()
                .extract()
                .jsonPath()
                .getString("id");
        System.out.println(accessToken);
        System.out.println(paymentId);
    }

    @Test
    public void getPaymentDetails() {
        given()
                .auth()
                .oauth2(accessToken)
                .when()
                .get("payments/payment/" + paymentId)
                .then()
                .statusCode(200)
                .log()
                .all();

    }
}