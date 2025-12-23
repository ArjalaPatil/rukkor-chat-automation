package com.rukkor.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ChatNavigationPage {

    WebDriver driver;
    WebDriverWait wait;

    public ChatNavigationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Click "Spaces"
    By spacesBtn = By.xpath("//div[contains(@class,'allSpacesWrapper')]");

    // Click QA New Space from sidebar
    By qaSpaceSidebar = By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div/div[1]/div[2]/div/div/div[2]");

    // Click QA Space header
    By qaSpaceHeader = By.xpath("//*[@id='root']/div/div[1]/div[1]/div[3]");

    // Click #General
    By generalChat = By.xpath("//span[text()='General']");

    public void openGeneralChat() {
        wait.until(ExpectedConditions.elementToBeClickable(spacesBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(qaSpaceSidebar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(qaSpaceHeader)).click();
        wait.until(ExpectedConditions.elementToBeClickable(generalChat)).click();
    }
}
