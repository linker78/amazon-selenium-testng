package com.amazon.automation.tests;

import com.amazon.automation.base.BaseTest;
import com.amazon.automation.pages.AmazonHomePage;
import com.amazon.automation.utils.Locators;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class WishlistFunctionalityTest extends BaseTest {
    private String baseUrl;

    @BeforeClass
    public void loadConfig() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/config.properties"));
        baseUrl = props.getProperty("baseUrl");
    }

    @Test
    public void addAndRemoveFromWishlist() {
        driver.get(baseUrl);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.handleContinueShoppingPopup();
        homePage.enterSearchTerm("laptop");
        homePage.clickSearch();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(Locators.FIRST_PRODUCT));
        firstProduct.click();
        // Click 'Add to List' (wishlist) button
        WebElement addToListBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_TO_WISHLIST_BUTTON));
        addToListBtn.click();
        // Wait for wishlist confirmation
        WebElement viewYourList = wait.until(ExpectedConditions.elementToBeClickable(Locators.VIEW_WISHLIST_LINK));
        viewYourList.click();
        // Verify product appears in wishlist
        boolean productInWishlist = driver.findElements(Locators.WISHLIST_ITEM).size() > 0;
        Assert.assertTrue(productInWishlist, "Product was not added to wishlist.");
        // Remove product from wishlist
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.DELETE_WISHLIST_ITEM_BUTTON));
        deleteBtn.click();
        // Verify removal
        boolean removed = driver.findElements(Locators.WISHLIST_ITEM).isEmpty();
        Assert.assertTrue(removed, "Product was not removed from wishlist.");
    }
}
