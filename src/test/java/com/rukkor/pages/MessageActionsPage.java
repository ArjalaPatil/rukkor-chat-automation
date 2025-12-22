package com.rukkor.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MessageActionsPage {

    WebDriver driver;
    WebDriverWait wait;

    public MessageActionsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ---------- Replace the below locators with actual ones ----------
    @FindBy(xpath = "DUMMY_EDIT_MESSAGE_LOCATOR")  // Replace this
    WebElement editMessageField;

    @FindBy(xpath = "DUMMY_SAVE_EDIT_BUTTON_LOCATOR") // Replace this
    WebElement saveEditButton;

    @FindBy(xpath = "DUMMY_CANCEL_EDIT_BUTTON_LOCATOR") // Replace this
    WebElement cancelEditButton;

    @FindBy(xpath = "DUMMY_DELETE_BUTTON_LOCATOR") // Replace this
    WebElement deleteMessageButton;

    @FindBy(xpath = "DUMMY_CONFIRM_DELETE_BUTTON_LOCATOR") // Replace this
    WebElement confirmDeleteButton;

    @FindBy(xpath = "DUMMY_ADD_REACTION_BUTTON_LOCATOR") // Replace this
    WebElement addReactionButton;

    @FindBy(xpath = "DUMMY_REACTION_EMOJI_LOCATOR") // Replace this
    WebElement reactionEmoji;

    // ------------------- Actions -------------------
    
    public void editMessage(String newText) {
        wait.until(ExpectedConditions.visibilityOf(editMessageField));
        editMessageField.clear();
        editMessageField.sendKeys(newText);
        saveEditButton.click();
    }

    public boolean isMessageEdited(String expectedText) {
        // Replace with actual verification
        WebElement editedMessage = driver.findElement(By.xpath("DUMMY_EDITED_MESSAGE_TEXT_LOCATOR"));
        return editedMessage.getText().equals(expectedText);
    }

    public void deleteMessage() {
        deleteMessageButton.click();
        confirmDeleteButton.click();
    }

    public boolean isMessageDeleted() {
        // Replace with actual verification
        try {
            WebElement deletedMessage = driver.findElement(By.xpath("DUMMY_DELETED_MESSAGE_LOCATOR"));
            return !deletedMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void addReaction(String emoji) {
        addReactionButton.click();
        // Replace if needed
        reactionEmoji.click();
    }

    public boolean isReactionAdded() {
        // Replace with actual verification
        try {
            WebElement addedReaction = driver.findElement(By.xpath("DUMMY_REACTION_VISIBLE_LOCATOR"));
            return addedReaction.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
