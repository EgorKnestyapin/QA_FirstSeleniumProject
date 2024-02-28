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
        clickOnTheLoginLink();
        fillLoginRegisterForm("john3@gm.com", "Qwerty123$");
        clickOnTheLoginButton();
    }

    @Test
    public void addSecondItemToCartPositiveTest() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".button-2.product-box-add-to-cart-button"));
        buttons.get(1).click();
        clickOnTheShoppingCart();
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='14.1-inch Laptop']")));
    }
}
