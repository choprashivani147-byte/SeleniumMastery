package org.example;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// 1. SCALE FIX: Inheriting BaseTest handles driver lifecycle injection automatically
public class MainTest extends BaseTest {

    @Test
    public void verifyGoogleSearchButtonVisibility() {
        // 2. Pass our active driver into the Page Object instance
        Main googlePage = new Main(driver);

        // 3. Sequential navigation step
        googlePage.navigateToGoogle();

        // 4. Retrieve element validation state
        WebElement searchButton = googlePage.getSearchButton();

        // 5. Verification Gate
        Assert.assertTrue(searchButton.isDisplayed(), "The Google Search button was not visible on the viewport!");
    }
}