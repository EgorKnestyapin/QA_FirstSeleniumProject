package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {
        click(By.cssSelector("[href='/register']"));

        type(By.id("FirstName"), "John");

        type(By.id("LastName"), "Smith");

        String email = "john3@gm.com";
        type(By.id("Email"), email);

        type(By.id("Password"), "Qwerty123$");

        type(By.id("ConfirmPassword"), "Qwerty123$");

        click(By.id("register-button"));

        Assert.assertTrue(isElementPresent(By.xpath(String.format("//a[text()='%s']", email))));
    }
}
