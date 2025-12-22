package com.rukkor.tests;

import com.rukkor.base.BaseTest;
import com.rukkor.pages.MessageActionsPage;
import com.rukkor.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class MessageActionTest extends BaseTest {

    @Test
    public void messageActionsTest() throws InterruptedException {
        // ---------- Login first ----------
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("vik.qa.123@yopmail.com", "Tester@123456");

        // Wait manually for verification code entry
        Thread.sleep(15000); // <-- Increase if you need more time to enter code manually

        // ---------- Message Actions ----------
        MessageActionsPage messagePage = new MessageActionsPage(driver);

        // 1️⃣ Edit message
        messagePage.editMessage("Hello Edited Message");
        Assert.assertTrue(messagePage.isMessageEdited("Hello Edited Message"), "Message edit failed!");

        // 2️⃣ Delete message
        messagePage.deleteMessage();
        Assert.assertTrue(messagePage.isMessageDeleted(), "Message delete failed!");

        // 3️⃣ Add reaction
        messagePage.addReaction("👍");
        Assert.assertTrue(messagePage.isReactionAdded(), "Reaction not added!");
    }
}
