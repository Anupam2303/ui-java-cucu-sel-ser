package StepDefinitions;

import Pages.MidTransHome;
import Properties.WebProperties;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@BddStepDefinition
public class MindTransCheckoutSteps {

    WebProperties webProperties = new WebProperties();
    @Autowired
    private MidTransHome midTransHome;

    @Given("^Launch midtrans demo url in browser$")
    public void launchMidtransDemoUrlInBrowser() {
        String shopUrl = null;
        try {
            shopUrl = webProperties.get("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        midTransHome.openUrl(shopUrl);
    }
}
