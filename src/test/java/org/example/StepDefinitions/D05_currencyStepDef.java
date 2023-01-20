package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D05_currencyStepDef {
    P01_homePage homeCurrencyChange = new P01_homePage();

    @When("user select on euro currency")
    public void selectCurrency_button()
    {
       // object from class select to driver could select by visiable text
        Select select = new Select(homeCurrencyChange.selectCurrency());
        select.selectByVisibleText("Euro");
    }

    @Then("verify that the changing of currency is displayed successfully")
    public void verifyThatTheChangingOfCurrencyIsDisplayedSuccessfully()
    {
       int count = homeCurrencyChange.currencySymbol().size();
        for (int i = 0; i <count ; i++)
        {
            String symbol = homeCurrencyChange.currencySymbol().get(i).getText();
             Assert.assertTrue(symbol.contains("€"));
        }
    }
}
