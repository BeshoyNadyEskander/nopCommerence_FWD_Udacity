package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_searchPage {

    public WebElement searchLabel()
    {
        return Hooks.driver.findElement(By.cssSelector("input[aria-label=\"Search store\"]"));
    }

    public List <WebElement> productRelativeResult()
    {
        return Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a[href]"));
    }

    public WebElement clickOnSearchButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }
    public List <WebElement> skuProdutRelativeResult()
    {
        return Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a"));
    }
    public WebElement clickOnPictureDetail()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"picture\"]"));
    }

    public WebElement serialNumberProduct()
    {
        return Hooks.driver.findElement(By.cssSelector("span[class=\"value\"]"));
    }
}
