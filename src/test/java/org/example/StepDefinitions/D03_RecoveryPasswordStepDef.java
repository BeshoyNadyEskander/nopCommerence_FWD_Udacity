package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_homePage;
import org.testng.asserts.SoftAssert;

public class D03_RecoveryPasswordStepDef extends variables {


    //class="bar-notification success"
       P01_homePage recovery = new P01_homePage();


    @Given("user should press on forget your password")
    public void recoveryPasswordPage()
    {
        recovery.goToLoginPage().click();
         recovery.forgotPasswordButton().click();
    }

    @When("user enter his valid email")
    public void userEnterHisValidEmail() throws InterruptedException {
        recovery.emailOfRecoveryPasswordLabel().sendKeys(getEmail());
        Thread.sleep(2000);
    }

    @When("user click on recover button")
    public void userClickOnRecoverButton()
    {
        //click on recover button
        recovery.recoveryPassButton().click();

    }

    @Then("validate that the message of recovery is displayed")
    public void validateThatTheMessageOfRecoveryIsDisplayed()
    {
        SoftAssert soft = new SoftAssert();
        // ensure recover message is displayed
       status = recovery.recoveryPasswordMessage().isDisplayed();
        soft.assertTrue(status);

        // ensure message is Email with instructions has been sent to you.
       setActualResult(recovery.recoveryPasswordMessage().getText());
         soft.assertEquals(getRecoveryMessage(),getActualResult());
      soft.assertAll();


    }
}
