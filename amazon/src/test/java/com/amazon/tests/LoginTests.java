package com.amazon.tests;

import com.amazon.data.DataProvidersForTest;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import com.pnt.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    private HomePage homePage;
    private SignInPage signInPage;
    private CreateAccountPage createAccountPage;

    @BeforeMethod
    public void setUpPOM() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        createAccountPage = PageFactory.initElements(driver,CreateAccountPage.class);
    }


    @Test(dataProviderClass = DataProvidersForTest.class, dataProvider = "getUserForCreateAccountTest",
            groups ="regression")

    public void validateUserCanCreateAccount(String userName, String email, String password){

        homePage.clickOnSignInButton();
        signInPage.clickOncreateAccountButton();

        createAccountPage.validateTheFieldLabelsAreDisplayed();

        createAccountPage.typeInNameField(userName);
        createAccountPage.typeInEmailField(email);
        createAccountPage.typeInPasswordField(password);
        createAccountPage.typeInReEnterPasswordField(password);


        sleepFor(3);
    }

}
