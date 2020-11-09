package com.hiyar1.pages;

import com.hiyar1.utils.ConfigurationReader;
import com.hiyar1.utils.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




    @FindBy(id="inputEmail")
    public WebElement usernameInput;


    @FindBy(id="inputPassword")
    public WebElement passwordInput;

    @FindBy( xpath= "//button[.='Sign in']")
    public WebElement signInButton;



   public void login() {
        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");


        usernameInput.sendKeys(usernameValue);
        passwordInput.sendKeys(passwordValue);
        signInButton.click();
    }
    public void login(String usernameValue, String passwordValue) {
        usernameInput.sendKeys(usernameValue);
        passwordInput.sendKeys(passwordValue, Keys.ENTER);}
}
