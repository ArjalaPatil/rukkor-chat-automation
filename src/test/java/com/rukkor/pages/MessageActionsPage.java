package com.rukkor.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class MessageActionsPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public MessageActionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }

    By messageBox = By.xpath("//p[@data-placeholder='Type a message...']");

    // last message container
    By lastMessage = By.xpath("(//div[contains(@class,'messageItem')])[last()]");

    // menu INSIDE message
    By threeDots = By.xpath(".//i[contains(@class,'fa-ellipsis')]");

    By deleteBtn = By.xpath("//span[text()='Delete']");
    By confirmDelete = By.xpath("//button//span[text()='Delete']");

    public void sendMessage(String text) {
        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(messageBox));
        box.sendKeys(text + Keys.ENTER);
    }

    public void deleteLastMessage() {
        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(lastMessage));

        actions.moveToElement(msg).perform();

        WebElement menu = msg.findElement(threeDots);
        menu.click();

        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete)).click();
    }
}
