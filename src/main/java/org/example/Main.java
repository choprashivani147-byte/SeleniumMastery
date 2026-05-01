package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public WebElement main() {

        // 1. Setup
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to Google
        driver.get("https://www.google.com");

        // 3. Assert that I can see google search button
        // Google usually has two buttons; 'btnK' is the ID for the main "Google Search" button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the button is actually visible on the screen
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[2]/div[4]/form/div[1]/div/div[3]/center/input[1]")));

        return searchButton;
    }
}