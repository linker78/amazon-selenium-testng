package com.amazon.automation.tests;

import com.amazon.automation.base.BaseTest;
import com.amazon.automation.pages.AmazonHomePage;
import com.amazon.automation.pages.AmazonProductPage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartScenarioTest extends BaseTest {
    private String baseUrl;

    @BeforeClass
    public void loadConfig() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/config.properties"));
        baseUrl = props.getProperty("baseUrl");
    }

    @Test
    public void addProductToCartAndVerify() {
        driver.get(baseUrl);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.handleContinueShoppingPopup();
        homePage.enterSearchTerm("wireless mouse");
        homePage.clickSearch();
        homePage.selectFirstProduct();
        AmazonProductPage productPage = new AmazonProductPage(driver);
        productPage.clickAddToCart();
        boolean added = productPage.isAddedToCart();
        Assert.assertTrue(added, "Product was not added to cart successfully");
    }
}
