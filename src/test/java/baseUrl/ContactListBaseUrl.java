package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

import static utils.AuthenticationContactList.generateToken;

public class ContactListBaseUrl {

    protected RequestSpecification spec;
    @Before
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer " + generateToken())
                .build();
    }
}
