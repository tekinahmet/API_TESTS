package get_requests;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get03 {
    @Test
    public void get03HardAssertion() {

//        set the url
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/2175";

//        set expected data

//        send request and get response
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", containsString("kangal"))
                .body("status", equalToIgnoringCase("available"))
                .body("category.name", equalTo("dog"))
                .body("tags[0].name", equalTo("sivas kangalı"));

    }
    @Test
    public void get03SoftAssertion() {

//        set the url
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/2175";

//        set expected data

//        send request and get response
        given()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", containsString("kangal"),
                        "status", equalToIgnoringCase("available"),
                                "category.name", equalTo("dog"),
                                        "tags[0].name", equalTo("sivas kangalı"));

    }
}
