package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createNewAccountPositiveTest() {
        driver.findElement(By.cssSelector("[href='/register']")).click();

        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("Smith");

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("john1@gm.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Qwerty123$");

        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.click();
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys("Qwerty123$");

        driver.findElement(By.id("register-button")).click();

        isElementPresent(By.xpath("//a[text()='john1@gm.com']"));
    }
}
