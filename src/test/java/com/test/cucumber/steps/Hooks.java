package com.test.cucumber.steps;

import com.test.cucumber.base.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks{
    private TestBase testBase;

    public Hooks(TestBase testBase) {
        this.testBase = testBase;
    }

    @Before
    public void start(){
        testBase.start();
    }

    @After
    public void finish(){
        testBase.finish();
    }
}
