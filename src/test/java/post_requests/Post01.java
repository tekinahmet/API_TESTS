package post_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post01 extends PetStoreBaseUrl {
    @Test
    public void post01() {
//        set url
        specPetStore.pathParam("first", "pet");

//        set expected data
        String payload = "{\n" +
                "    \"id\": 0,\n" +
                "    \"category\": {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"Köpek\"\n" +
                "    },\n" +
                "    \"name\": \"Pamuk\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"string\"\n" +
                "    ],\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": 0,\n" +
                "            \"name\": \"Sibirya Kurdu\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"available\"\n" +
                "}";

//        send request and get response
        Response response = given(specPetStore).body(payload).when().post("{first}");
        response.prettyPrint();

//        do assertion
          response
                  .then()
                  .statusCode(200)
                  .contentType(ContentType.JSON);
    }
}
