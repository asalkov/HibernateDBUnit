package com.ansa.bdd;


import com.ansa.trader.Stock;
import com.ansa.trader.TraderService;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;



public class TraderSteps {
    private TraderService service = new TraderService();

    private Stock stock;

    @Given("a stock and a threshold of $ithreshold")
    public void aStock(double ithreshold){
        System.out.println("a stock");
        stock = service.newStock("STK", ithreshold);
    }

    @When("the stock is traded at price $price")
    public void theStockIsTraded(double price){
        stock.tradeAt(price);
    }

    @Then("the alert status is $status")
    public void theAlertStatusIs(String status){
        Assert.assertEquals(status, stock.getStatus());
    }

}
