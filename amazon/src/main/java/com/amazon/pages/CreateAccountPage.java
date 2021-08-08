package com.amazon.pages;

import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class CreateAccountPage {
    private static Logger LOGGER = Logger.getLogger(CreateAccountPage.class);

    @FindBy(id="ap_customer_name")
    private WebElement nameField;

    @FindBy(id="ap_email")
    private WebElement emailField;

    @FindBy(id="ap_password")
    private WebElement passwordField;

    @FindBy(id="ap_password_check")
    private WebElement reEnterpasswordField;

    @FindBy(xpath = "//label[@for='ap_customer_name']")
    private WebElement nameLabel;

    @FindBy(xpath = "//label[@for='ap_email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//label[@for='ap_password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//label[@for='ap_password_check']")
    private WebElement reEnterPasswordLabel;


    public void validateTheFieldLabelsAreDisplayed(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(nameLabel.getText(),"Your name");
        ExtentTestManager.log("name label is displayed", LOGGER);

        softAssert.assertEquals(emailLabel.getText(),"Email");
        ExtentTestManager.log("email label is displayed", LOGGER);

        softAssert.assertEquals(passwordLabel.getText(),"Password");
        ExtentTestManager.log("password label is displayed", LOGGER);

        softAssert.assertEquals(reEnterPasswordLabel.getText(),"Re-enter password");
        ExtentTestManager.log("reEnter password label is displayed", LOGGER);

        softAssert.assertAll();

}

    public void FillAllTheFieldLabels() {
        typeInEmailField("test user");
        typeInNameField("test user");
        typeInPasswordField("test user");
        typeInReEnterPasswordField("test user");
    }




    public void typeInNameField(String data){
        nameField.sendKeys(data);
    }

    public void typeInEmailField(String data){
        emailField.sendKeys(data);
    }

    public void typeInPasswordField(String data){
        passwordField.sendKeys(data);
    }

    public void typeInReEnterPasswordField(String data){
        reEnterpasswordField.sendKeys(data);
    }


}
