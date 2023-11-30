package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class Get07 extends HerokuAppBaseUrl {
    /*
    {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}
     */
    @Test
    public void get07() {
//        set url
        spec.pathParams("first", "booking", "second", "24");

//        set expected data

//        send request and get response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

//        do assertion
        //1st way
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("John"))
                .body("lastname", equalTo("Smith"))
                .body("totalprice", equalTo(111))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("Breakfast"));

        //2nd way
        JsonPath json = response.jsonPath();

        String firstname = json.getString("firstname");
        System.out.println("firstname = " + firstname);

        String lastname = json.getString("lastname");
        System.out.println("lastname = " + lastname);

        int totalprice = json.getInt("totalprice");
        System.out.println("totalprice = " + totalprice);

        String checkin = json.getString("bookingdates.checkin");
        System.out.println("checkin = " + checkin);

        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        assertEquals("John", json.getString("firstname"));
        assertEquals("Smith", json.getString("lastname"));
        assertEquals(111, json.getInt("totalprice"));
        assertEquals(true, json.getBoolean("depositpaid"));
        assertEquals("2018-01-01", json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", json.getString("bookingdates.checkout"));
        assertEquals("Breakfast", json.getString("additionalneeds"));

    }
}
