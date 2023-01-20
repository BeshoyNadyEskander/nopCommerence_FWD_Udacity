package org.example.StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_homePage;
import org.example.Pages.P02_registerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class D01_registrationStepDef {

    // create object from homePage
    P01_homePage home = new P01_homePage();

    //create object from rigsterpage
    P02_registerPage register = new P02_registerPage();

    SoftAssert soft = new SoftAssert();

    private Boolean status = true;
    private String text;

    private String url;

    Faker fake;


    @Given("user should go to registration page")
    public void goRegisterPage()
    {
        home.goToRegisterPage().click();
    }

    @Then("validate that user could navigate register page successfully")
    public void validateThatUserCouldNavigateRegisterPageSuccessfully()
    {
        // 1-ensure title is displayed when user go to register page
     status =  register.titlePageRegister().isDisplayed();
     soft.assertTrue(status);
     //2- sure that title name is Register
       String title= register.titlePageRegister().getText();
        soft.assertTrue(title.contains("Register"));
        soft.assertAll();
    }

    @When("user could select on gender type")
    public void userCouldSelectOnGenderType()
    {
        // size of gender type
        int countGenderType = register.selectGenderType().size();
        // use random to choose random from gender
        int randomGender = new Random().nextInt(countGenderType);
        System.out.println(randomGender);

        //2- hover on select random category about using class of Actions and pass parameter of driver inside object
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(register.selectGenderType().get(randomGender)).perform();
        register.selectGenderType().get(randomGender).click();

    }

    @When("user could enter valid firstname {string} and lastname {string}")
    public void userCouldEnterValidFirstNameAndLastName(String first_name, String last_name)
    {
         register.Firstname().sendKeys(first_name);
        register.lastName().sendKeys(last_name);
    }

    @When("user could enter date of birth")
    public void userCouldEnterDateOfBirth()
    {
        // create object from calss select to can select from list
        Select select = new Select(register.dayList());
        select.selectByValue("15");

        select = new Select(register.monthList());
        select.selectByVisibleText("February");

        select =new Select(register.yearList());
        select.selectByValue("1990");
    }

    @When("user could enter valid Email")
    public void userCouldEnterValidEmail()
    {
        // we use faker depandency to generate random email through internet
          fake =new Faker();
         String randomVaildEmail = fake.internet().safeEmailAddress();
         register.emailLabel().sendKeys(randomVaildEmail);

         configuration.set("email",randomVaildEmail);

    }

    @When("user could enter valid password")
    public void userCouldEnterValidPassword()
    {
        // we use faker depandency to generate random password through internet
        fake = new Faker();
        String validPassword = fake.internet().password(6,12);
        register.passwordlabel().sendKeys(validPassword);
        // store valid password inside config file
        configuration.set("validPassword" , validPassword);

    }

    @When("user colud enter valid confirmation password")
    public void userColudEnterValidConfirmationPassword()
    {
        String validConfirmPassword = configuration.get("validPassword");
        register.confirmationPasswordlabel().sendKeys(validConfirmPassword);

        configuration.set("validConfirmPassword" ,validConfirmPassword);
    }

    @When("user may enter name of company {string}")
    public void userMayEnterNameOfCopmany(String companyName)
    {
        register.companyLabel().sendKeys(companyName);

    }

    @When("user could press on register button")
    public void userCouldPressOnRegisterButton()
    {
        register.clickOnRegisterButton().click();

    }

    @Then("validate that user could register a new account successfully")
    public void validateThatUserCouldRegisterANewAccountSuccessfully()
    {
        //1- ensure the successful message is displayed
        status = register.successfulRegisterMessage().isDisplayed();
        soft.assertTrue(status);
        //2- ensure the message is ( Your registration completed )
        text = register.successfulRegisterMessage().getText();
        soft.assertEquals(text,"Your registration completed");

        //3-1 ensure message color is green rgba(76, 177, 124, 1)
        String colorMessage = register.successfulRegisterMessage().getCssValue("color");
        soft.assertEquals(colorMessage,"rgba(76, 177, 124, 1)");
        //3-2 ensure color of message with Hex color #4cb17c
        String colorHex = Color.fromString(colorMessage).asHex();
        soft.assertEquals(colorHex , "#4cb17c");

        // 4- verify that user could go to home page after registration by url is
        //4.1 user should press on continue button to go home page
        register.pressContinueButton().click();
        // get current url after click continue button equal https://demo.nopcommerce.com/
        url = Hooks.driver.getCurrentUrl();
        soft.assertEquals(url,"https://demo.nopcommerce.com/");


        soft.assertAll();
    }
}
