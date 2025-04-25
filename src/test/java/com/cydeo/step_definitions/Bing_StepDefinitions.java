package com.cydeo.step_definitions;
import com.cydeo.pages.BingSearchPage;
import com.cydeo.utlities.BrowserUtils;
import com.cydeo.utlities.Driver;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class Bing_StepDefinitions {

    @Given("user is on the Bing search page")
    public void user_is_on_the_bing_search_page() {
        Driver.getDriver().get("https://www.bing.com");
        BrowserUtils.sleep(2);
    }
    BingSearchPage bingSearchPage = new BingSearchPage();
    @When("user enters orange in the Bing Search box")
    public void user_enters_orange_in_the_bing_search_box() {
    bingSearchPage.searchBox.sendKeys("orange"+ Keys.ENTER);
    BrowserUtils.sleep(2);
    }

    @Then("user should see orange in the title")
    public void user_should_see_orange_in_the_title() {
       BrowserUtils.verifyTitle("orange - Search");
           }



    @Then("user should {string} in the title")
    public void userShouldInTheTitle(String expectedTitle) {

        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("user enters {string} in the Bing Search box")
    public void userEntersInTheBingSearchBox(String searchBox) {

    }

    @Then("user should see orange - search in the title")
    public void userShouldSeeOrangeSearchInTheTitle() {

    }
}
