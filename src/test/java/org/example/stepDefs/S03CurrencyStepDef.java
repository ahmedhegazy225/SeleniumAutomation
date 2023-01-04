package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class S03CurrencyStepDef {

    P03HomePage currency = new P03HomePage();
    SoftAssert soft = new SoftAssert();


    @When("user select euro option")
    public void selectEuro()
    {
        WebElement currencyList =Hooks.driver.findElement(By.id("customerCurrency"));
        Select select = new Select(currencyList);
        select.selectByVisibleText("Euro");
    }

    @Then("euro is applied to all products")
    public void euroApplied() {
        for (int i = 0; i < currency.prices().size(); i++) {

            String value = currency.prices().get(i).getText();
            System.out.println(value);

            //Assertions
            soft.assertTrue(value.contains("€"));
            System.out.println("AssertionCurrency");
        }
    }
}
