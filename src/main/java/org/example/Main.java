package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 1. Setup
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to Google
        driver.get("https://www.google.com");

        // 3. Find the search box element
        // In Google, the search bar has a 'name' attribute equal to "q"
        WebElement searchBox = driver.findElement(By.name("q"));

        // 4. Type into the box and press ENTER
        searchBox.sendKeys("QA Automation jobs in Calgary");
        searchBox.sendKeys(Keys.ENTER);

        // 5. Wait 5 seconds so you can see the results
        Thread.sleep(5000);

        // 6. Close the browser
        driver.quit();
    }
}