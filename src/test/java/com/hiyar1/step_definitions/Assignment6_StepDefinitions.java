package com.hiyar1.step_definitions;


import com.hiyar1.pages.UsersPage;
import com.hiyar1.utils.BrowserUtils;
import com.hiyar1.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Assignment6_StepDefinitions {
UsersPage usersPage=new UsersPage();



    @When("I clicks on Edit User button")
    public void i_clicks_on_edit_user_button() {
        BrowserUtils.wait(4);
      usersPage.editUserButton.click();

    }



    @Then("Edit User Information page opens")
    public void edit_user_information_page_opens() {

        BrowserUtils.wait(3);
        String expected="Edit User Information";
        System.out.println(expected);
        String actual= usersPage.editUserInformation.getText();

        System.out.println(actual);
        Assert.assertEquals("FAILED!!!",expected,actual);

        Driver.closeDriver();

    }

}
