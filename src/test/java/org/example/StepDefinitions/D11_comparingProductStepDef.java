package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P07copmarePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;

public class D11_comparingProductStepDef {

  P07copmarePage compare = new P07copmarePage();

    Actions action = new Actions(Hooks.driver);

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));


    int selectedProdcut;
    String  expecteRes  ;
    String  actualRes;

    @And("user could scroller down until getting the list of products")
    public void userCouldScrollerDownUntilGettingTheListOfProducts()
    {

        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,500)");

    }

    @When("user could choose product from products and hover on product")
    public void userChooseProduct() throws InterruptedException {
        int contProduct = compare.listOfProduct().size();
        selectedProdcut = new Random().nextInt(contProduct);
        action.moveToElement(compare.listOfProduct().get(selectedProdcut)).perform();

            for (int j = 0; j <compare.TitleOflistOfProduct().size(); j++)
            {
                expecteRes = compare.TitleOflistOfProduct().get(selectedProdcut).getText();
            }

        Thread.sleep(1500);
    }

    @And("user could click on comparing products button")
    public void userCouldClickOnComparingProductsButton() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(compare.compareProductButton().get(selectedProdcut))).click();

        Thread.sleep(2000);
    }

    @Then("validate that the products are selected to compare storing inside list of comapring")
    public void validateThatTheProductsAreSelectedToCompareStoringInsideListOfComapring() throws InterruptedException {

        compare.clickOncompareToGetPage().click();
        for (int i = 0; i <compare.nameProductComparingList().size(); i++)
        {
            actualRes = compare.nameProductComparingList().get(selectedProdcut).getText();

        }
        System.out.println("actual" + actualRes);
        System.out.println(expecteRes);
        Assert.assertEquals(actualRes,expecteRes);

        Thread.sleep(2000);
    }
}
