package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CalculatorResults {
    private final SelenideElement resultBlock = $(By.id("resultBlock"));

    public CalculatorResults shouldHaveTotalCost(String value){
        resultBlock.$(By.className("md-title")).shouldHave(text(value));
        return this;
    }
}
