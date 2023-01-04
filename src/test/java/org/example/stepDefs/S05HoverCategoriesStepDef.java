package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class S05HoverCategoriesStepDef {

    P03HomePage hover = new P03HomePage();
    Actions actions = new Actions(Hooks.driver);
    public static int selectedCategory;

    int selectSubCategory;

    List<WebElement> subCategoryLinks;

    SoftAssert soft = new SoftAssert();

    String locator;

    String SubCategoryText;
    String MainCategoryText;

    @Given("select one of three main category")
    public void selectMainCategory() throws InterruptedException {
        int count = hover.mainCategory.size();
        int min = 0;
        int max = count - 1;
        selectedCategory = (int) Math.floor(Math.random() * ( max - min + 1 ) + min);
        actions.moveToElement(hover.mainCategory.get(selectedCategory)).perform();
        MainCategoryText = hover.mainCategory.get(selectedCategory).getText();
        System.out.println("Main category is selected:   " + MainCategoryText);

        Thread.sleep(3000);
    }

    @And("User can select on of sub category if exist")
    public void userCanSelectOnOfSubCategoryIfExist()
    {
        selectedCategory = selectedCategory + 1;
        locator = "(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li";
        subCategoryLinks = Hooks.driver.findElements(By.xpath(locator));
    }

    @Then("sub-category title equals the one you get it while selecting random sub-category")
    public void subCategoryTitleIsEqualTheOneYouGetItWhileSelectingRandomSubCategory() throws InterruptedException {
        if (selectedCategory > 0 && selectedCategory <= 3) {
            int count = subCategoryLinks.size();
            int min = 0;
            int max = count - 1;
            selectSubCategory = (int) Math.floor(Math.random() * ( max - min + 1 ) + min);
            actions.moveToElement(subCategoryLinks.get(selectSubCategory)).perform();
            SubCategoryText = subCategoryLinks.get(selectSubCategory).getText();
            System.out.println("Sub category is selected:   " + SubCategoryText);

            Thread.sleep(2000);

            subCategoryLinks.get(selectSubCategory).click();

            //Assertion
            soft.assertEquals(hover.pgTitle.getText().toLowerCase().trim(), SubCategoryText.toLowerCase().trim());
            soft.assertAll();

        } else {
            hover.mainCategory.get(selectedCategory - 1).click();

            //Assertion
            soft.assertEquals(hover.pgTitle.getText().toLowerCase().trim(), MainCategoryText.toLowerCase().trim());
            soft.assertAll();
        }
    }
}
