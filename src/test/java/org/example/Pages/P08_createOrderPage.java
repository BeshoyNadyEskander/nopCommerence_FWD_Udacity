package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P08_createOrderPage {

    public WebElement CheckoutButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button[name=\"checkout\"]"));
    }

    public WebElement pressOnConditionsBeforeCheckout()
    {
        return Hooks.driver.findElement(By.cssSelector("input[id=\"termsofservice\"]"));
    }
    public WebElement shoppingcartButt()
    {
        return Hooks.driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
    }
    public List <WebElement> SelectCountry()
    {
        return Hooks.driver.findElements(By.cssSelector("select[data-trigger=\"country-select\"] [value]"));
    }
    public WebElement enterCity()
    {
        return Hooks.driver.findElement(By.cssSelector("input[id=\"BillingNewAddress_City\"]"));
    }
    public WebElement enterAddress()
    {
        return Hooks.driver.findElement(By.cssSelector("input[data-val-required=\"Street address is required\"]"));
    }
    public WebElement enterPostalcode()
    {
        return Hooks.driver.findElement(By.cssSelector("input[data-val-required=\"Zip / postal code is required\"]"));
    }
    public WebElement phoneNumber()
    {
        return Hooks.driver.findElement(By.cssSelector("input[data-val-required=\"Phone is required\"]"));
    }
    public WebElement pressContinue()
    {
        return Hooks.driver.findElement(By.cssSelector("button[onclick=\"Billing.save()\"]"));
    }
    public WebElement continuebut()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 shipping-method-next-step-button\"]"));
    }
    public WebElement paymentbuttonContinue()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 payment-method-next-step-button\"]"));
    }
    public WebElement payConfirmButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 payment-info-next-step-button\"]"));
    }
    public WebElement confirmOrder(){
        return Hooks.driver.findElement(By.cssSelector("button[onclick=\"ConfirmOrder.save()\"]"));
    }

    public WebElement titleSuccessfulOrder()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-body checkout-data\"] [class=\"title\"]"));
    }
    public WebElement completeProcess()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 order-completed-continue-button\"]"));
    }
}
