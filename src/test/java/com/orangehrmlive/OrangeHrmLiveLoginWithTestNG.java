package com.orangehrmlive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHrmLiveLoginWithTestNG extends BaseClassTwo {

    @Test(priority = 1, enabled = true)
    public void orangeHrmLiveLoginShouldSucceed() {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(userName);
        waitForImplicitWait();

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        waitForImplicitWait();

        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        waitForImplicitWait();
    }

    @Test(priority = 0, enabled = true)
    public void verifyOrangeHrmPageTitle() {
        OrangeHrmLiveLoginWithTestNG orangeHrmLiveLoginWithTestNG = new OrangeHrmLiveLoginWithTestNG();
        System.out.println(orangeHrmLiveLoginWithTestNG.getPageTitle());

    }

    @Override
    public String getPageTitle() {
        return "OrangeHRM";
    }
}
