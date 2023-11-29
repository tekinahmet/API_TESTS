package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/2175";

        Response response = given().get(url);//when() optional
//        response.prettyPrint();

        System.out.println("statusCode() = " + response.statusCode());//statusCode() = 200

        System.out.println("contentType() = " + response.contentType());//contentType() = application/json

        System.out.println("statusLine() = " + response.statusLine());//statusLine() = HTTP/1.1 200 OK

        System.out.println("server = " + response.header("server"));//server = Jetty(9.2.9.v20150224)

        System.out.println("headers() = \n" + response.headers());

        System.out.println("time() = " + response.time());//time() = 1773


    }
}