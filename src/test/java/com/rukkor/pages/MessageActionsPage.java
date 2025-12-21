package com.rukkor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessageActionsPage {

    WebDriver driver;

    public MessageActionsPage(WebDriver driver) {
        this.driver = driver;
    }

    By reactionButton = By.xpath("(//button[contains(@aria-label,'Reaction')])[last()]");
    By thumbsUp = By.xpath("//span[text()='👍']");

    public void addReaction() {
        driver.findElement(reactionButton).click();
        driver.findElement(thumbsUp).click();
    }

    public boolean reactionVisible() {
        return driver.getPageSource().contains("👍");
    }
}
