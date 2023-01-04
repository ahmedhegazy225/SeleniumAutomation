package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02Login;
import org.testng.asserts.SoftAssert;

public class S02LoginStepDef {
    P02Login p02Login = new P02Login();
    SoftAssert soft = new SoftAssert();

    @Given("user go to login page")
    public void navigateLogin()
    {
        p02Login.loginLink.click();
    }

    @When("user login with {string} and {string}")
    public void userLoginWithAnd(String email, String password)
    {
        p02Login.loginSteps(email,password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton()
    {
        p02Login.loginBtn.click();
    }


    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully()
    {
        //Assertions
        String ActualResult= p02Login.myAccountM.getText();
        String ExpectedResult = "My account";
        soft.assertEquals(ActualResult,ExpectedResult);
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");

    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {

        //Assertions
        String ExpectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String ActualResult= p02Login.errorMsg.getText();
        soft.assertEquals(ActualResult,ExpectedResult);
        System.out.println("AssertionErrorMsg");

        String color = p02Login.errorMsg.getCssValue("color");
        System.out.println("color "+color);
        soft.assertEquals("rgba(228, 67, 75, 1)".equals(color),true);
        System.out.println("AssertionErrorMsgColor");


        soft.assertAll();


    }

}
