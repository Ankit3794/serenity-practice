package stepdefs.amazon;

import helper.amazon.AmazonHomePageHelper;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Shared;

public class AmazonHomePageSteps {

    @Shared
    AmazonHomePageHelper homePageHelper;
    @Given("user searches {string} in Amazon home page")
    public void user_searches_in_amazon_home_page(String string) {
        homePageHelper.openApplication();
        homePageHelper.searchProduct(string);
        homePageHelper.clickFirstProduct();
    }
}
