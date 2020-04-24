package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebOrderPage extends BasePage {

    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$txtQuantity']")
    protected WebElement quantity;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$txtUnitPrice']")
    protected WebElement pricePerUnit;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$txtDiscount']")
    protected WebElement discount;
    @FindBy(css = "[value='Calculate']")
    protected WebElement calculateButton;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$txtTotal']")
    protected WebElement totalValue;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$txtName']")
    protected WebElement customerName;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$TextBox2']")
    protected WebElement street;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$TextBox3']")
    protected WebElement city;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$TextBox4']")
    protected WebElement state;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$TextBox5']")
    protected WebElement zip;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$TextBox6']")
    protected WebElement cardNr;
    @FindBy(css = "[name='ctl00$MainContent$fmwOrder$TextBox1']")
    protected WebElement expireDate;
    @FindBy(css = "[id='ctl00_MainContent_fmwOrder_InsertButton']")
    protected WebElement processButton;


    public void navigateTo(String orderName) {
        WebElement orderPage = driver.findElement(By.xpath("//a[text()='" + orderName + "']"));
        orderPage.click();
        BrowserUtilities.wait(3);
    }

    public void selectProduct(String nameOfProduct) {
        Select list = new Select(driver.findElement(By.cssSelector("[name='ctl00$MainContent$fmwOrder$ddlProduct']")));
        list.selectByVisibleText(nameOfProduct);
    }

    public void selectQuantity(String nameOfQuantity) {
        quantity.sendKeys(nameOfQuantity);
    }

    public void selectPricePerUnit(String price) {
        pricePerUnit.sendKeys(price);
    }

    public void selectDiscount(String discountDidjit) {
        discount.sendKeys(discountDidjit);
    }

    public void clickOnCalculateButton() {
        calculateButton.click();
        BrowserUtilities.wait(2);
    }

    public String getTotalValue() {
        return totalValue.getAttribute("value");
    }

    public void selectCustomerName(String name) {
        customerName.sendKeys(name);
    }

    public void selectStreet(String streetName) {
        street.sendKeys(streetName);
    }

    public void selectCity(String cityName) {
        city.sendKeys(cityName);
    }

    public void selectState(String stateName) {
        state.sendKeys(stateName);
    }

    public void selectZip(String zipCode) {
        zip.sendKeys(zipCode);
    }

    public void selectCard(String cardName) {
        driver.findElement(By.cssSelector("[name='ctl00$MainContent$fmwOrder$cardList'][value='" + cardName + "']")).click();
    }

    public void selectCardNr(String cardNumber) {
        cardNr.sendKeys(cardNumber);
    }

    public void selectExpireDate(String expireDataNumber) {
        expireDate.sendKeys(expireDataNumber);
        BrowserUtilities.wait(3);
    }

    public void selectProcessButton() {
        processButton.click();
        BrowserUtilities.wait(3);
    }

    public String verifiesOrderIsDisplayed(String eachElement) {
        String result = "";
        List<WebElement> list = driver.findElements(By.xpath("//table//tbody//tr//td//td"));
        for (WebElement each : list) {
            if (each.getText().equalsIgnoreCase(eachElement)) {
                result = each.getText();
                break;
            } else {
                result = "Falls !";
            }

        }
        return result;
    }

}