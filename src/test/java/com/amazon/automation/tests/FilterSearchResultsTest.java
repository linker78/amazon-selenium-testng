package com.amazon.automation.tests;

import com.amazon.automation.base.BaseTest;
import com.amazon.automation.pages.AmazonHomePage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class FilterSearchResultsTest extends BaseTest {
    private String baseUrl;

    @BeforeClass
    public void loadConfig() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/config.properties"));
        baseUrl = props.getProperty("baseUrl");
    }

    @Test
    public void filterByBrandAndVerifyResults() {
        driver.get(baseUrl);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.handleContinueShoppingPopup();
        homePage.enterSearchTerm("laptop");
        homePage.clickSearch();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for filter sidebar
        wait.until(ExpectedConditions.visibilityOfElementLocated(com.amazon.automation.utils.Locators.FILTER_SIDEBAR));
        // Click on a brand filter (e.g., HP) using locator from Locators
        WebElement hpBrand = driver.findElement(com.amazon.automation.utils.Locators.brandFilterCheckbox("HP"));
        hpBrand.click();
        // Wait for results to refresh
        wait.until(ExpectedConditions.invisibilityOfElementLocated(com.amazon.automation.utils.Locators.LOADING_SPINNER));
        // Verify all results contain 'HP'
        List<WebElement> titles = driver.findElements(com.amazon.automation.utils.Locators.PRODUCT_TITLE_SPANS);
        boolean allHp = titles.stream().allMatch(e -> e.getText().toLowerCase().contains("hp"));
        Assert.assertTrue(allHp, "Not all results are HP laptops after applying the HP brand filter.");
    }
}
