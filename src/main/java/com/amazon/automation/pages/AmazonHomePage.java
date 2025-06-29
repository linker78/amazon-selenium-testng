package com.amazon.automation.pages;

import com.amazon.automation.base.BasePage;
import com.amazon.automation.utils.Locators;
import com.amazon.automation.utils.PopupHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePage extends BasePage {
    private WebDriverWait wait;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void handleContinueShoppingPopup() {
        try {
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(PopupHandler.CONTINUE_SHOPPING_BUTTON));
            continueBtn.click();
        } catch (Exception ignored) {}
    }

    public void enterSearchTerm(String term) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SEARCH_BOX));
        driver.findElement(Locators.SEARCH_BOX).sendKeys(term);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.SEARCH_BUTTON));
        driver.findElement(Locators.SEARCH_BUTTON).click();
    }

    public String getResultsText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.RESULTS_TEXT)).getText();
    }

    public void selectFirstProduct() {
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(Locators.FIRST_PRODUCT));
        firstProduct.click();
    }
}
