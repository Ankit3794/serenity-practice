package APITests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(SerenityRunner.class)
public class SwaggerAPITests {

    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io")
            .setBasePath("/v2/pet")
            .setContentType(ContentType.JSON).build();
    private Response response;

    @Before
    public void getResponse(){
       response = SerenityRest.given(requestSpecification)
                .when()
                .queryParam("status", "available")
                .get("/findByStatus");
    }

    @Test
    public void verifyOKStatus(){
        assertThat(response.statusCode(), equalTo(200));
    }

    @Test
    public void verifyAvailableStatus(){
        assertThat(response.body().jsonPath().get("status"), hasItems("available"));
        int length = ((ArrayList<?>) response.body().jsonPath().get()).size();
        assertThat(length, greaterThan(5));
        System.out.println("Length - " + length);
    }

    @Test
    public void verifyResponseHeaders(){
        assertThat(response.header("content-type"), equalTo("application/json"));
        assertThat(response.header("Access-Control-Allow-Origin"), equalTo("*"));
    }

    @Test
    public void failureTestToVerifyStatusCode(){
        assertThat(response.statusCode(), equalTo(404));
    }
}
