package com.test.cucumber.steps;


import com.test.cucumber.pages.TestOnePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.AssertJUnit.assertEquals;

public class TaskOneSteps {
    public TaskOneSteps(TestOnePage testOnePage) {
        this.testOnePage = testOnePage;
    }

    private TestOnePage testOnePage;


    @When("^I select product \"([^\"]*)\" using \"([^\"]*)\" with amount of \"([^\"]*)\"$")
    public void iSelectProductUsingWithAmountOf(String productName, String howToSelect, String amount) throws Throwable {
        testOnePage.selectProductAmount(productName, howToSelect,amount);
    }

    @And("^I click on add product for \"([^\"]*)\"$")
    public void iClickOnAddProductFor(String productName){
        testOnePage.addProduct(productName);
    }

    @Then("^I see in basket \"([^\"]*)\"$")
    public void iSeeInBasket(String productInBasketText){
        testOnePage.isProductInBasket(productInBasketText);

    }
      @When("^I see all the products$")
      public void iSeeAllTheProducts(){
        testOnePage.isProductsInList(testOnePage.getProductNames());

      }


    @And("^I delete product from basket$")
    public void iDeleteProductFromBasket(){
        testOnePage.deleteProductFromBasket();
    }

    @Then("^I want to check that basket is empty$")
    public void iWantToCheckTheResult(){
     assertEquals(testOnePage.getProductAmountInBasket(),"0","product amount in basket is not equals");
    }
}
