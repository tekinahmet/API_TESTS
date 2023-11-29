package get_requests;

import baseUrl.ContactListBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get06 extends ContactListBaseUrl {
    @Test
    public void get06() {
//        set url
        spec.pathParam("first", "contacts");

//        set the expected data

//        send request and get response and authorization
        Response response = given(spec).when().get("{first}");//when() is optional
        response.prettyPrint();

//        do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
