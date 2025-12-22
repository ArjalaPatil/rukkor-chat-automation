package com.rukkor.tests;

import com.rukkor.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class InvalidLoginTest {

    WebDriver driver;

    @BeforeClass
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage login = new LoginPage(driver);

        login.open();
        login.enterEmail("wrong.user@yopmail.com");
        login.enterPassword("WrongPassword@123");
        login.clickSignIn();

        // ✅ Validate error message
        Assert.assertTrue(
                login.isErrorDisplayed(),
                "Error message not displayed for invalid credentials"
        );
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
