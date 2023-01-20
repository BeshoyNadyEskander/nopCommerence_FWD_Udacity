package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_categoriesPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class D06_categoryStepDef {

   P04_categoriesPage category = new P04_categoriesPage();

   String categoryText ;

   @When("user selects random category from main category")
   public void selectRandomCategory()
   {
          // we should count main category
      int countMainCategory = category.mainCategory().size();

      // we should create random category from list main category
      int randomCategory = new Random().nextInt(countMainCategory);
      System.out.println("main categoy"+ randomCategory);

      //hover on selecting random main category by using class Actions
      Actions action = new Actions(Hooks.driver);
      action.moveToElement(category.mainCategory().get(randomCategory)).perform();

      // select random sub category if found
      //1- if random categories have subcategory
      if(!category.subCategory(randomCategory).isEmpty())
      {
          //1-2 count of size for elements of sub categories
            int countSubCat = category.subCategory(randomCategory).size();
         //1-3 select random sub category from them
            int selectedSubCategory = new Random().nextInt(countSubCat);
        //get text of subcategory and store in string
            this.categoryText = category.subCategory(randomCategory).get(selectedSubCategory).getText().trim();
       //1-4 click on selected random sub category
            category.subCategory(randomCategory).get(selectedSubCategory).click();
      }
      else
      {
          // store main category text in string
          this.categoryText = category.mainCategory().get(randomCategory).getText().trim();
          // click on random main category that don't have sub categories
          category.mainCategory().get(randomCategory).click();


      }



   }

    @Then("verify that page of category is displayed")
    public void verifyThatPageOfCategoryIsDisplayed()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(category.page_of_category.isDisplayed());
           soft.assertAll();
    }

    @And("verify that the title of category belongs to the title of random category")
    public void verifyThatTheTitleOfCategoryBelongsToTheTitleOfRandomCategory()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(category.title_of_category.getText().contains(this.categoryText));
    }
}
