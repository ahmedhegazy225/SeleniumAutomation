package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03HomePage;
import org.testng.asserts.SoftAssert;

public class S08WishListStepDef {

    P03HomePage wishList = new P03HomePage();
    SoftAssert soft = new SoftAssert();

    @Given("user press on wishlist Button")
    public void WishListBtn() throws InterruptedException {
        wishList.wishListBtn.click();

        Thread.sleep(3000);
    }

    @Then("the success Msg will display")
    public void theSuccessMsgWillDisplay() throws InterruptedException {
        soft.assertTrue(wishList.notificationMsg.isDisplayed());
        soft.assertAll();

        String color = wishList.notificationMsg.getCssValue("background-color");
        System.out.println("color "+color);
        soft.assertEquals("rgba(75,176,122)".equals(color),true);
        System.out.println("AssertionNotificationMsg");
        Thread.sleep(3000);
    }

    @And("User will open wishlist page")
    public void userWillOpenWishlistPage() throws InterruptedException {
        wishList.wishListLink.click();

        Thread.sleep(3000);
    }

    @And("The Qty is added correctly")
    public void theQtyIsAddedCorrectly()
    {
        String quantity = wishList.qty.getAttribute("value");
        System.out.println("The Quantity of your items is " +quantity);
        soft.assertNotEquals("0",quantity);
    }
}
