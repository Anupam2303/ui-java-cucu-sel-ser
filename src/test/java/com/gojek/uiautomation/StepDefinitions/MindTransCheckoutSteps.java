package com.gojek.uiautomation.Base.StepDefinitions;

import static com.gojek.uiautomation.Base.Data.Utils.waitAWhile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import com.gojek.uiautomation.Base.Data.Utils;
import com.gojek.uiautomation.Base.Pages.MidTransHome;
import com.gojek.uiautomation.Base.Properties.WebProperties;

@BddStepDefinition
public class MindTransCheckoutSteps extends ScenarioSteps {

    private String itemImage = null;

    private WebProperties webProperties = new WebProperties();

    private MidTransHome midTransHome;

    private Utils utils;

    @Given("^gets midtrans demo url$")
    public void getsMidtransDemoUrl()throws IOException {
        String shopUrl = null;
            shopUrl = webProperties.get("url");
        midTransHome.openUrl(shopUrl);
        waitAWhile(100);
    }

    @When("^user opens with midtrans demo shop on provided browser$")
    public void userOpensWithMidtransDemoShopOnProvidedBrowser() throws IOException {
        assertThat("URL doesnot matches",midTransHome.getDriver().getCurrentUrl(),equalTo(webProperties.get("url")));
    }

    @Then("^user verifies midtrans demo shop page$")
    public void userVerifiesMidtransDemoShopPage() throws IOException {
        assertThat("Tittles does not matches",midTransHome.getDriver().getTitle(),equalTo(webProperties.get("homePageTittle")));
        String sourcecode = midTransHome.getDriver().getPageSource();
        System.out.println(sourcecode);
    }

    @And("^user checks for product name$")
    public void userChecksForproductName() throws IOException {
        String productName = midTransHome.get_ProductName();
        assertThat("Product name does not matches",productName,equalTo(webProperties.get("productName")));
    }

    @And("^user checks for product tag$")
    public void userChecksForproductTag() throws IOException {
        assertThat("Product tag does not matches",midTransHome.get_ProductTag(),equalTo(webProperties.get("productTag")));
    }

    @And("^user checks for product desc$")
    public void userChecksForproductDesc() throws IOException {
        assertThat("Product desc does not matches",midTransHome.get_ProductDesc().contains(webProperties.get("productDesc")),equalTo(true));
    }

    @And("^user checks for product price$")
    public void userChecksForproductPrice() throws IOException {
        assertThat("Product price does not matches",midTransHome.get_ProductPrice(),equalTo(webProperties.get("productPrice")));
    }

    @When("^user click on carousel next to view product pics$")
    public void userClickOnCarouselNextToViewProductPics() {
        itemImage = midTransHome.getDriver().findElement(By.xpath("//div[@class=\"item active\"]/div")).getAttribute("style");
        System.out.println("111111"+ itemImage);
        midTransHome.clickImageNext();
        System.out.println(itemImage);
        utils.waitABit(100);
    }

    @Then("^verify image changes once user clicks on it$")
    public void verifyImageChangesOnceUserClicksOnIt() {
        String newItemImage = midTransHome.getDriver().findElement(By.xpath("//div[@class=\"item active\"]/div")).getAttribute("style");
        assertThat("Image didn't changes", itemImage.equals(newItemImage),equalTo(false));
    }

    @When("^user clicks on buynow to purchase product$")
    public void userClicksOnBuynowToPurchaseProduct() {
        midTransHome.clickBuynow();
    }

    @Then("^verify price in checkout page$")
    public void verifyPriceInCheckoutPage() throws IOException {
        assertThat("Price doesnot matched", midTransHome.get_cartPrice(),equalTo(webProperties.get("productPrice")));
    }

    @And("^verify name, address, contact number is available$")
    public void verifyNameAddressContactNumberIsAvailable() throws IOException {
        assertThat("Name doesnot matched", midTransHome.get_cartName(),equalTo(webProperties.get("checkOutName")));
        assertThat("Email Id doesnot matched", midTransHome.get_cartEmail(),equalTo(webProperties.get("checkOutEmail")));
        assertThat("Address doesnot matched", midTransHome.get_cartAddress(),equalTo(webProperties.get("checkOutAddress")));
    }

