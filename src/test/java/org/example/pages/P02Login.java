package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02Login {

    public P02Login()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-login")
    public WebElement loginLink;

    @FindBy(className = "email")
    public WebElement emailM;

    @FindBy(className = "password")
    public WebElement passwordM;

    @FindBy(className = "login-button")
    public WebElement loginBtn;

    public void loginSteps(String email, String password)
    {
        emailM.sendKeys(email);
        passwordM.sendKeys(password);
    }

    @FindBy(className = "ico-account")
    public WebElement myAccountM;

    @FindBy(className = "message-error")
    public  WebElement errorMsg;

}

