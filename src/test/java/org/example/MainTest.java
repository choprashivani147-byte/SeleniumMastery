package org.example;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class MainTest {
    @Test
    public void mainTest() {
        // 1. Create an instance of the Main class
        Main googlePage = new Main();

        // 2. Call the main() method to get the search button
        WebElement searchButton = googlePage.main();

        // 3. The 'Aha!' Moment: Assert that the button is actually displayed
        // If isDisplayed() is false, TestNG will fail this test and show it as Red.
        assertTrue(searchButton.isDisplayed(), "The Google Search button was not visible on the page!");
    }
}
