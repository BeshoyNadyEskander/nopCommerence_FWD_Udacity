package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.Pages.P06_cartShoppingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Random;

public class D10_addCartShoppingStepDef {

    P06_cartShoppingPage cartshop = new P06_cartShoppingPage();

    SoftAssert soft = new SoftAssert();

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    int selectedProdcut;

    @And("user select products and click it")
    public void selectProduct()
    {
        int contProduct = cartshop.listOfProduct().size();
         selectedProdcut = new Random().nextInt(contProduct);

        Actions action = new Actions(Hooks.driver);
        action.moveToElement(cartshop.listOfProduct().get(selectedProdcut)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(cartshop.listOfProduct().get(selectedProdcut))).click();
    }


    @And("user could click on add cart shopping button")
    public void userCouldClickOnAddCartShoppingButton()
    {
        cartshop.addCartButton().click();
    }

    @Then("validate that the message of adding product is displayed")
    public void validateThatTheMessageOfAddingProductIsDisplayed()
    {
        String successMessage = cartshop.successfulMessageOfAdding().getText();
       // soft.assertTrue(cartshop.successfulMessageOfAdding().isDisplayed());
        soft.assertTrue(successMessage.contains("product has been added to your shopping cart"));

        soft.assertAll();
    }

    @And("verify that the quantity of cart shopping bigger than zero")
    public void verifyThatTheQuantityOfCartShoppingBiggerThanZero() throws InterruptedException {
          Thread.sleep(2000);

          cartshop.closeNotifactionBar().click();
        // hover on cart shopping
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(cartshop.cartShoppingButton()).perform();
        // click on button
        wait.until(ExpectedConditions.elementToBeClickable(cartshop.cartShoppingButton())).click();
        // assertion on quantity

        String quantityAttribute = cartshop.QuantityOfPrdouctAddCart().getAttribute("value");
        //convert string into integer
        int num_quantity = Integer.parseInt(quantityAttribute);
        soft.assertTrue(num_quantity > 0);
        soft.assertAll();

    }
}


