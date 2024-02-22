package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");

        // maximize browser to window size
        driver.manage().window().maximize();
        // wait for all elements on the page to load before starting test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagName() {
        // find element by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        // find elements by tag
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementsBySampleLocator() {
        // id
        WebElement elementId = driver.findElement(By.id("city"));
        // className
        WebElement elementClassName = driver.findElement(By.className("navigation-link"));
        System.out.println(elementClassName.getText());
        // linkText
        driver.findElement(By.linkText("Let the car work"));
        // partialLinkText
        driver.findElement(By.partialLinkText("work"));
    }

    @Test
    public void findElementByCssSelectorTest() {
        // tagName == css
        driver.findElement(By.cssSelector("h1"));
        // id -> #id
        // driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));
        // className -> .className
        // driver.findElement(By.className("navigation-link"));
        driver.findElement(By.cssSelector(".navigation-link"));
        // any -> [attr='par']
        driver.findElement(By.cssSelector("[href='/search']"));
    }

    @Test
    public void findElementByXpath() {
        // tagName == //tagName
        driver.findElement(By.xpath("//h1"));
        // id -> //tag[@id='city']
        // driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//*[@id='city']"));
        // className -> //tag[@class='className']
        // driver.findElement(By.className("navigation-link"));
        driver.findElement(By.xpath("//*[@class='navigation-link']"));
        // any -> //*[attr='par']
        driver.findElement(By.cssSelector("//*[@href='/search']"));
        // by text
        driver.findElement(By.xpath("//*[text()='Find your car now!']"));
        driver.findElement(By.xpath("//*[.='Find your car now!']"));
        driver.findElement(By.xpath("//*[contains(.,'your car now!')]"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
