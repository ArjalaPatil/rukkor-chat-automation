package com.rukkor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage {

    WebDriver driver;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.xpath("//input[contains(@placeholder,'Search')]");
    By messageBox = By.tagName("textarea");
    By lastMessage = By.xpath("(//div[contains(@class,'message')])[last()]");

    public boolean isChatLoaded() {
        return driver.findElement(searchBox).isDisplayed();
    }

    public void searchUser(String name) {
        driver.findElement(searchBox).sendKeys(name);
    }

    public void typeMessage(String text) {
        driver.findElement(messageBox).sendKeys(text);
    }

    public String getLastMessageText() {
        return driver.findElement(lastMessage).getText();
    }
}
