package com.cydeo.pages;

import com.cydeo.utlities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WT_LoginPage {
    public WT_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    /*
    This method will log in with below credentials
    @username: Test
    @password: Tester
     */

    // for one user code
    public void login(){
        this.userName.sendKeys("Test");
        this.password.sendKeys("Tester");
        this.loginButton.click();
       }

   //This method will log in with credentials that are
    //provided in the method at the time of calling it
    //more reusable code
    public void login(String user, String password){
        this.userName.sendKeys("Test");
        this.password.sendKeys("Tester");
        this.loginButton.click();
    }





}
