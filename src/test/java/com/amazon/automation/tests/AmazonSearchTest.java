package com.amazon.automation.tests;

import com.amazon.automation.base.BaseTest;
import com.amazon.automation.pages.AmazonHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearchTest extends BaseTest {
    @Test
    public void testAmazonSearch() {
        driver.get("https://www.amazon.com");
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.enterSearchTerm("laptop");
        homePage.clickSearch();
        String results = homePage.getResultsText();
        Assert.assertTrue(results.contains("laptop"), "Search results do not contain 'laptop'");
    }
}
