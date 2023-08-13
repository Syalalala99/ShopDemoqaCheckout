package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Chrome implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        String patch = "C:\\myTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", patch);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        return new ChromeDriver(options);
    }
}
