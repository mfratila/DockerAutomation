package org.example.tests;

import org.example.framework.DriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;

public class BaseTest {

    final DriverManager driverManager;

    public BaseTest() throws MalformedURLException {
        driverManager = new DriverManager();
    }

    @AfterClass
    public void tearDownClass() {
        driverManager.quit();
    }

    public RemoteWebDriver getDriver() {
        return driverManager.getDriver();
    }

}

