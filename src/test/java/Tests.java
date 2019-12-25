import com.codeborne.selenide.Configuration;
import dataproviders.ConfigFileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.CalculatorPage;

public class Tests {
    @BeforeClass
    public static void setUp(){
        Configuration.baseUrl = new ConfigFileReader().getUrl();
    }

    @Test
    public void estimateInstancesTotalCost(){
        new CalculatorPage()
                .open()
                .setNumberOfInstances("4")
                .selectOperationSystem("Paid: Red Hat Enterprise Linux")
                .setHours("8")
                .addToEstimate()
                .shouldHaveTotalCost("Total Estimated Cost: USD 65.43 per 1 month");
    }
}
