package pageobjects;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CalculatorPage {

    public CalculatorPage open(){
        Selenide.open("/products/calculator/");
        switchTo().innerFrame("myFrame");
        return this;
    }

    public CalculatorPage setNumberOfInstances(String number){
        $(By.name("quantity")).setValue(number);
        return this;
    }

    public CalculatorPage selectOperationSystem(String name){
        $("#select_value_label_47 .md-text").click();
        $(By.xpath("//*[text() = '"+name+"']")).click();
        return this;
    }

    public CalculatorPage setHours(String number){
        $(By.name("hours")).setValue("8");
        return this;
    }

    public CalculatorResults addToEstimate(){
        $(By.xpath("//*[@aria-label='Add to Estimate']")).click();
        return new CalculatorResults();
    }

}
