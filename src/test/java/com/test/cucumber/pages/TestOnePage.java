package com.test.cucumber.pages;

import com.test.cucumber.locators.TaskOneLocators;
import com.test.cucumber.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class TestOnePage {
    private BasePage basePage;
    private TaskOneLocators taskOneLocators;

    public TestOnePage(BasePage basePage, TaskOneLocators taskOneLocators) {
        this.basePage = basePage;
        this.taskOneLocators = taskOneLocators;
        basePage.pageFactoryInitElements(taskOneLocators);
    }


    public void addProduct(String productName) {
        Driver.driver.findElement(By.xpath("//h4[text()='" + productName + "']/../div/span/button")).click();

    }

    public void selectProductAmount(String productName, String howToSelect, String amount) throws InterruptedException {
        WebElement field = Driver.driver.findElement(By.xpath("//h4[text()='" + productName + "']/../div/input"));
        basePage.buttonClick(field);
        sleep(500);
        if (howToSelect.equals("numbers")) {
            basePage.fillInField(field, amount);
        } else if (howToSelect.equals("arrows")) {
            for (int i = 1; i <= Integer.parseInt(amount); i++) {
                field.sendKeys(Keys.ARROW_UP);
            }
        }
    }

    public boolean isProductInBasket(String productNameWithPrice) {
        return Driver.driver.findElements(By.xpath("//div[contains(@class,'in-basket')]/" +
                "div[text()='" + productNameWithPrice + "']")).size() > 0;

    }

    List<String> productsExpected = Arrays.asList("Okulary", "Piłka", "Kubek",
            "Kabel", "Słuchawki", "Kamera", "Aparat", "Poduszka", "Monitor", "Klawiatura", "Zeszyt", "Kostka");


    public List<String> getProductNames() {
        List<WebElement> productWebElements = Driver.driver.findElements(By.xpath("//div[@class='caption']/h4"));

        List<String> productsActual = new ArrayList<>();

        for (WebElement productWebElement : productWebElements) {
            productsActual.add(productWebElement.getText());
        }
        return productsActual;
    }

    public void isProductsInList(List<String> productsActual) {
        productsExpected.sort(Comparator.naturalOrder());
        productsActual.sort(Comparator.naturalOrder());

        for (int i = 0; i < productsExpected.size(); i++) {
            assertEquals(productsActual.get(i), productsExpected.get(i), "Products are not equal.");
        }
    }
    public void deleteProductFromBasket() {
        taskOneLocators.buttonDeleteFromBasket.click();
    }

    public String getProductAmountInBasket() {
        return taskOneLocators.labelProductAmountInBasket.getText();
    }

    public double getSummaryPrice() {
        String summaryPriceWithZl = Driver.driver.findElement(By.className("summary-price")).getText();
        return Double.parseDouble(summaryPriceWithZl.split("\\s")[0]);
    }
    HashMap<String, Double> productPrices = new HashMap<String, Double>();

    public HashMap<String, Double> getProductWithPrices() {
        productPrices.put("Okulary", 15.54);
        productPrices.put("Piłka", 39.22);
        productPrices.put("Kubek", 5.12);
        productPrices.put("Kabel", 4.22);
        productPrices.put("Słuchawki", 67.52);
        productPrices.put("Kamera", 34.26);
        productPrices.put("Aparat", 53.72);
        productPrices.put("Poduszka", 53.72);
        productPrices.put("Monitor", 53.72);
        productPrices.put("Klawiatura", 24.22);
        productPrices.put("Zeszyt", 0.99);
        productPrices.put("Kostka", 34.22);
        return productPrices;
    }
    public double getProductPriceByName(String productName) {
        return getProductWithPrices().get(productName);
    }

    public void isSummaryPriceEqualsProductPriceSum(List<String> productNames) {
        double summaryPrice = getSummaryPrice();
        double productPriceSum = 0;

        for (String product : productNames) {
            productPriceSum = productPriceSum + getProductPriceByName(product);
        }
        assertEquals(summaryPrice, productPriceSum, "Summary prise is not correct");
    }
    public String getPageTitle() {
        return Driver.driver.getTitle();
    }



}