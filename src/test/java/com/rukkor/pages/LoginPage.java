package com.rukkor.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "loginForm_email")
    WebElement email;

    @FindBy(id = "loginForm_password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[text()='Incorrect Credentials']")
    WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ✅ Method to perform login
    public void login(String userEmail, String userPassword) {
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(userEmail);
        password.sendKeys(userPassword);
        loginBtn.click();
    }

    // ✅ Method to check if login is successful
    public boolean isLoginSuccess() {
        try {
            wait.until(ExpectedConditions.urlContains("chat"));
            return driver.getCurrentUrl().contains("chat");
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Optional: check if login failed
    public boolean isLoginFailed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMsg));
            return errorMsg.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
    
 // Verification page element
    @FindBy(xpath = "//*[@id='root']/div/div[1]/div[1]/div[2]/div/div/div/div[2]")
    WebElement verificationPageElement;

    public boolean isVerificationPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(verificationPageElement));
            return verificationPageElement.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}
