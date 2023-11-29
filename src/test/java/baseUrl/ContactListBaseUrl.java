package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ContactListBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTY3OWExZWRhYWI3NzAwMTM4NDM1YzEiLCJpYXQiOjE3MDEyODg1MTZ9.DHMJYwvImYNti1lWR_lb-h0L9jGaaBZyULGJYV8fN7k")
                .build();
    }
}
