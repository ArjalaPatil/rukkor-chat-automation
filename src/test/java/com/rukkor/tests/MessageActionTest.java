package com.rukkor.tests;

import com.rukkor.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MessageActionTest {

    WebDriver driver;

    @Test
    public void addReactionTest() throws InterruptedException {

        driver = new ChromeDriver();
        LoginPage login = new LoginPage(driver);
        MessageActionsPage actions = new MessageActionsPage(driver);

        login.open();
        login.enterEmail("vik.qa.123@yopmail.com");
        login.enterPassword("Tester@123456");
        login.clickSignIn();

        Thread.sleep(5000);
        actions.addReaction();

        Assert.assertTrue(actions.reactionVisible());
    }
}
