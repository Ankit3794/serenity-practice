package pageobjects.amazon;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AmazonHomePage extends PageObject {

    @FindBy(id = "twotabsearchtextbox")
    WebElementFacade searchBtnInput;

    @FindBy(xpath = "//div[@data-component-type='s-search-result'][not(.//span[contains(@class,'s-sponsored-label-info-icon')])]//h5")
    List<WebElementFacade> searchResultHeaders;

    @FindBy(xpath = "(//div[@data-component-type='s-search-result'][not(.//span[contains(@class,'s-sponsored-label-info-icon')])]//h2//a[contains(@class,'link-normal')])[1]")
    WebElementFacade firstProductLink;

    @FindBy(id = "productTitle")
    WebElementFacade productTitleHeader;

    public void waitForPageToLoad(){
        waitForCondition().until(ExpectedConditions.elementToBeClickable(searchBtnInput));
    }

    public void searchProduct(String product){
        searchBtnInput.typeAndEnter(product);
        waitForCondition().until(ExpectedConditions.elementToBeClickable(firstProductLink));
        searchResultHeaders.forEach(sh -> Assert.assertTrue(sh.getText().toLowerCase().contains(product.toLowerCase())));
    }

    public void clickOnFirstProduct(){
        firstProductLink.click();
        for(String w: getDriver().getWindowHandles()){
            getDriver().switchTo().window(w);
        }
    }
}
