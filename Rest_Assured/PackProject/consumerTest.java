package Packproject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class consumerTest {

    Map<String, String> headers = new HashMap<>();
    // Set resource URI
    String createUser = "/api/users";

    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        headers.put("Content-Type", "application/json");
        DslPart requestBody = new PactDslJsonBody()
                .numberType("id", 1)
                .stringType("firstName", "saranya")
                .stringType("lastName", "palanisamy")
                .stringType("email", "saranya030994@gmail.com");
        return builder
                .given("Post request")
                .uponReceiving("a request to create a user")
                .path("/api/users")
                .method("POST")
                .headers(headers)
                .body(requestBody)
                .willRespondWith()
                .status(201)
                .body(requestBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void consumerTest() {
        //Req Body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 100);
        reqBody.put("firstName", "saranya");
        reqBody.put("lastName", "palanisamy");
        reqBody.put("email", "saranya030994@gmail.com");
        RestAssured.baseURI = "http://localhost:8282/api/users";
        RequestSpecification rq=RestAssured.given().headers(headers).when();
        Response response= rq.body(reqBody).post(createUser);

        //Send POST Request
        given().baseUri("http://localhost:8282/api/users")
                .headers(headers)
                .body(reqBody)
                .log().all()
                .when().post()
                .then().statusCode(201)
                .body("email", equalTo("saranya030994@gmail.com")).log().all();
    }

}