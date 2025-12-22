package com.rukkor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatPage {

    WebDriver driver;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox = By.xpath("//input[contains(@placeholder,'Search')]");
    private By messageBox = By.tagName("textarea");
    private By sendButton = By.xpath("//button//*[name()='svg']");
    private By lastMessage = By.xpath("(//div[contains(@class,'message')])[last()]");

    public boolean isChatLoaded() {
        return driver.findElement(searchBox).isDisplayed();
    }

    public void searchUser(String name) {
        driver.findElement(searchBox).sendKeys(name);
    }

    public void openUserChat(String name) {
        driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]")).click();
    }

    public void sendMessage(String text) {
        driver.findElement(messageBox).sendKeys(text);
        driver.findElement(sendButton).click();
    }

    public String getLastMessageText() {
        return driver.findElement(lastMessage).getText();
    }
}
