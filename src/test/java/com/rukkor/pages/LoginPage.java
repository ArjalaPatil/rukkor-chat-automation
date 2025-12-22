package com.rukkor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.cssSelector("input[data-cy='cy_email']");
    private By password = By.cssSelector("input[data-cy='cy_password']");
    private By signIn = By.cssSelector("button[data-cy='cy_login']");
    private By errorMessage = By.cssSelector("div.ant-message-error");
    
    public void open() {
        driver.get("https://dev.app.rukkor.com/");
    }

    public void enterEmail(String value) {
        driver.findElement(email).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).sendKeys(value);
    }

    public void clickSignIn() {
        driver.findElement(signIn).click();
    }
    
    public boolean isErrorDisplayed() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return error.isDisplayed();
        } catch (Exception e) {
            return false; // error not displayed
        }
    }

   
}
