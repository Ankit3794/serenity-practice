package stepdefs;

import helper.HomePageTestHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Shared;

public class HomePageSteps {
    @Shared
    HomePageTestHelper homePageTestHelper;
    @Given("open demo application")
    public void open_demo_application() {
        homePageTestHelper.openApplication();
    }
    @Then("try with built-in methods")
    public void try_with_built_in_methods() {
        homePageTestHelper.verifyBuiltinMethod();
    }
}
