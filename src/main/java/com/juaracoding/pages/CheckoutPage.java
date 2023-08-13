package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    @FindBy(xpath = "//ul[(@class='noo-cart-simple')]") //xpath view Cart
    WebElement viewCart;
    @FindBy(xpath = "//div/a[(@class='checkout-button button alt wc-forward')]")//xpath checkout button
    WebElement checkoutButton;
    @FindBy(id = "billing_first_name") //id input text first name
    WebElement firstName;
    @FindBy(id = "billing_last_name") //id input text last name
    WebElement lastName;

    @FindBy(xpath = "//span[@aria-label='Country / Region']//span[@role='presentation']") // xpath dropdown country
    WebElement country;

    @FindBy(xpath = "//input[@role='combobox']") //xpath input text on dropdown country
    WebElement textCountry;

    @FindBy(id = "billing_address_1") //id input text street name
    WebElement streetName;

    @FindBy(id = "billing_city") //id input text city
    WebElement city;

    @FindBy(xpath = "//span[@aria-label='Province']//span[@role='presentation']") // xpath dropdown province
    WebElement province;

    @FindBy(xpath = "//input[@role='combobox']")//xpath input text on dropdown province
    WebElement textProvince;

    @FindBy(id = "billing_postcode") //id input text postcode
    WebElement postcode;

    @FindBy(id = "billing_phone") //id input text phone number
    WebElement phone;

    @FindBy(id = "billing_email") //id input text email
    WebElement email;

    @FindBy(xpath = "//input[@id='terms']") //radio button checkbox
    WebElement checkBox;

    @FindBy(xpath = "//button[@id='place_order']") //place order button
    WebElement placeOrder;

    @FindBy(css = "li[data-id='billing_first_name']") //get error message text
    WebElement error;

    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']") //get order done message text
    WebElement orderDone;

    private WebDriver driver;


    public CheckoutPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void checkout() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        viewCart.click();
        js.executeScript("window.scrollBy(0,1000)");
        checkoutButton.click();
        js.executeScript("window.scrollBy(0,800)");
        firstName.sendKeys(Keys.CONTROL + "A" + Keys.DELETE + Keys.ENTER);
        DriverSingleton.delay(2);
        js.executeScript("window.scrollBy(0,500)");
        placeOrder.click();
        DriverSingleton.delay(2);
        String txtError = error.getText();
        if (txtError.equals("Billing First name is a required field.")) {
            System.out.println("Negative Case Done");
        } else {
            System.out.println("error");
        }
        js.executeScript("window.scrollBy(0,800)");
        firstName.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        firstName.sendKeys("kristoporus");
        lastName.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        lastName.sendKeys("tino");
        country.click();
        textCountry.sendKeys("Indonesia" + Keys.ENTER);
        streetName.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        streetName.sendKeys("Perkasa");
        city.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        city.sendKeys("Yogya");
        province.click();
        textProvince.sendKeys("Y" + Keys.ENTER);
        postcode.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        postcode.sendKeys("55822");
        phone.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        phone.sendKeys("081264277142");
        email.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        email.sendKeys("coba@gmail.com");
        js.executeScript("window.scrollBy(0,-100)");
        checkBox.click();
        placeOrder.click();
        String txtOrderDone = orderDone.getText();
        if (txtOrderDone.equals("Thank you. Your order has been received.")) {
            System.out.println("Checkout Case Done");
        } else {
            System.out.println("error");
        }
    }
}