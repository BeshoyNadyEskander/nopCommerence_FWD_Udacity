package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_categoriesPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class D07_FilterStepDef {

    P04_categoriesPage category = new P04_categoriesPage();

    @Given("user should hover Apparel category and click on shoes subcategory")
    public void selectShoesSubCategory()
    {
       // hover on apparel category
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(category.ApparelMainCategory()).perform();

        //click on shoes subcat
        category.shoesSubCategory().click();

    }

    @When("user choose filter the products by color")
    public void userChooseFilterTheProductsByColor()
    {
        // count of size for list of webelement of filter
       int coutIndexFilter = category.filterProductsList().size();

       // select rondom from them
        int randomIndexFilter = new Random().nextInt(coutIndexFilter);
        //click on
        category.filterProductsList().get(randomIndexFilter).click();

    }

    @Then("validate that the product is displayed relative the color which is choosen")
    public void validateThatTheProductIsDisplayedRelativeTheColorWhichIsChoosen()
    {

        SoftAssert soft = new SoftAssert();
       soft.assertTrue(category.resultfilterproduct().isDisplayed());
       soft.assertAll();
    }
}
