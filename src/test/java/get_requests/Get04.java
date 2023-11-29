package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get04 extends PetStoreBaseUrl {
    @Test
    public void get04() {
//        set url
        specPetStore.pathParams("1", "pet", "2", 2175);

//        set expected data

//        sent request and get response
        Response response = given(specPetStore).get("{1}/{2}");
        response.prettyPrint();

//        do assertion
       response
               .then()
               .statusCode(200)
               .contentType(ContentType.JSON);
    }
}
