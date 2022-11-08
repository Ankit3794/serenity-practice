package pageobjects.amazon;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonProductPage extends PageObject {

    @FindBy(id = "native_dropdown_selected_size_name")
    WebElementFacade sizeDropdown;

    @FindBy(id = "nav-cart-count")
    WebElementFacade cartCountText;

    @FindBy(css = "input#add-to-cart-button")
    WebElementFacade addToCartBtn;

    @FindBy(css = "input#buy-now-button")
    WebElementFacade buyNowBtn;
    public void selectSize(){
        sizeDropdown.selectByIndex(1);
    }

    public void clickOnAddToCart() throws InterruptedException {
        buyNowBtn.waitUntilClickable();
        addToCartBtn.click();
        Assert.assertEquals("1", cartCountText.getText());
    }
}
