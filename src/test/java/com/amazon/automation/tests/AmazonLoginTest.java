package com.amazon.automation.tests;

import com.amazon.automation.base.BaseTest;
import com.amazon.automation.pages.AmazonSignInPage;
import com.amazon.automation.pages.AmazonHomePage;
import com.amazon.automation.utils.Locators;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class AmazonLoginTest extends BaseTest {
    private String username;
    private String password;
    private String baseUrl;

    @BeforeClass
    public void loadConfig() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/config.properties"));
        username = props.getProperty("username");
        password = props.getProperty("password");
        baseUrl = props.getProperty("baseUrl");
    }

    @Test
    public void testLogin() {
        driver.get(baseUrl);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.handleContinueShoppingPopup();
        // Hover over 'Account & Lists' to open dropdown (updated locator)
        Actions actions = new Actions(driver);
        WebElement accountLists = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(Locators.ACCOUNT_LISTS_DROPDOWN));
        actions.moveToElement(accountLists).perform();
        // Click the yellow 'Sign in' button in the dropdown
        WebElement signInButton = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(Locators.SIGNIN_DROPDOWN_BUTTON));
        signInButton.click();
        // Wait for the email input field to be visible before entering email
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(Locators.EMAIL_FIELD));
        AmazonSignInPage signInPage = new AmazonSignInPage(driver);
        signInPage.enterEmail(username);
        signInPage.clickContinue();
        signInPage.enterPassword(password);
        signInPage.clickSignIn();
        // Handle 'Add mobile number' screen if it appears
        try {
            WebElement notNowLink = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(Locators.NOT_NOW_LINK));
            notNowLink.click();
        } catch (Exception ignored) {
            // 'Not now' link not present, continue
        }
        // Wait for page to load and check for successful login 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean loggedIn = wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("/youraccount"),
            ExpectedConditions.presenceOfElementLocated(By.id("nav-link-accountList"))
        ));
        Assert.assertTrue(loggedIn, "Login was not successful or user account not detected.");
    }
}
