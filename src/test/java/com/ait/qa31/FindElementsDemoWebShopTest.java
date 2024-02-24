package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsDemoWebShopTest extends TestBase {

    @Test
    public void findElementByCssSelector() {
        WebElement elem1 = driver.findElement(By.cssSelector("#newsletter-subscribe-block"));
        System.out.println(elem1.getText());

        WebElement elem2 = driver.findElement(By.cssSelector("[href='/register']"));
        System.out.println(elem2.getText());

        WebElement elem3 = driver.findElement(By.cssSelector("h2"));
        System.out.println(elem3.getText());

        List<WebElement> elements = driver.findElements(By.cssSelector(".title"));
        System.out.println(elements.get(2).getText());
        System.out.println(elements.get(4).getText());
    }

    @Test
    public void findElementsByXpath() {
        WebElement elem1 = driver.findElement(By.xpath("//*[@for='pollanswers-1']"));
        System.out.println(elem1.getText());

        List<WebElement> elements1 = driver.findElements(By.xpath("//p"));
        System.out.println(elements1.get(1).getText());

        WebElement elem2 = driver.findElement(By.xpath("//*[contains(text(),'Featured')]"));
        System.out.println(elem2.getText());

        List<WebElement> elements2 = driver.findElements(By.xpath("//h2[@class='product-title']"));
        System.out.println(elements2.get(1).getText());

        WebElement elem3 = driver.findElement(By.xpath("//*[@class='view-all']"));
        System.out.println(elem3.getText());
    }

}
