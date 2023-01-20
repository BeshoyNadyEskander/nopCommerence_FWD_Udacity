package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_homePage;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P01_homePage home = new P01_homePage();
    private String validEmail ;
    private String validPassword;
    private boolean status = true;

    @Given("user go to login page")
    public void LoginPage()
    {
           home.goToLoginPage().click();
    }


    @When("user could enter valid email and valid password")
    public void userCouldEnterValidEmailAndValidPassword()
    {
        //1- we should get valid email from config file
        validEmail = configuration.get("email");
        home.emailLabelLogin().sendKeys(validEmail);

        //2- we should get valid password from config file
        validPassword = configuration.get("validPassword");
        home.passwordlLabelLogin().sendKeys(validPassword);

    }

    @And("user could press on login button")
    public void userCouldPressOnLoginButton()
    {
        home.pressOnLoginButton().click();

    }

    @Then("validate that user navigate home page successfully")
    public void validateThatUserNavigateHomePageSuccessfully()
    {
        SoftAssert soft = new SoftAssert();
        //1- ensure that logout button appear
        status = home.logoutButton().isDisplayed();
        soft.assertTrue(status);

        //2- ensure that from url
        String url = Hooks.driver.getCurrentUrl();
        soft.assertTrue(url.contains("https://demo.nopcommerce.com/"));

        soft.assertAll();

    }

}
