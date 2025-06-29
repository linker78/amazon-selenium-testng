package com.amazon.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.amazon.automation.utils.Locators;
import com.amazon.automation.pages.AmazonHomePage;

public class AmazonSearchTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    @BeforeClass
    public void setUp() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/config.properties"));
        baseUrl = props.getProperty("baseUrl");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAmazonSearch() {
        driver.get(baseUrl);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.handleContinueShoppingPopup();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SEARCH_BOX));
        searchBox.sendKeys("laptop");
        driver.findElement(Locators.SEARCH_BUTTON).click();
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.RESULTS_TEXT));
        Assert.assertTrue(results.getText().toLowerCase().contains("laptop"), "Search results do not contain 'laptop'");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
