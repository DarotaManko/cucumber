package com.test.cucumber.base;

import com.test.cucumber.utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    final String SITE_URL = "https://testingcup.pgs-soft.com";
    public static WebDriverWait webDriverWait;

    public void start(){
        WebDriverManager.chromedriver().setup();
        Driver.driver = new ChromeDriver();
        Driver.driver.manage().window().maximize();
        Driver.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Driver.driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        Driver.driver.get(SITE_URL);
        webDriverWait = new WebDriverWait(Driver.driver, 10);

    }
    public void finish(){
        Driver.driver.quit();
    }
}
