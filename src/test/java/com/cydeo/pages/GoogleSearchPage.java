package com.cydeo.pages;

import com.cydeo.utlities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    //#1 - Create the constructor and initialize the driver with object
    //#2 - Use @FindBy instead of findElements()

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
            }
            @FindBy(name = "q")
            public WebElement searchBox;

}
