package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_searchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D04_searchStepDef {

    P03_searchPage search= new P03_searchPage();
    SoftAssert soft = new SoftAssert();

    @When("user could go to field of search")
    public void goTOSearchLabel()
    {
          search.searchLabel().click();
    }

    @And("user could search with valid product {string}")
    public void userCouldSearchWithValidProduct(String productName)
    {
        search.searchLabel().sendKeys(productName.toLowerCase(), Keys.ENTER);
    }

    @Then("verify that the user could find a product relative for result {string}")
    public void verifyThatTheUserCouldFindAProductRelativeForResult(String productResultNAme)
    {
        int count = search.productRelativeResult().size();
        for (int i = 0; i < count; i++)
        {
             String productname = search.productRelativeResult().get(i).getText();
             soft.assertTrue(productname.toLowerCase().contains(productResultNAme.toLowerCase()));
             soft.assertAll();

        }
    }

    @When("user could search with valid sku {string}")
    public void userCouldSearchWithValidSku(String SrialNumber)
    {
         search.searchLabel().sendKeys(SrialNumber);
         search.clickOnSearchButton().click();

    }

    @And("verify that user could find product relative for sku of result {string}")
    public void verifyThatUserCouldFindProductRelativeForSkuOfResult(String sku)
    {
        int count = search.skuProdutRelativeResult().size();
        for (int i = 0; i < count ; i++)
        {
            String productName = search.skuProdutRelativeResult().get(i).getText();
            soft.assertTrue(productName.contains(sku));
           soft.assertAll();
        }
    }

    @Then("click on picture of product to navigate details for product")
    public void clickOnPictureOfProductToNavigateDetailsForProduct()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(search.clickOnPictureDetail())).click();
    }

    @And("verify that main sku relative for sku for searching product {string}")
    public void verifyThatMainSkuRelativeForSkuForSearchingProduct(String sku)
    {
        String product = search.serialNumberProduct().getText();
        soft.assertTrue(product.toUpperCase().contains(sku.toUpperCase()));
        soft.assertAll();
    }
}
