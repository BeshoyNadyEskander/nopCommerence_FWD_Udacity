package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P06_cartShoppingPage {

    public List<WebElement>listOfProduct()
    {
        return Hooks.driver.findElements(By.xpath("//div[@class=\"product-item\"]"));
    }

    public List<WebElement> requiredIndex()
    {
        return Hooks.driver.findElements(By.cssSelector("name=\"product_attribute_2\""));
    }
    public List<WebElement> requiredIndexMenu()
    {
        return Hooks.driver.findElements(By.cssSelector("select[data-attr]"));
    }

    public WebElement addCartButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 add-to-cart-button\"]"));
    }
    public WebElement successfulMessageOfAdding()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement cartShoppingButton()
    {
        return  Hooks.driver.findElement(By.cssSelector("span[class=\"cart-label\"]"));
    }

    public WebElement QuantityOfPrdouctAddCart()
    {
        return Hooks.driver.findElement(By.cssSelector("td[class=\"quantity\"] [value]"));
    }
    public WebElement closeNotifactionBar()
    {
        return Hooks.driver.findElement(By.cssSelector("span[class=\"close\"]"));
    }


}
