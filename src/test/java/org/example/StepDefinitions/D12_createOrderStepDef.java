package org.example.StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.Pages.P06_cartShoppingPage;
import org.example.Pages.P08_createOrderPage;
import org.testng.Assert;

import java.util.Random;

public class D12_createOrderStepDef {

    P08_createOrderPage createOrder = new P08_createOrderPage();
    Faker fake;


    @And("user navigate to shopping cart page to make order")
    public void userNavigateToShoppingCartPageToMakeOrder()
    {
        // should pree on button shopping cart
        createOrder.shoppingcartButt().click();
    }

    @And("user should agree with the terms of service before pressing checkout")
    public void userShouldAgreeWithTheTermsOfServiceBeforePressingCheckout()
    {
       createOrder.pressOnConditionsBeforeCheckout().click();
    }

    @And("user could press on checkout button to make order")
    public void clickOnCheckOut()
    {
          createOrder.CheckoutButton().click();
    }


    @And("user select his country")
    public void userSelectHisCountry()
    {
        int countCountry = createOrder.SelectCountry().size();

        //select rondom
        int selectedContry = new Random().nextInt(countCountry);
        // click on selected
        createOrder.SelectCountry().get(selectedContry).click();
    }

    @And("user should enter his city")
    public void userShouldEnterHisCity()
    {
        fake = new Faker();
        String city = fake.country().capital();
        createOrder.enterCity().sendKeys(city);
        configuration.set("city" , city);
    }

    @And("user should enter his address")
    public void userShouldEnterHisAddress()
    {
        fake = new Faker();
        String address = fake.address().streetAddress();
        createOrder.enterAddress().sendKeys(address);
        configuration.set("address",address);
    }

    @And("user should enter his postalCode")
    public void userShouldEnterHisPostalCode()
    {
       String code = configuration.get("code");
       createOrder.enterPostalcode().sendKeys(code);
    }

    @And("user could phone number")
    public void userCouldPhoneNumber()
    {
        fake = new Faker();
        String phone = fake.phoneNumber().cellPhone();
      createOrder.phoneNumber().sendKeys(phone);
      configuration.set("phone" , phone);
    }

    @And("create successful order")
    public void clickOnContinueButton()
    {
        // click on continue button to follow process
        createOrder.pressContinue().click();
        // confirm process buying
        createOrder.continuebut().click();
        // choose payment type to continue process
        createOrder.paymentbuttonContinue().click();
        //confirm payment process
        createOrder.payConfirmButton().click();
        // confirm order to create
        createOrder.confirmOrder().click();
    }

    @Then("validate that create order is made successfully")
    public void validateThatCreateOrderIsMadeSuccessfully()
    {
        boolean titleSuccess = createOrder.titleSuccessfulOrder().isDisplayed();
        Assert.assertTrue(titleSuccess);

        createOrder.completeProcess().click();
    }
}
