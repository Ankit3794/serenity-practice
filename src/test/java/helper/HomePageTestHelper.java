package helper;

import net.thucydides.core.annotations.Step;
import pageobjects.HomePage;

public class HomePageTestHelper {

    HomePage homePage;

    @Step
    public void openApplication(){
        homePage.open();
    }

    @Step
    public void verifyBuiltinMethod(){
        homePage.inputFields("test");
    }
}
