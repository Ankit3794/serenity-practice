package stepdefs.api;

import helper.api.PetStoreHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Shared;
import pageobjects.api.Category;
import pageobjects.api.Pet;
import pageobjects.api.Tag;

import java.util.Arrays;

public class PetStoreSteps {
    @Shared
    private PetStoreHelper petStoreHelper;
    @Given("user adds new pet")
    public void addNewPet(){
        Pet dog = new Pet(
                1, new Category(1, "dog"), "doggie",
                Arrays.asList("https://test.com"),
                Arrays.asList(new Tag(1, "test1"), new Tag(2, "test2")),
                "available"
        );
        petStoreHelper.createPet(dog);
    }

    @Then("validate status code {int}")
    public void validateStatusCode(int expectedStatusCode){
        petStoreHelper.validateStatusCode(expectedStatusCode);
    }

    @Given("user deletes pet with id {int}")
    public void deletePet(int id){
        petStoreHelper.deletePet(id);
    }
}
