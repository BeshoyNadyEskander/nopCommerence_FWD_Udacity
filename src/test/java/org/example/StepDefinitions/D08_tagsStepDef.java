package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_categoriesPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class D08_tagsStepDef {

   P04_categoriesPage categoryTags = new P04_categoriesPage();
   String nameOfTagSelected;

    @And("user should scroll down to get list of tags")
    public void userShouldScrollDownToGetListOfTags() throws InterruptedException {
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,1500)");

    }
    @When("user selects random tags")
    public void selectTags() throws InterruptedException {
          // count of size for tags
        int count_tags = categoryTags.listOfTags().size();
        // select random from tags
        int selectedRandomTags = new Random().nextInt(count_tags);

        //hover on selected tag
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(categoryTags.listOfTags().get(selectedRandomTags)).perform();
        Thread.sleep(1500);

        // get text of selectedtag to can do assertion on it
        nameOfTagSelected = categoryTags.listOfTags().get(selectedRandomTags).getText();
        // click on selected tag
        categoryTags.listOfTags().get(selectedRandomTags).click();
    }

    @Then("validate that tag is displayed relative products")
    public void validateThatTagIsDisplayedRelativeProducts()
    {
        SoftAssert soft = new SoftAssert();
        String titleTag = categoryTags.titleOfTagResultProduct().getText();
        soft.assertTrue(titleTag.contains(nameOfTagSelected));
        soft.assertAll();

    }
}
