package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //locator @FindBy
    @FindBy(id = "username")//memasukan username
            WebElement username;
    @FindBy(id = "password")//memasukan password
    WebElement password;
    @FindBy(xpath = "//button[@name='login']")//mengklik tombol login
    WebElement btnlogin;
    @FindBy(xpath = "(//strong[contains(text(),'ktino')])[1]")//mengambil username setelah berhasil login
    WebElement usernameText;


    @FindBy(css = "a[class='custom-logo-link'] img[alt='ToolsQA Demo Site']")//ke menu utama
    WebElement ShopTools;
    private WebDriver driver;


    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);

    }

    public void login() {
        username.sendKeys("ktino");//memasukan username
        password.sendKeys("syalalala");//memasukan password
        btnlogin.click();//mengklik tombol login
        String name = usernameText.getText();
        if (name.equals("ktino")) {
            System.out.println("Login case done");
        } else {
            System.out.println("error");
        }
        ShopTools.click();//ke menu utama
    }


}

