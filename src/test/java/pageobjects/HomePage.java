package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webelements.Checkbox;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @Managed
    WebDriver driver;

    @FindBy(id = "vfb-5")
    WebElementFacade firstNameInput;

    @FindBy(id = "vfb-7")
    WebElementFacade lastNameInput;

    @FindBy(id = "vfb-20-0")
    WebElementFacade coursesInterestElement;

    @FindBy(id = "vfb-16-hour")
    WebElementFacade hourDropdown;

    Checkbox coursesInterestChkBox = new Checkbox(coursesInterestElement);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void inputFields(String name) {
        firstNameInput.type(name);
        findBy("//input[@id='vfb-5']").clear();
        $("//input[@id='vfb-5']").type(name + " added with $");

        lastNameInput.type(name + " last");

        System.out.println(coursesInterestChkBox.isChecked());
        coursesInterestChkBox.setChecked(true);
        Assert.assertTrue(coursesInterestChkBox.isChecked());

        hourDropdown.selectByIndex(1);
        System.out.println(hourDropdown.getFirstSelectedOptionValue());
        hourDropdown.selectByVisibleText("03");

        $("//button[contains(text(),'Alert and Popup')]").click();

        // alert
        $("//button[@name='alertbox']").click();
        System.out.println(getAlert().getText());
        getAlert().accept();

        //confirm alert
        $("//button[@name='confirmalertbox']").click();
        System.out.println(getAlert().getText());
        getAlert().accept();

        // prompt
        $("//button[@name='promptalertbox1234']").click();
        System.out.println(getAlert().getText());
        getAlert().sendKeys("prompt text box");

    }


}
