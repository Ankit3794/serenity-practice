package helper.amazon;

import net.thucydides.core.annotations.Step;
import pageobjects.amazon.AmazonHomePage;

public class AmazonHomePageHelper {
    AmazonHomePage homePage;

    @Step
    public void openApplication(){
        homePage.openUrl("https://amazon.in");
        homePage.waitForPageToLoad();
    }

    @Step
    public void searchProduct(String product){
        homePage.searchProduct(product);
    }

    @Step
    public void clickFirstProduct(){
        homePage.clickOnFirstProduct();
    }
}
