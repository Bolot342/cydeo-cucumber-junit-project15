package com.cydeo.step_definitions;

import com.cydeo.pages.WT_LoginPage;
import com.cydeo.pages.WT_OrderPage;
import com.cydeo.pages.WT_ViewAllOrderPage;
import com.cydeo.utlities.BrowserUtils;
import com.cydeo.utlities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;


public class WebTables_StepDefinitions {
    @Given("User is on the Web Table app login")
    public void user_is_on_the_web_table_app_login() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }

    WT_LoginPage WTLoginPage = new WT_LoginPage();

    @When("User enters correct userName")
    public void user_enters_correct_user_name() {
        WTLoginPage.userName.sendKeys("Test");
    }

    @When("User enters correct password")
    public void user_enters_correct_password() {
        WTLoginPage.password.sendKeys("Tester");
        BrowserUtils.sleep(3);
    }

    @When("User clicks to login button")
    public void user_clicks_to_login_button() {
        WTLoginPage.loginButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("User should see orders word in the URL")
    public void user_should_see_orders_word_in_the_url() {
        BrowserUtils.verifyURL("orders");
    }

    @When("User enters {string} username {string} password")
    public void userEntersUserNamePassword(String username, String password) {
        WTLoginPage.userName.sendKeys(username);
        WTLoginPage.password.sendKeys(password);

    }

    @When("User enters below correct credentials")
    public void userEntersBelowCorrectCredentials(Map<String, String> credentials) {
        WTLoginPage.userName.sendKeys(credentials.get("username"));
        WTLoginPage.password.sendKeys(credentials.get("password"));

    }

    @Given("User is already logged in to the Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {

        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        WTLoginPage.login("Test", "Tester");
        BrowserUtils.sleep(2);
    }

    WT_OrderPage orderPage = new WT_OrderPage();

    @When("User is on the Order page")
    public void user_is_on_the_order_page() {
        orderPage.viewOrder.click();
        BrowserUtils.sleep(2);
    }


    @Then("User sees below options under product dropdown")
    public void userSeesBelowOptionsUnderProductDropdown(List<String> expectedOptions) {

        List<String> actualOptions = BrowserUtils.dropdownsOptions_as_String(orderPage.productDropdown);

        Assert.assertEquals(actualOptions, expectedOptions);
        BrowserUtils.sleep(2);

    }


    @Then("User sees VISA as enabled payment option")
    public void userSeesVISAAsEnabledPaymentOption() {
        Assert.assertTrue(orderPage.visaRadioButton.isEnabled());
    }

    @Then("User sees MasterCard as enabled payment option")
    public void userSeesMasterCardAsEnabledPaymentOption() {
        Assert.assertTrue(orderPage.masterCardRadioButton.isEnabled());
    }

    @Then("User sees American Express as enabled payment option")
    public void userSeesAmericanExpressAsEnabledPaymentOption() {
        Assert.assertTrue(orderPage.americanExpressRadioButton.isEnabled());
    }




    @And("User enters quantity {string}")
    public void userEntersQuantity(String arg0) {
        //deleting existing number
        orderPage.quantity.clear();
        //other commend to delete the previous number
        //orderPage.quantity.sendKeys(Keys.BACK_SPACE);
        orderPage.quantity.sendKeys("2");
    }

    @And("User clicks to calculate button")
    public void userClicksToCalculateButton() {
        orderPage.calculateButton.click();
    }

    @And("User enters costumer name {string}")
    public void userEntersCostumerName(String name) {
        orderPage.inputName.sendKeys(name);
    }

    @And("User enters street {string}")
    public void userEntersStreet(String street) {
        orderPage.inputStreet.sendKeys(street);
    }

    @And("User enters city {string}")
    public void userEntersCity(String city) {
        orderPage.inputCity.sendKeys(city);
    }

    @And("User enters state {string}")
    public void userEntersState(String state) {
        orderPage.inputState.sendKeys(state);
    }

    @And("User enters zip code {string}")
    public void userEntersZipCode(String zipCode) {
        orderPage.inputZipCode.sendKeys(zipCode);
    }

    @And("User selects payment option {string}")
    public void userSelectsPaymentOption(String expectedCardType) {

        BrowserUtils.clickRadioButton(orderPage.cardTypes, expectedCardType);
        BrowserUtils.sleep(2);

    }

    @And("User enters credit card number {string}")
    public void userEntersCreditCardNumber(String cardNumber) {
        orderPage.inputCreditCard.sendKeys(cardNumber);
        BrowserUtils.sleep(2);
    }

    @And("User enters expiration date {string}")
    public void userEntersExpirationDate(String expDate) {
        orderPage.inputExpirationDate.sendKeys(expDate);
        BrowserUtils.sleep(2);
    }

    @And("User clicks to process order button")
    public void userClicksToProcessOrderButton() {
        orderPage.processOrderButton.click();
        BrowserUtils.sleep(2);
    }
    WT_ViewAllOrderPage wtViewAllOrderPage = new WT_ViewAllOrderPage();
    @Then("User should see {string} in the first row of the web table")
    public void userShouldSeeInTheFirstRowOfTheWebTable(String expectedName) {

        String actualName = wtViewAllOrderPage.newCustomerCell.getText();

        Assert.assertEquals(actualName,expectedName);


    }



}
