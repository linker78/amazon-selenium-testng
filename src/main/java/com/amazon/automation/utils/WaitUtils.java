package com.amazon.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {
    public static final int SHORT_TERM = 5;
    public static final int MIDDLE_TERM = 15;
    public static final int LONG_TERM = 30;

    public static void waitForElementVisible(WebDriver driver, org.openqa.selenium.By locator, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForElementVisibleShort(WebDriver driver, org.openqa.selenium.By locator) {
        waitForElementVisible(driver, locator, SHORT_TERM);
    }

    public static void waitForElementVisibleMiddle(WebDriver driver, org.openqa.selenium.By locator) {
        waitForElementVisible(driver, locator, MIDDLE_TERM);
    }

    public static void waitForElementVisibleLong(WebDriver driver, org.openqa.selenium.By locator) {
        waitForElementVisible(driver, locator, LONG_TERM);
    }
}