package com.cydeo.step_definitions;
import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utlities.BrowserUtils;
import com.cydeo.utlities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
public class Google_StepDefinitions {



    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user searches for apple")
    public void userSearchesForApple() {
        //System.out.println("user searches for apple");
    googleSearchPage.searchBox.sendKeys("apple"+Keys.ENTER);


    }


    @Then("user should see apple in the title")
    public void userShouldSeeAppleInTheTitle() {
        System.out.println("user should see apple in the title");
    BrowserUtils.verifyTitle("apple - Google Search");
    }


    @When("user is on the Google search page")
    public void userIsOnTheGoogleSearchPage() {
        Driver.getDriver().get("https://www.google.com");
        BrowserUtils.sleep(3);

    }

    @Then("user should see title is google")
    public void userShouldSeeTitleIsGoogle() {
    }

}

