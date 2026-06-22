package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    private WebDriver driver;
    private WebDriverWait wait;

    // 1. RISK FIX: Constructor captures the live driver instance from the test layer
    public Main(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 2. RISK FIX: Eliminated fragile absolute XPath. Replaced with optimized Relative By locator.
    // Google's main search button has a stable name attribute: name='btnK'
    private final By googleSearchButton = By.xpath("(//input[@name='btnK'])[2]");

    public void navigateToGoogle() {
        driver.get("https://www.google.com");
    }

    public WebElement getSearchButton() {
        // Wait until at least one button with name 'btnK' is present in the DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")));

        // Find all matching elements and return the one that is visible to the human eye
        return driver.findElements(By.name("btnK")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Visible Google Search button not found!"));
    }
}