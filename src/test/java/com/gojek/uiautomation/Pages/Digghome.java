package com.gojek.uiautomation.Pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class Digghome extends PageObject {

    @FindBy(xpath = "//*[@class=\"search\"]")
    private WebElementFacade searchHome;

    @FindBy(xpath = "//*[@name=\"q\"]")
    private WebElementFacade searchBox;

    @FindBy(xpath = "//h1[@class=\"center\"]")
    private WebElementFacade searchCommonText;

    @FindBy(xpath = "//*[@class=\"results\"]")
    private WebElementFacade searchResults;

    @FindBy(xpath = "//article")
    private List<WebElementFacade> searcharticle;

    public void click_searchHome() {
        searchHome.click();
    }

    public void enter_searchBox(String text) {
        searchBox.sendKeys(text + Keys.ENTER);
    }

    public String get_searchCommonText() {
       return searchCommonText.getText();
    }

    public int articlesize() {
       return searcharticle.size();
    }

    /*
    * Sub-header elements
    * */

    @FindBy(partialLinkText = "Picks")
    private WebElementFacade linkPicks;

    @FindBy(partialLinkText = "Video")
    private WebElementFacade linkVideo;

    @FindBy(partialLinkText = "Longreads")
    private WebElementFacade linkLongReads;

    @FindBy(partialLinkText = "Tech")
    private WebElementFacade linkTech;

    @FindBy(partialLinkText = "News")
    private WebElementFacade linknews;

    public void click_linkPicks() {
        linkPicks.click();
    }

    public void click_linkVideo() {
        linkVideo.click();
    }

    public void click_linkLongReads() {
        linkLongReads.click();
    }

    public void click_linkTech() {
        linkTech.click();
    }

    public void click_linklinknews() {
        linknews.click();
    }


}
