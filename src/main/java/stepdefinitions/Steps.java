package stepdefinitions;

import com.codeborne.selenide.Configuration;
import dataproviders.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageobjects.CalculatorPage;
import pageobjects.CalculatorResults;

public class Steps {
    private CalculatorPage calculatorPage;
    private CalculatorResults calculatorResults;

    @Given("Open the Calculator page")
    public void openTheCalculatorPage(){
        Configuration.baseUrl = new ConfigFileReader().getUrl();
        calculatorPage = new CalculatorPage();
        calculatorPage.open();
    }

    @When("Specify Number of Instances as {string}")
    public void specifyNumberOfInstancesAs(String value){
        calculatorPage.setNumberOfInstances(value);
    }

    @And("Specify Operation System as {string}")
    public void specifyOperationSystemAs(String value) {
        calculatorPage.selectOperationSystem(value);
    }

    @And("Specify Hours as {string}")
    public void specifyHoursAs(String value) {
        calculatorPage.setHours(value);
    }

    @And("Click Add To Estimate")
    public void clickAddToEstimate() {
        calculatorResults = calculatorPage.addToEstimate();
    }

    @Then("Estimate equals {string}")
    public void estimateEquals(String value) {
        calculatorResults.shouldHaveTotalCost(value);
    }


}
