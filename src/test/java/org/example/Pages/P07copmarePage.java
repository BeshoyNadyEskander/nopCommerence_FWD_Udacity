package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P07copmarePage {

    public List<WebElement>listOfProduct()
    {
        return Hooks.driver.findElements(By.xpath("//div[@class=\"product-item\"]"));
    }

    public List<WebElement>TitleOflistOfProduct()
    {
        return Hooks.driver.findElements(By.xpath("//div[@class=\"product-item\"]//h2"));
    }


    public List<WebElement> compareProductButton()
    {
        return Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-compare-list-button\"]"));
    }

    public List<WebElement> nameProductComparingList()
    {
        return Hooks.driver.findElements(By.cssSelector("tr[class=\"product-name\"] [style]"));
    }

    public WebElement clickOncompareToGetPage()
    {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"/compareproducts\"]"));
    }
}
