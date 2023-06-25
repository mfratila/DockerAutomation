package org.example.tests;

import org.example.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    final DriverManager driverManager;
    final protected WebDriverWait wait;

    public BaseTest() throws MalformedURLException {
        driverManager = new DriverManager();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDownClass() {
        driverManager.quit();
    }

    public RemoteWebDriver getDriver() {
        return driverManager.getDriver();
    }

    public void getPage(String URL) {
        getDriver().get(URL);
    }

    public WebElement getElementById(String id) {
        return getDriver().findElement(By.id(id));
    }

}

