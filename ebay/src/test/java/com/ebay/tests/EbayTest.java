package com.ebay.tests;

import com.pnt.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class EbayTest extends TestBase {
    private static final Logger logger = Logger.getLogger(EbayTest.class);

    //if i used priority its run first. its start from '0'
    @Test(priority = 0)
    public void validatedUserCanSearchForItemsInEbay() {
        logger.info("browser opened and ebay.com launched");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "url didn't match");
        logger.info("ebay homepage url has validated");


        WebElement ebayLogo = driver.findElement(By.id("gh-l-h1"));
        Assert.assertTrue(ebayLogo.isDisplayed(), "result is not true");
        logger.info("ebay logo has been displayed");


        sleepFor(5);

        typeOnXpath("//input[@id='gh-ac']", "Java Books");
        logger.info("typed java books in the search bar");


        clickOnId("gh-btn");
        logger.info("search button has been clicked");


        WebElement result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String log = result.getText();
        // Assert.assertTrue(log.contains("Java Books"), "log didn't contain Java Books");
        logger.info(log + " : has been displayed");
    }


    @Test(priority = 1)
    public void validateUserBeingAbleToChooseOptionFromSearchDropDown() {
        logger.info("browser opened and ebay.com launched");

        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText("Art");
    }


    @Test
    public void validateUserBeingAbleToHandleDropDownOptions() {

        List<WebElement> dropdownList = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        System.out.println(dropdownList.size());
        for (WebElement webElement : dropdownList) {
            System.out.println(webElement.getText());
            // System.out.println(dropdownList.get(i).getAttribute("value"));
        }
    }

    // if i used enabled=false, that means test case not gonna be running, ignored.
    @Test(enabled = false)
    public void validateUserBeingAbleToChooseOptionFromMouseHover() {
        WebElement motors = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();
        driver.findElement(By.linkText("Classics")).click();
    }


    @Test
    public void userShouldBeAbleToScrollDown() {
        sleepFor(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        sleepFor(2);
    }


    @Test
    public void userShouldBeAbleToScrollDownToElement() {
        logger.info("browser opened and ebay.com launched");

        WebElement element = driver.findElement(By.linkText("About eBay"));
        sleepFor(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        sleepFor(2);
    }
}
