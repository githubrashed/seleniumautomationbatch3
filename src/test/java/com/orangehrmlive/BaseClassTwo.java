package com.orangehrmlive;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseClassTwo {
    WebDriver driver;
    public String appUrl = "https://opensource-demo.orangehrmlive.com/";
    public String userName = "Admin";
    public String password = "admin123";

    public abstract String getPageTitle();


    @BeforeClass
    public void initialization() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        waitForImplicitWait();
        driver.get(appUrl);
        waitForImplicitWait();
    }

    public void waitForImplicitWait() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
