package com.rukkor.tests;


import com.rukkor.base.BaseTest;
import com.rukkor.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() {
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login("vik.qa.123@yopmail.com", "Tester@123456");

	    // Test passes if verification page appears
	    Assert.assertTrue(loginPage.isVerificationPageDisplayed(), "Verification page did not appear!");
	}

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong@email.com", "wrongpass");
        Assert.assertTrue(loginPage.isLoginFailed(), "Error message was not displayed!");
    }
}
