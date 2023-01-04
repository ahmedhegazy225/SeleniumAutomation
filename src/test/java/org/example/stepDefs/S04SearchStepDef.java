package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03HomePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Locale;

public class S04SearchStepDef {

    P03HomePage search = new P03HomePage();
    SoftAssert soft = new SoftAssert();

    @When("Write product {string}")
    public void writeProduct(String productName)
    {
        search.searchBar.sendKeys(productName);
    }

    @And("press search button")
    public void pressSearchButton()
    {
        search.searchBtn.click();
    }

    @Then("search results contains {string}")
    public void searchResultsContains(String productName) throws InterruptedException {
        boolean visible = true;
        int count = search.productTitle.size();

        System.out.println("the count is " + count + " the product name is " + productName);


        for (int i = 0; i < count - 1; i++) {
            if (!(search.productTitle.get(i).getText().toLowerCase(Locale.ROOT).contains(productName.toLowerCase()))) {
                visible = false;
                break;
            }

            Thread.sleep(2000);

            //Assertions
            soft.assertTrue(visible);
            soft.assertAll();
            System.out.println("Results Contains Name");

        }
    }

    @Given("Write product {string} using Sku")
    public void writeProductUsingSku(String skuSerial)
    {
        search.searchBar.sendKeys(skuSerial);
    }

    @And("press search button after search")
    public void pressSearchButtonAfterSearch()
    {
        search.searchBtn.click();
    }

    @Then("search results contains {string} using Sku")
    public void searchResultsContainsUsingSku(String skuSerial) throws InterruptedException {
        boolean visible = true;
        search.productPic.click();
        System.out.println("Sku Serial is : " + search.skuProduct.getText());

        if(!(search.skuProduct.getText().contains(skuSerial))) {
            visible = false;
        }

        Thread.sleep(2000);

        //Assertions
        Assert.assertTrue(visible);
        System.out.println("Results Contains Sku");


    }

 }

