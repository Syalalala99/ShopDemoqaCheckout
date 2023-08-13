package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

    @Override
    public WebDriver setStrategy() {
        String patch = "C:\\myTools\\chromedriver.exe";
        System.setProperty("webdriver.gecko.driver", patch);
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
