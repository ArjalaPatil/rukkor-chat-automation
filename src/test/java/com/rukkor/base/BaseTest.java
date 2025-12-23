package com.rukkor.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // maximize browser
        options.addArguments("--disable-notifications"); // disable pop-ups

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // optional, short implicit wait
        driver.manage().deleteAllCookies(); // clean session

        driver.get("https://dev.app.rukkor.com/login");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
           driver.quit();
        }
    }
}
