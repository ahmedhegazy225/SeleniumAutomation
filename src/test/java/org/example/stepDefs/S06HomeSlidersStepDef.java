package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03HomePage;
import org.testng.asserts.SoftAssert;

public class S06HomeSlidersStepDef {

    P03HomePage sliders = new P03HomePage();
    SoftAssert soft = new SoftAssert();

    @Given("click on first slide nokia")
    public void firstSlide()
    {
        sliders.firstSlide.click();
    }

    @Then("should navigate to nokia Page")
    public void shouldNavigateToNokiaPage()
    {
        String expectedResult = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualResult = Hooks.driver.getCurrentUrl();

        //Assertions
        soft.assertEquals(actualResult,expectedResult,"Assertion of Nokia URL");
        soft.assertAll();
    }

    @Given("click on second slide Iphone")
    public void clickOnSecondSlideIphone()
    {
        sliders.secondSlide.click();
    }

    @Then("should navigate to Iphone Page")
    public void shouldNavigateToIphonePage()
    {
        String expectedResult = "https://demo.nopcommerce.com/iphone-6";
        String actualResult = Hooks.driver.getCurrentUrl();

        //Assertions
        soft.assertEquals(actualResult,expectedResult,"Assertion of Iphone URL");
        soft.assertAll();
    }
}
