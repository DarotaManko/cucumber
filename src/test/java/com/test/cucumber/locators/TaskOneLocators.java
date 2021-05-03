package com.test.cucumber.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskOneLocators {
    @FindBy(xpath = "//button[text()='Usuń']")
    public WebElement buttonDeleteFromBasket;

    @FindBy(className = "summary-quantity")
    public WebElement labelProductAmountInBasket;
}
