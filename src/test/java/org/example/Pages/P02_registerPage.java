package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P02_registerPage {

    public WebElement titlePageRegister()
    {
        WebElement registerTitle = Hooks.driver.findElement(By.cssSelector("div[class=\"page registration-page\""));
        return registerTitle;
    }

    public List<WebElement> selectGenderType()
    {
         return Hooks.driver.findElements(By.cssSelector("div[id=\"gender\"] span"));
    }

    public WebElement Firstname(){

        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName(){

        return Hooks.driver.findElement(By.id("LastName"));
    }

    // element of day
    public WebElement dayList()
    {
        return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));
    }

    //element of month
    public WebElement monthList()
    {
        return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));
    }
    //element of year
    public WebElement yearList()
    {
        return Hooks.driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));
    }

    // locator of email
    public WebElement emailLabel()
    {
        return Hooks.driver.findElement(By.cssSelector("input[name=\"Email\"]"));
    }
    // locater of password
    public WebElement passwordlabel()
    {
        return  Hooks.driver.findElement(By.xpath("//input[@type=\"password\"] [@id=\"Password\"]"));
    }

    public WebElement confirmationPasswordlabel()
    {
        return  Hooks.driver.findElement(By.xpath("//input[@type=\"password\"] [@id=\"ConfirmPassword\"]"));
    }
    public WebElement companyLabel()
    {
        return Hooks.driver.findElement(By.name("Company"));
    }

    //element of register button
    public WebElement clickOnRegisterButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button[id=\"register-button\"]"));
    }

    // element of successful registration message
    public WebElement successfulRegisterMessage()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }

    // element of continue button that it appeared after clicking on register button to navigate home page
    public WebElement pressContinueButton()
    {
        return  Hooks.driver.findElement(By.cssSelector("a[class=\"button-1 register-continue-button\"]"));
    }
}
