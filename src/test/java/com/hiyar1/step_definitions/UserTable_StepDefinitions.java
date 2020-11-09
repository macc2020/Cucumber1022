package com.hiyar1.step_definitions;

import com.hiyar1.pages.UsersPage;
import com.hiyar1.utils.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import java.util.List;

public class UserTable_StepDefinitions {

        UsersPage userpage = new UsersPage();
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String>expectedColumnNames) {
       System.out.println("expectedColumnNames = " + expectedColumnNames);
        BrowserUtils.wait(4);

        List<String>actualColumnNames = BrowserUtils.getElementsText(userpage.tableHeader);


        Assert.assertEquals(expectedColumnNames,actualColumnNames);
    }


}
