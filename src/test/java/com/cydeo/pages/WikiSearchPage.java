package com.cydeo.pages;

import com.cydeo.utlities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {
    public WikiSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //@FindBy(id = "searchInput")
    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement searchBox;
    //@FindBy(xpath = "//button[@type='submit']")
    @FindBy(css = ".pure-button.pure-button-primary-progressive")
    public WebElement searchButton;
}
