package helper.amazon;

import net.thucydides.core.annotations.Step;
import pageobjects.amazon.AmazonProductPage;

public class AmazonProductPageHelper {
    AmazonProductPage amazonProductPage;

    @Step
    public void selectProductSize(){
        amazonProductPage.selectSize();
    }

    @Step
    public void addProductToCart() throws InterruptedException {
        amazonProductPage.clickOnAddToCart();
    }
}
