package com.rukkor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageActionsPage {

    WebDriver driver;

    private By lastMessage = By.xpath("(//div[contains(@class,'message')])[last()]");
    private By reactionBtn = By.xpath("//span[text()='👍']");

    public MessageActionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addReaction() {
        driver.findElement(lastMessage).click();
        driver.findElement(reactionBtn).click();
    }

    public boolean reactionVisible() {
        return driver.findElement(reactionBtn).isDisplayed();
    }
}
