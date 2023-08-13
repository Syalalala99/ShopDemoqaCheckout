package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    @FindBy(xpath = "//h3/a[(@href='https://shop.demoqa.com/product/tokyo-talkies/')]")//memilih produk Tokyo
    WebElement produkTokyo;
    @FindBy(css = "button[class='single_add_to_cart_button button alt']")//menambahkan produk
    WebElement addCart;
    @FindBy(css = "div[role='alert']")//mengambil teks sebagai tanda barang sudah ditambahkan
    WebElement cartText;
    @FindBy(css = "a[class='custom-logo-link'] img[alt='ToolsQA Demo Site']")//ke menu utama
    WebElement shopTools;
    @FindBy(xpath = "//h3/a[normalize-space()='red satin round neck backless maxi dress']")//menambahkan produk kedua
    WebElement redDress;
    @FindBy(id = ("pa_color")) //memilih warna
    WebElement colorButton;
    @FindBy(id = ("pa_size")) //memilih ukuran
    WebElement sizeButton;
    @FindBy(css = "button[class='single_add_to_cart_button button alt']")//menambahkan produk
    WebElement addCartTwo;
    private WebDriver driver;

    public CartPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void cart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1800)");
        produkTokyo.click();
        js.executeScript("window.scrollBy(0,1000)");
        addCart.click();
        String cartTokyo = cartText.getText();
        if (cartTokyo.contains("“Tokyo Talkies” has been added to your cart.")) {
            System.out.println("Add Cart Tokyo Talkies Case Done");
        } else {
            System.out.println("error");
        }
        shopTools.click();
        js.executeScript("window.scrollBy(0,1800)");
        redDress.click();
        Select color = new Select(colorButton);
        color.selectByValue("red");
        Select size = new Select(sizeButton);
        size.selectByValue("medium");
        addCartTwo.click();
        String cartName = cartText.getText();
        if (cartName.contains("“red satin round neck backless maxi dress” has been added to your cart.")) {
            System.out.println("Add Cart red satin round neck backless maxi dress Case Done");
        } else {
            System.out.println("error");
        }
    }
}
