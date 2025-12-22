package com.rukkor.tests;

import com.rukkor.base.BaseTest;
import com.rukkor.pages.LoginPage;
import com.rukkor.pages.ChatPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class ChatTest {

    @Test
    public void sendMessageTest() {

        Scanner scanner = new Scanner(System.in);

        // ----- USER A -----
        WebDriver driverA = new ChromeDriver();
        driverA.manage().window().maximize();
        LoginPage loginA = new LoginPage(driverA);
        loginA.login("vik.qa.1234@yopmail.com", "Tester@123456");

        System.out.println("User A: Enter verification code manually, then press Enter...");
        scanner.nextLine();  // wait for manual verification

        ChatPage chatPageA = new ChatPage(driverA);
        // Dummy locator for sending message
        chatPageA.sendMessage("Hello from User A!");

        // ----- USER B -----
        WebDriver driverB = new ChromeDriver();
        driverB.manage().window().maximize();
        LoginPage loginB = new LoginPage(driverB);
        loginB.login("vik.qa.123@yopmail.com", "Tester@123456");

        System.out.println("User B: Enter verification code manually, then press Enter...");
        scanner.nextLine();  // wait for manual verification

        ChatPage chatPageB = new ChatPage(driverB);
        // Dummy locator for checking message
        boolean messageReceived = chatPageB.isMessageReceived("Hello from User A!");
        System.out.println("Message received by User B: " + messageReceived);

        // Keep browsers open until user presses Enter
        System.out.println("Press Enter to close both browsers...");
        scanner.nextLine();

        // Close browsers and scanner
        driverA.quit();
        driverB.quit();
        scanner.close();
    }
}
