package com.weborders.step_definitions;

import com.weborders.pages.LoginPage;
import com.weborders.pages.WebOrderPage;
import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    WebOrderPage webOrderPage = new WebOrderPage();
    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtilities.wait(3);

    }

    @Given("user logs in")
    public void user_logs_in() {

        loginPage.login();
        BrowserUtilities.wait(3);
    }

    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String string) {
        webOrderPage.navigateTo(string);
    }

    @When("user enters product information")
    public void user_enters_product_information(List<Map<String, String>> dataTable) {
        webOrderPage.selectProduct(dataTable.get(0).get("Product"));
        webOrderPage.selectQuantity(dataTable.get(0).get("Quantity"));
        webOrderPage.selectPricePerUnit(dataTable.get(0).get("Price per unit"));
        webOrderPage.selectDiscount(dataTable.get(0).get("Discount"));
    }

    @When("user click on calculator button")
    public void user_click_on_calculator_button() {
        webOrderPage.clickOnCalculateButton();
    }

    @Then("user should verify that total {int} is displayed")
    public void user_should_verify_that_total_is_displayed(Integer int1) {
        String value = String.valueOf(int1);
        Assert.assertEquals(webOrderPage.getTotalValue(),value);
    }


    @When("user enters address information")
    public void user_enters_address_information(List<Map<String, String>> dataTable) {
        webOrderPage.selectCustomerName(dataTable.get(0).get("Customer name"));
        webOrderPage.selectStreet(dataTable.get(0).get("Street"));
        webOrderPage.selectCity(dataTable.get(0).get("City"));
        webOrderPage.selectState(dataTable.get(0).get("State"));
        webOrderPage.selectZip(dataTable.get(0).get("Zip"));

    }

    @When("user enters payment information:")
    public void user_enters_payment_information(List<Map<String, String>> dataTable) {
        webOrderPage.selectCard(dataTable.get(0).get("Card"));
        webOrderPage.selectCardNr(dataTable.get(0).get("Card Nr"));
        webOrderPage.selectExpireDate(dataTable.get(0).get("Expire date (mm/yy)"));

    }

    @When("user click on process button")
    public void user_click_on_process_button() {
        webOrderPage.selectProcessButton();

    }

    @And("user navigates to check {string} page")
    public void userNavigatesToCheckPage(String arg0) {
        webOrderPage.navigateTo(arg0);
    }


    @Then("user verifies that order is displayed")
    public void user_verifies_that_order_is_displayed(List<Map<String, String>> dataTable) {
        String name1Actual = webOrderPage.verifiesOrderIsDisplayed(dataTable.get(0).get("Name"));
        BrowserUtilities.wait(3);
        String name2Actual = webOrderPage.verifiesOrderIsDisplayed(dataTable.get(0).get("Product"));
        String name1Expected = dataTable.get(0).get("Name");
        String name2Expected = dataTable.get(0).get("Product");
        Assert.assertEquals(name1Actual,name1Expected);
        Assert.assertEquals(name2Actual,name2Expected);

    }


}

