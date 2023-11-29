package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    @Test
    public void get01() {
//        first way
//        String url = "https://petstore.swagger.io/v2/pet/5";
//        given().when().get(url);

//        second way
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/2175";

        Response response = given().when().get();
        response.prettyPrint();

        response.then().
                assertThat().statusCode(200).
                and().assertThat().contentType("application/json").
                and().assertThat().statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void get02() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/2175";

        given().
                get().
                then().
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");
    }
}
