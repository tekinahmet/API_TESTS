package get_requests;

import baseUrl.JsonPlaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08 extends JsonPlaceholderBaseUrl {
    @Test
    public void get08() {
//        set url
        spec.pathParam("first", "todos");

//        set expected data

//        send request and get response
        Response response = given(spec).when().get("{first}");
//        response.prettyPrint();

//        do assertion
        assertEquals(200, response.statusCode());

        JsonPath json = response.jsonPath();
        List<Object> idList = json.getList("findAll{it.id>190}");
        System.out.println("ID List = " + idList);
        assertEquals(10, idList.size());

        List<Integer> userIdList = json.getList("findAll{it.id<5}.userId");
        System.out.println("userIdList = " + userIdList);
        assertEquals(4, userIdList.size());

        List<String> titleList = json.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);
        assertEquals(4, titleList.size());

        assertTrue(titleList.contains("delectus aut autem"));

        List<Integer> id = json.getList("findAll{it.title == 'delectus aut autem'}.id");
        System.out.println("ID = " + id);

        int idInt = id.get(0);
        System.out.println("idInt = " + idInt);
    }
}
