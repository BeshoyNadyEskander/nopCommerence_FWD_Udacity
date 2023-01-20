package org.example.Pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P01_homePage {


    public WebElement goToRegisterPage()
    {
        WebElement registerButton = Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
        return registerButton;
    }

    // element of login button to go login page
    public WebElement goToLoginPage()
    {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }
    // element of email
    public WebElement emailLabelLogin()
    {
        return Hooks.driver.findElement(By.cssSelector("input[data-val-required=\"Please enter your email\"]"));
    }
    //element of password
    public WebElement passwordlLabelLogin()
    {
        return Hooks.driver.findElement(By.cssSelector("input[class=\"password\"]"));
    }


    public WebElement pressOnLoginButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }

    //after logging in home page we should logout button appeared
    public WebElement logoutButton()
    {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-logout\"]"));
    }

    //locator of forgot password
    public WebElement forgotPasswordButton()
    {
        return Hooks.driver.findElement(By.cssSelector("span[class=\"forgot-password\"]"));
    }

    // email recover password
    public WebElement emailOfRecoveryPasswordLabel()
    {
        return Hooks.driver.findElement(By.cssSelector("input[id=\"Email\"]"));
    }
    // locater of recovery password button
    public WebElement recoveryPassButton()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 password-recovery-button\"]"));
    }
    //element of recovery message
    public WebElement recoveryPasswordMessage()
    {
        return Hooks.driver.findElement(By.xpath("//p [contains(text(),'Email with instructions has been sent to you.')]"));
    }

    // element of currency button
      public WebElement selectCurrency()
      {
          return Hooks.driver.findElement(By.cssSelector("select[id=\"customerCurrency\"]"));

      }
      public List <WebElement> currencySymbol()
      {
          return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
      }
}
