package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Main extends LoginPage {
    static WebDriver driver;

    public static void main(String[] args) {

        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account/");
        LoginPage loginPage = new LoginPage();
        loginPage.login();//menjalankan class LoginPage

        CartPage cartPage = new CartPage();
        cartPage.cart();//menjalankan class CartPage

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkout();

        DriverSingleton.delay(10);
        DriverSingleton.closeObjectInstance();
    }
}