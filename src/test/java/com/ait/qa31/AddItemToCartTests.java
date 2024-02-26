package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddItemToCartTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), "john3@gm.com");
        type(By.id("Password"), "Qwerty123$");
        click(By.cssSelector(".button-1.login-button"));
    }

    @Test
    public void addSecondItemToCartPositiveTest() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".button-2.product-box-add-to-cart-button"));
        System.out.println(buttons.size());
        buttons.get(1).click();
        click(By.xpath("//span[.='Shopping cart']"));
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='14.1-inch Laptop']")));
    }
}
