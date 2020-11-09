package com.hiyar1.step_definitions;

import com.hiyar1.pages.LandingPage;
import com.hiyar1.pages.LoginPage;
import com.hiyar1.utils.BrowserUtils;
import com.hiyar1.utils.ConfigurationReader;
import com.hiyar1.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage=new LoginPage();
    LandingPage landingPage=new LandingPage();
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url= ConfigurationReader.getProperty("qa2_url");
        Driver.getDriver().get(url);

    }

    @When("I login as a Librarian")
    public void i_login_as_a_librarian() {
        String userName=ConfigurationReader.getProperty("Lib22_user");
        String passWord=ConfigurationReader.getProperty("Lib22_pass");
        loginPage.usernameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(passWord);
        loginPage.signInButton.click();
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expected="dashboard";

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));

        String actual=Driver.getDriver().getCurrentUrl();


        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();

    }

    @When("I login as a student")
    public void iLoginAsAStudent() {
        String userName=ConfigurationReader.getProperty("student_user");
        String passWord=ConfigurationReader.getProperty("student_pass");
        loginPage.usernameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(passWord);
        loginPage.signInButton.click();
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {
        String expected="books";


        wait.until(ExpectedConditions.urlContains(expected));

        String actual=Driver.getDriver().getCurrentUrl();


        Assert.assertTrue(actual.contains(expected));
        Driver.closeDriver();
    }
    @When("I enter username {string}")
    public void i_enter_username(String userName) {


        loginPage.usernameInput.sendKeys(userName);
    }




    @When("I enter password {string}")
    public void i_enter_password(String passWord) {

        loginPage.passwordInput.sendKeys(passWord);
    }
    @When("Click the sign in button")
    public void click_the_sign_in_button() throws InterruptedException {
        loginPage.signInButton.click();
        Thread.sleep(3000);
    }

    @And("there should be {int} users")
    public void thereShouldBeUses(int expectedNumber) throws InterruptedException {



        Thread.sleep(3000);

        String expected=String.valueOf(expectedNumber);
        String actualNumber=landingPage.userCount.getText();

        Assert.assertEquals("message",actualNumber,expected);

    }

    @When("I login using {string}and {string}")
    public void iLoginUsingAnd(String userName, String passWord) {


        loginPage.usernameInput.sendKeys(userName);

        loginPage.passwordInput.sendKeys(passWord);
            loginPage.signInButton.click();


    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String expectedAccountUsername) {

        BrowserUtils.waitForVisibility(landingPage.accountUserName,5);
        String actualUsername=landingPage.accountUserName.getText();

        Assert.assertEquals("Message failed!!" ,expectedAccountUsername,actualUsername);

    Driver.closeDriver();


    }
}
