package com.amazon.automation.pages;

import com.amazon.automation.base.BasePage;
import com.amazon.automation.utils.Locators;
import org.openqa.selenium.WebDriver;

public class AmazonSignInPage extends BasePage {
    public AmazonSignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        driver.findElement(Locators.EMAIL_FIELD).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(Locators.CONTINUE_BUTTON).click();
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.PASSWORD_FIELD).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(Locators.SIGNIN_BUTTON).click();
    }
}
