package com.rukkor.tests;

import com.rukkor.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ChatTest {

    WebDriver driverA;
    WebDriver driverB;

    @Test
    public void sendAndReceiveMessage() throws InterruptedException {

        driverA = new ChromeDriver();
        driverB = new ChromeDriver();

        LoginPage loginA = new LoginPage(driverA);
        LoginPage loginB = new LoginPage(driverB);
        ChatPage chatA = new ChatPage(driverA);
        ChatPage chatB = new ChatPage(driverB);

        loginA.open();
        loginA.enterEmail("vik.qa.1234@yopmail.com");
        loginA.enterPassword("Test@123456");
        loginA.clickSignIn();

        loginB.open();
        loginB.enterEmail("vik.qa.123@yopmail.com");
        loginB.enterPassword("Tester@123456");
        loginB.clickSignIn();

        Thread.sleep(5000);

        chatA.searchUser("vik.qa");
        chatA.sendMessage("Hello Automation");

        Thread.sleep(3000);
        Assert.assertTrue(chatB.getLastMessageText().contains("Hello Automation"));
    }
}
