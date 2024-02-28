package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {
        clickOnTheRegisterLink();

        type(By.id("FirstName"), "John");

        type(By.id("LastName"), "Smith");

        String email = "john3@gm.com";
        fillLoginRegisterForm(email, "Qwerty123$");

        type(By.id("ConfirmPassword"), "Qwerty123$");

        clickOnTheRegisterButton();

        Assert.assertTrue(isElementPresent(By.xpath(String.format("//a[text()='%s']", email))));
    }
}
