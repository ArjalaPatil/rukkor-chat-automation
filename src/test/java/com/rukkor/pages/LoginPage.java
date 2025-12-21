package com.rukkor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.cssSelector("input[data-cy='cy_email']");
    By password = By.cssSelector("input[data-cy='cy_password']");
    By signIn = By.cssSelector("button[data-cy='cy_login']");

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
}
