package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get02 {
    @Test
    public void get02() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/0";
        Response response = given().get();
        response.prettyPrint();

        given()
                .get()
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Pet not found"))
                .body(not(containsString("TechproEd")))
                .header("server", "Jetty(9.2.9.v20150224)");
    }
}
