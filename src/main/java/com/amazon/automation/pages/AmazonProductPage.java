package com.amazon.automation.pages;

import com.amazon.automation.base.BasePage;
import com.amazon.automation.utils.Locators;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage extends BasePage {
    public AmazonProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        driver.findElement(Locators.ADD_TO_CART_BUTTON).click();
    }

    public boolean isAddedToCart() {
        return driver.findElements(Locators.CART_CONFIRMATION).size() > 0;
    }
}
