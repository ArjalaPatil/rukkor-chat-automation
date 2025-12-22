package com.rukkor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChatPage {

    WebDriver driver;
    WebDriverWait wait;

    public ChatPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Dummy locator for message input (replace later)
    By messageInput = By.xpath("//input[@placeholder='Type a message']");

    // Dummy locator for send button (replace later)
    By sendButton = By.xpath("//button[text()='Send']");

    // Dummy locator for received messages (replace later)
    By receivedMessages = By.xpath("//div[@class='message-text']");

    // Send a message
    public void sendMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageInput)).sendKeys(message);
        driver.findElement(sendButton).click();
    }

    // Check if message is received
    public boolean isMessageReceived(String message) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(receivedMessages));
            for (WebElement msg : driver.findElements(receivedMessages)) {
                if (msg.getText().equals(message)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
