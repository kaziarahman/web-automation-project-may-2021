package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "(//span[@class='nav-action-inner'])[2]")
    private WebElement signInButton;

    public void typeOnSearchBar(String text) {
        searchTextBox.sendKeys(text);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }


}
