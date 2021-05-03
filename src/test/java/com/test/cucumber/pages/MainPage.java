package com.test.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    final String SITE_URL = "https://testingcup.pgs-soft.com";

    public MainPage(BasePage basePage) {
        this.basePage = basePage;
    }

    private BasePage basePage;

    public void chooseTask(String taskNumber) {
        basePage.buttonClick(By.xpath("//h2[text()='Zadanie " + taskNumber + "']"));
    }

}
