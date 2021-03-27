package com.gojek.uiautomation.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

import org.junit.Assert;

import com.gojek.uiautomation.Data.Utils;
import com.gojek.uiautomation.Pages.Digghome;
import com.gojek.uiautomation.Pages.MidTransHome;
import com.gojek.uiautomation.Properties.WebProperties;

@BddStepDefinition
public class DiggSteps {


    private WebProperties webProperties = new WebProperties();

    private Digghome digghome;

    private Utils utils;

    @Given("^user navigate to digg\\.com main website$") public void userNavigateToDiggComMainWebsite() throws IOException {
        String diggURL = webProperties.get("diggUrl");
        digghome.openUrl(diggURL);
    }

    @When("^user click on search icon$") public void userClickOnSearchIcon() {
        digghome.click_searchHome();

    }

    @Then("^user should redirect to search page$") public void userShouldRedirectToSearchPage() throws InterruptedException {
        String currentURL = digghome.getDriver().getCurrentUrl();
        Assert.assertEquals(currentURL,"https://digg.com/search");

    }

    @When("^user enter 'COVID' text to search$") public void userEnterCOVIDTextToSearch() {
        digghome.enter_searchBox("COVID");

    }

    @And("^user press enter button$") public void userPressEnterButton() {

    }

    @Then("^user should get covid related results$") public void userShouldGetCovidRelatedResults() {
        int size = digghome.articlesize();
        Assert.assertEquals(size,20);
    }

    @Then("^user should get message '(.*)'$")
    public void userShouldGetMessageYouProbablyKnowHowToUseASearchEngineButInCaseYouDonTJustTypesomeKeywordsInTheLittleBoxAbove(String message) {

    }

    @When("^user clicks on tech$") public void userClicksOnTech() {

    }

    @Then("^user should redirect to picks page$") public void userShouldRedirectToPicksPage() {

    }

    @When("^user clicks on picks$") public void userClicksOnPicks() {

    }

    @When("^user clicks on video$") public void userClicksOnVideo() {

    }

    @Then("^user should redirect to video page$") public void userShouldRedirectToVideoPage() {

    }

    @When("^user clicks on longreads$") public void userClicksOnLongreads() {

    }

    @Then("^user should redirect to longreads page$") public void userShouldRedirectToLongreadsPage() {

    }

    @When("^user clicks on news$") public void userClicksOnNews() {

    }

    @Then("^user should redirect to news page$") public void userShouldRedirectToNewsPage() {

    }

    @When("^user clicks on science$") public void userClicksOnScience() {

    }

    @Then("^user should redirect to science page$") public void userShouldRedirectToSciencePage() {
    }
}
