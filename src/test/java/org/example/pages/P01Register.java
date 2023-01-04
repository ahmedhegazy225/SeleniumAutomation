package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01Register {

    public P01Register(){
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-register")
    public WebElement registerLink;

    @FindBy(id = "gender-male")
    public static WebElement genderSelect;
    @FindBy(id = "FirstName")
    public static WebElement firstNameM;
    @FindBy(id = "LastName")
    public static WebElement lastNameM;


    public static void firstLastNames(String firstName, String lastName) {
        firstNameM.sendKeys(firstName);
        lastNameM.sendKeys(lastName);
    }
    public static void selectBirthInfo() {
        WebElement birthDay = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(birthDay);
        select.selectByVisibleText("24");

        WebElement birthMonth = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        Select select1 = new Select(birthMonth);
        select1.selectByVisibleText("June");


        WebElement birthYear = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        Select select2 = new Select(birthYear);
        select2.selectByVisibleText("1996");
    }
    @FindBy(id = "Email")
    public static WebElement emailM;

    @FindBy(id = "Password")
    public static WebElement passwordM;

    @FindBy(id = "ConfirmPassword")
    public static WebElement passwordConfM;

    public static void passwordAndConf(String password, String passwordConf) {
        passwordM.sendKeys(password);
        passwordConfM.sendKeys(passwordConf);
    }
    @FindBy(id = "register-button")
    public static WebElement regBtnM;

    @FindBy(className = "result")
    public static WebElement regMsgM;

}
