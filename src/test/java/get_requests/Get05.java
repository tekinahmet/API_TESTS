package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get05 extends PetStoreBaseUrl {
    @Test
    public void get05(){
//        set url
        specPetStore
                .pathParams("1", "pet", "2", "findByStatus")
                .queryParam("status", "available");
//        set expected data

//        send request and get response
        Response response = given().spec(specPetStore).get("{1}/{2}");
//        response.prettyPrint();

//        do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", hasItem(2175))
                .body("name", hasItem("dog"))
                .body("name", hasItems("dog", "doggie", "fish"))
                .body("id", hasSize(greaterThan(200)))
                .body("id", hasSize(lessThan(1000)))
                .body("[0].category.id", equalTo(0))
                .body("[0].photoUrls[0]", equalTo("string"))
                .body("[0].tags[0].id", equalTo(0));

    }
}
