package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    // before - setup
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public void fillLoginRegisterForm(String email, String password) {
        type(By.id("Email"), email);
        type(By.id("Password"), password);
    }

    public void clickOnTheLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void clickOnTheLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnTheShoppingCart() {
        click(By.xpath("//span[.='Shopping cart']"));
    }

    public void clickOnTheRegisterButton() {
        click(By.id("register-button"));
    }

    public void clickOnTheRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }
}