    @When("^user clicks on checkout button$")
    public void userClicksOnCheckoutButton() {
        midTransHome.clickcheckoutbtn();
        utils.waitABit(100);
    }

    @Then("^verify product name and price$")
    public void verifyProductNameAndPrice() throws IOException {
        utils.waitABit(100);
        midTransHome.switch_framemMidTransApp();
        utils.waitABit(100);
        assertThat("Name doesnot matched", midTransHome.get_checkoutItem(),equalTo(webProperties.get("productName")));
        assertThat("Price doesnot matched", midTransHome.get_checkoutPrice(),equalTo(webProperties.get("productPrice")));
    }

    @And("^verify customer name and email id$")
    public void verifyCustomerNameAndEmailId() throws IOException {
        midTransHome.clickShippingTab();
        utils.waitABit(100);
        assertThat("Name doesnot matched", midTransHome.get_checkoutName(),equalTo(webProperties.get("checkOutName")));
        assertThat("Email Id doesnot matched", midTransHome.get_checoutEmail(),equalTo(webProperties.get("checkOutEmail")));
    }

    @When("^user clicks continue checkout$")
    public void userClicksContinueCheckout() {
        midTransHome.clickContinueCheckoutbtn();
        utils.waitABit(100);
    }

    @And("^user select creditcard as payment option$")
    public void userSelectCreditcardAsPaymentOption() {
        utils.waitABit(300);
        midTransHome.clickCreditcardOption();
        utils.waitABit(100);
    }

    @Then("^user verifies order amount$")
    public void userVerifiesOrderAmount() throws IOException {
        utils.waitABit(100);
        assertThat("Price doesnot matched", midTransHome.get_checkoutPrice(),equalTo(webProperties.get("productPrice")));
    }

    @When("^user enter card number '(.*)'$")
    public void userEnterCardNumber(String cardnumber) {
        midTransHome.enter_Cardnumeber(cardnumber);
    }

    @And("^enters expirydate and cvv '(.*)' '(.*)'$")
    public void entersExpirydateAndCvv(String expiry,String cvv) {
        midTransHome.enter_Expiry(expiry);
        midTransHome.enter_CVV(cvv);
    }

    @And("^enters OTP '(.*)'$")
    public void entersOTP(String otp) {
        utils.waitABit(500);
        WebElement element = midTransHome.getDriver().findElement((By.tagName("iframe")));
        midTransHome.getDriver().switchTo().frame(element);
        utils.waitABit(100);
        WebDriverWait wait=new WebDriverWait(midTransHome.getDriver(),20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='PaRes']")));
        midTransHome.enter_OTP(otp);
        utils.waitABit(500);
        midTransHome.clickOkOTPBtn();
    }

    @And("^clicks on paynow$")
    public void clicksOnPaynow() {
        utils.waitABit(100);
        midTransHome.clickPaynow();
    }

    @And("^verify success msg on homepage$") public void verifySuccessMsgOnHomepage() {
        waitAWhile(500);
        midTransHome.getDriver().switchTo().defaultContent();
        assertThat("Purchase is not success",midTransHome.get_PurchaseSuccess().contains("Thank you for your purchase."),equalTo(true));
    }

    @Then("^verify transaction is successfull$") public void verifyTransactionIsSuccessfull() {
        midTransHome.getDriver().switchTo().defaultContent();
        midTransHome.switch_framemMidTransApp();
        assertThat("Purchase is not success",midTransHome.get_transactionSuccess(),equalTo("Transaction successful"));
    }

    @Then("^verify error message '(.*)'$")
    public void verifyErrorMessageInvalidCardNumber(String errorMsg) {
        assertThat("Error message doesnot matched",midTransHome.get_invalidCardMessage(),equalTo(errorMsg));
    }
}
