package stepdefs.amazon;

import helper.amazon.AmazonHomePageHelper;
import helper.amazon.AmazonProductPageHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Shared;

public class AmazonProductPageSteps {
    @Shared
    AmazonProductPageHelper amazonProductPageHelper;

    @When("user adds first product from the search result to cart")
    public void user_adds_first_product_from_the_search_result_to_cart() throws InterruptedException {
        amazonProductPageHelper.selectProductSize();
        amazonProductPageHelper.addProductToCart();
    }
}
