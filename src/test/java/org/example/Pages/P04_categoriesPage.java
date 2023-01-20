package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P04_categoriesPage {

    public P04_categoriesPage()
    {
        PageFactory.initElements(Hooks.driver , this);
    }

    // should define element for main category
public List <WebElement> mainCategory()
{
    return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a"));
}

// define element on subcategories and we should pass parameter to define specific main category that it has sub category
  public  List<WebElement> subCategory(int randomSubCategory)
  {
      randomSubCategory = randomSubCategory + 1;
      return Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+randomSubCategory+"]/ul/li"));
  }

    //locator of page cateogry
    @FindBy(css = "div[class=\"page category-page\"]")
    public WebElement page_of_category;

    //locator of title
    @FindBy(css = "div[class=\"page-title\"]")
    public  WebElement title_of_category;

    // we should define element of Apparel element
    public WebElement ApparelMainCategory()
    {
        return Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/a"));
    }
   // we should define element of sub category shoes
    public WebElement shoesSubCategory()
    {
        return Hooks.driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/ul/li[1]"));
    }
       // list of element for fillter
    public List<WebElement> filterProductsList()
    {
        return Hooks.driver.findElements(By.xpath("//li[@class=\"item color-item\"]/input"));
    }
       // result product by filter
    public WebElement resultfilterproduct()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"product-item\"]//img[@alt]"));
    }

    // F08_tag feature list element of tags
    public List<WebElement> listOfTags()
    {
        return Hooks.driver.findElements(By.xpath("//div[@class=\"tags\"]/ul/li"));
    }
    //element of title tags
    public WebElement titleOfTagResultProduct()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page product-tag-page\"] [class=\"page-title\"]"));
    }
}
