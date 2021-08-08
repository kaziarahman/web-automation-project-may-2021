package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    @FindBy(id="createAccountSubmit")
    private WebElement createAccountButton;


    public void clickOncreateAccountButton(){
        createAccountButton.click();
    }

}
