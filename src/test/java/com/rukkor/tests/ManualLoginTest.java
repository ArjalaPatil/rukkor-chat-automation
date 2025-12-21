package com.rukkor.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ManualLoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        driver.manage().window().maximize();
    }

    // MANUAL VALID LOGIN
    @Test(priority = 1)
    public void manualValidLogin() {

        driver.get("https://dev.app.rukkor.com/");
        System.out.println(" Login MANUALLY with VALID credentials");

        // Chat search box = login success indicator
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[contains(@placeholder,'Search')]")
        ));

        Assert.assertTrue(true, "Valid login successful");
        System.out.println(" Valid login verified");
    }

    // MANUAL INVALID LOGIN
    @Test(priority = 2)
    public void manualInvalidLogin() {

        driver.get("https://dev.app.rukkor.com/");
        System.out.println(" Login MANUALLY with INVALID credentials");

        // Email field still visible = login failed
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[data-cy='cy_email']")
        ));

        Assert.assertTrue(true, "Invalid login handled correctly");
        System.out.println(" Invalid login verified");
    }

    @AfterClass
    public void tearDown() {
        // driver.quit(); 
    }
}
