package stepdefs.amazon;

import helper.amazon.AmazonCartPageHelper;
import helper.amazon.AmazonProductPageHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;

public class AmazonCartPageSteps {
    @Shared
    AmazonCartPageHelper amazonCartPageHelper;

    @When("user navigates to Cart page")
    public void user_navigates_to_cart_page(){
        amazonCartPageHelper.navigateToCartPage();
    }

    @Then("user validates whether above added product is added in Cart")
    public void user_validates_whether_above_added_product_is_added_in_cart() {
        amazonCartPageHelper.printCartAmount();
    }

    @Then("user exits from the application")
    public void user_exits_from_the_application() {
        amazonCartPageHelper.closeApplication();
    }
}
