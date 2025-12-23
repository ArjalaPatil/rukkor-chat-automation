package com.rukkor.tests;

import com.rukkor.pages.LoginPage;
import com.rukkor.pages.ChatNavigationPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;

public class MessageActionTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://dev.app.rukkor.com/");
    }

    @Test
    public void sendAndDeleteMessage() {

        // ✅ LOGIN
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("vik.qa.123@yopmail.com", "Tester@123456");

        // ⏸ MANUAL OTP WAIT
        System.out.println("👉 Enter OTP manually...");
        wait.until(driver -> !loginPage.isVerificationPageDisplayed());

        // ✅ NAVIGATE TO QA SPACE → #GENERAL
        ChatNavigationPage nav = new ChatNavigationPage(driver);
        nav.openGeneralChat();

        // ✅ TYPE MESSAGE
        WebElement messageBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[@data-placeholder='Type a message...']")
                )
        );
        messageBox.sendKeys("Hello Automation");
        messageBox.sendKeys(Keys.ENTER);

        // ✅ WAIT FOR MESSAGE TO APPEAR
        WebElement lastMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//div[contains(@class,'message')])[last()]")
                )
        );

        // ✅ HOVER ON MESSAGE
        new org.openqa.selenium.interactions.Actions(driver)
                .moveToElement(lastMessage)
                .perform();

        // ✅ CLICK 3-DOT MENU
        WebElement menu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".fa-ellipsis")
                )
        );
        menu.click();

        // ✅ CLICK DELETE
        WebElement deleteBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Delete']")
                )
        );
        deleteBtn.click();

        System.out.println("✅ Message deleted successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
