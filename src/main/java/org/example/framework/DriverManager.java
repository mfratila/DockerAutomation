package org.example.framework;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager
{
    private final static String seleniumGridUrl = "http://localhost:4444/wd/hub";
    private final RemoteWebDriver driverManager;


    public DriverManager() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--allow-insecure-localhost");
        driverManager = new RemoteWebDriver(new URL(seleniumGridUrl), chromeOptions);
        WebDriverRunner.setWebDriver(driverManager);
    }


    public RemoteWebDriver getDriver() {
        return driverManager;
    }

    public void quit() {
        if (driverManager != null) {
            driverManager.quit();
        }
    }


}
