package com.test.cucumber.pages;

import com.test.cucumber.base.TestBase;
import com.test.cucumber.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static com.test.cucumber.base.TestBase.webDriverWait;
import static java.lang.Thread.sleep;

public class BasePage{

    public void waitForElementVisibility(By elementBy){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitForElementVisibility(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void buttonClick(By elementBy){
        waitForElementVisibility(elementBy);
        Driver.driver.findElement(elementBy).click();
    }

    public void buttonClick(WebElement element){
        waitForElementVisibility(element);
        element.click();
    }

    public void fillInField(By elementBy, String value){
        waitForElementVisibility(elementBy);
        Driver.driver.findElement(elementBy).clear();
        Driver.driver.findElement(elementBy).sendKeys(value);
    }

    public void fillInField(WebElement element, String value){
        waitForElementVisibility(element);
        element.clear();
        element.sendKeys(value);
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = Driver.driver.switchTo().alert().getText();
        Driver.driver.switchTo().alert().accept();
        return alertText;
    }

    public boolean isFilePresent() throws IOException {
        List<File> files =  Files.find(Paths.get("target"),
                Integer.MAX_VALUE,
                (filePath, fileAttr) -> fileAttr.isRegularFile())
                .map(Path::toFile)
                .filter(f->f.getName().endsWith(".jpg"))
                .collect(Collectors.toList());
        return !files.isEmpty();
    }
    public void waitForDownload() throws InterruptedException {
        sleep(2000);
    }

    public void pageFactoryInitElements(Object pageObject){
        PageFactory.initElements(Driver.driver, pageObject);
    }
}
