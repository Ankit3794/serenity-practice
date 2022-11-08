package helper.amazon;

import net.thucydides.core.annotations.Step;
import pageobjects.amazon.AmazonCartPage;
import pageobjects.amazon.AmazonProductPage;

public class AmazonCartPageHelper {
    AmazonCartPage amazonCartPage;

    @Step
    public void navigateToCartPage(){
        amazonCartPage.navigateToCartPage();
    }

    @Step
    public void printCartAmount(){
        amazonCartPage.getCartValue();
    }

    @Step
    public void closeApplication(){
        amazonCartPage.closeApplication();
    }
}
