package helper.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import pageobjects.api.Pet;

public class PetStoreHelper {
    private Response response;

    @Step
    public void createPet(Pet pet) {
        response = RestAssured.given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/pet");
    }

    public void validateStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
        System.out.println(response.body().prettyPrint());
    }

    public void deletePet(int id) {
        response = RestAssured.given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .delete("/pet/" + id);
    }
}
