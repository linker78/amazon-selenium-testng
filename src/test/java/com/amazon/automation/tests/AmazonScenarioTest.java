package com.amazon.automation.tests;

import com.amazon.automation.base.BaseTest;
import com.amazon.automation.pages.AmazonHomePage;
import com.amazon.automation.pages.AmazonSignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonScenarioTest extends BaseTest {
    @Test
    public void searchProductScenario() {
        driver.get("https://www.amazon.com");
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.enterSearchTerm("wireless mouse");
        homePage.clickSearch();
        String results = homePage.getResultsText();
        Assert.assertTrue(results.toLowerCase().contains("wireless mouse"), "Search results do not contain 'wireless mouse'");
    }

    @Test
    public void signInScenario() {
        driver.get("https://www.amazon.com/ap/signin");
        AmazonSignInPage signInPage = new AmazonSignInPage(driver);
        signInPage.enterEmail("test@example.com");
        signInPage.clickContinue();
        signInPage.enterPassword("dummyPassword");
        signInPage.clickSignIn();
        // Add assertion for failed login (since credentials are dummy)
        Assert.assertTrue(driver.getPageSource().contains("There was a problem"), "Expected error message not found");
    }
}
