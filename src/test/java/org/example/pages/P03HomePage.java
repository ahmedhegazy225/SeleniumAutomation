package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03HomePage {

    public P03HomePage()
    {
        PageFactory.initElements(Hooks.driver,this);
    }

    //CurrencyFeature
    public List<WebElement> prices()
    {
        List<WebElement> prices = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        return prices;
    }

    //SearchFeature
    @FindBy(id = "small-searchterms")
    public WebElement searchBar;

    @FindBy(className = "search-box-button")
    public WebElement searchBtn;

    @FindBy(css = "h2[class=\"product-title\"] a")
    public List<WebElement> productTitle;

    @FindBy(className = "picture")
    public WebElement productPic;

    @FindBy(className = "sku")
    public WebElement skuProduct;

    //HoverCategoriesFeature
    @FindBy(css = "ul[class=\"top-menu notmobile\"]>li>a[href] ")
    public List<WebElement> mainCategory;

    @FindBy(className = "page-title")
    public WebElement pgTitle;

    @FindBy(id = "nivo-slider")
    public WebElement firstSlide;

    @FindBy(xpath = "//*[@id=\"nivo-slider\"]/a[1]")
    public  WebElement secondSlide;

    @FindBy(className= "facebook")
    public WebElement facebook;

    @FindBy(className = "twitter")
    public WebElement twitter;

    @FindBy(className = "rss")
    public  WebElement rss;

    @FindBy(className = "youtube")
    public  WebElement youtube;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]")
    public WebElement wishListBtn;

    @FindBy (xpath = "//*[@id=\"bar-notification\"]/div")
    public  WebElement notificationMsg;



    @FindBy(className = "wishlist-label")
    public  WebElement wishListLink;

    @FindBy(className = "qty-input")
    public  WebElement qty;

}
