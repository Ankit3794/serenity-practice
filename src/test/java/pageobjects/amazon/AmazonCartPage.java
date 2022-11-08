package pageobjects.amazon;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class AmazonCartPage extends PageObject {

    @FindBy(id = "nav-cart-count-container")
    WebElementFacade cartBtn;

    @FindBy(id = "sc-subtotal-amount-buybox")
    WebElementFacade cartValueText;


    public void navigateToCartPage(){
        cartBtn.click();
    }

    public void getCartValue(){
        System.out.println(cartValueText.getText());
    }

    public void closeApplication(){
        getDriver().close();
        getDriver().quit();
    }
}
