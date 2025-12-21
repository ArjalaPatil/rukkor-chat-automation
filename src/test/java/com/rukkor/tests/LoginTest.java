package com.rukkor.tests;

import com.rukkor.base.BaseTest;
import com.rukkor.pages.ChatPage;
import com.rukkor.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);
        ChatPage chat = new ChatPage(driver);

        login.open();
        login.enterEmail("vik.qa.123@yopmail.com");
        login.enterPassword("Tester@123456");
        login.clickSignIn();

        Assert.assertTrue(chat.isChatLoaded(), "Login failed");
    }
}
