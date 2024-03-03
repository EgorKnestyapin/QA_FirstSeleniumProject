package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @DataProvider
    public Iterator<Object[]> createAccount() {
        List<Object[]> list = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("src/test/resources/user.csv"))) {
            String s = bf.readLine();
            while (s != null) {
                String[] split = s.split(";");
                list.add(new Object[]{split[0], split[1], split[2], split[3], split[4]});
                s = bf.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }

    @Test(dataProvider = "createAccount")
    public void createNewAccountPositiveTestFromCsv(String firstname, String lastname, String email, String password,
                                                    String confirmPassword) {
        clickOnTheRegisterLink();

        type(By.id("FirstName"), firstname);

        type(By.id("LastName"), lastname);

        fillLoginRegisterForm(email, password);

        type(By.id("ConfirmPassword"), confirmPassword);

        clickOnTheRegisterButton();

        Assert.assertTrue(isElementPresent(By.xpath(String.format("//a[text()='%s']", email))));
    }
}
