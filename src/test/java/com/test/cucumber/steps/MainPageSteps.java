package com.test.cucumber.steps;


import com.test.cucumber.pages.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class MainPageSteps {
    public MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    private MainPage mainPage;


    @Given("^I choose task \"([^\"]*)\"$")
    public void iChooseTask(String taskNumber){
        mainPage.chooseTask(taskNumber);
    }
}
