package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class S07FollowUsStepDef {

    P03HomePage followUs = new P03HomePage();
    SoftAssert soft = new SoftAssert();
    ArrayList <String> tabs;


    @Given("user click on {string} link")
    public void userClicksLink(String page)
    {
        switch (page){case "facebook":
            followUs.facebook.click();
                break;
            case "twitter":
                followUs.twitter.click();
                break;
            case "rss":
                followUs.rss.click();
                break;
            case "youtube":
                followUs.youtube.click();
            default:
        }
    }


    @When("user opens new tab")
    public void userOpensNewTab() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Thread.sleep(2000);

    }

    @And("user can switch between tabs")
    public void userCanSwitchBetweenTabs() throws InterruptedException
    {
        Hooks.driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " + Hooks.driver.getCurrentUrl());

        Thread.sleep(2000);

        Hooks.driver.switchTo().window(tabs.get(0));
        System.out.println("tab 0:  " + Hooks.driver.getCurrentUrl());

        Thread.sleep(2000);

        Hooks.driver.switchTo().window(tabs.get(1));

        Thread.sleep(2000);
    }

    @Then("{string} is opened in new tab")
    public void isOpenedInNewTab(String url)
    {
        //Assertions
        String actualResult = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualResult,url);
        System.out.println("URL is :"+ actualResult);
    }
}
