package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
    @Test
    public void AddPet(){
        String reqBody = "{\"id\": 77232,\"name\": \"Riley\",\"status\": \"alive\"}";
    Response response= given().contentType(ContentType.JSON).body(reqBody)
            .when().post("https://petstore.swagger.io/v2/pet");
//String body=response.getBody().asPrettyString();
//System.out.println("body:"+body);
        response.then().body("id",equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }
    @Test
    public void getPet(){
        Response response= given().contentType(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/77232");
        String body=response.getBody().asPrettyString();
        System.out.println("body:"+body);
    }
    @Test
    public void deletePet(){
        Response response= given().contentType(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/77232");
        String body=response.getBody().asPrettyString();
        System.out.println("body:"+body);
    }
}