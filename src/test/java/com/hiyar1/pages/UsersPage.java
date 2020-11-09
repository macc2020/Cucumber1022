package com.hiyar1.pages;

import com.hiyar1.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends BasePage {

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(name = "tbl_users_length")
    public WebElement showRecordsDropdown;

    @FindBy(tagName = "th")
    public List<WebElement> tableHeader;


    @FindBy(xpath = "//a[@href='javascript:void(0)']")
    public WebElement editUserButton;
    @FindBy(xpath = "//h5[@class= 'modal-title']")
    public WebElement editUserInformation;

    @FindBy(xpath = "//tr/td[1]")
    public List<WebElement> deneme2;





}
