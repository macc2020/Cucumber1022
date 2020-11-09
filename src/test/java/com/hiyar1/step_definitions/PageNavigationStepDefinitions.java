package com.hiyar1.step_definitions;


import com.hiyar1.pages.LandingPage;
import com.hiyar1.pages.LoginPage;
import com.hiyar1.pages.UsersPage;
import com.hiyar1.utils.BrowserUtils;
import com.hiyar1.utils.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageNavigationStepDefinitions {

    LandingPage landingPage=new LandingPage();
    LoginPage loginPage=new LoginPage();

    Select select;
UsersPage usersPage=new UsersPage();

    @Given("Login as a Librarian")
    public void login_as_a_librarian() {
        String userName= ConfigurationReader.getProperty("Lib22_user");
        String passWord=ConfigurationReader.getProperty("Lib22_pass");
        loginPage.usernameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(passWord);
        loginPage.signInButton.click();


    }




    @When("I click on the {string} link")
    public void i_click_on_the_link(String link) {
        BrowserUtils.wait(5);

    switch (link.toLowerCase()){
        case "dashboard":
            landingPage.dashboardPageLink.click();
            break;
        case "users":
            landingPage.userPageLink.click();
            break;
        case "books":
            landingPage.booksPageLink.click();
            break;

    }
    }
    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {
        BrowserUtils.wait(3);

        select=new Select(usersPage.showRecordsDropdown);
        String actual=select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,String.valueOf(expected));//option 1
        Assert.assertEquals(expected+"",actual);//option 2

    }


    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String>options) {

       select = new Select(usersPage.showRecordsDropdown);
       List<WebElement>webElements=select.getOptions();
       List<String> actualText=BrowserUtils.getElementsText(webElements);
        Assert.assertEquals(options,actualText);
        System.out.println(actualText);

    }




}
