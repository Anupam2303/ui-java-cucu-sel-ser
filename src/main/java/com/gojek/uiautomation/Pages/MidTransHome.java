package Pages;

import Data.Utils;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MidTransHome extends PageObject {

    @Autowired Utils utils;

    @FindBy(xpath = "//*[@class=\"price\"]/span[2]")
    private WebElementFacade productPrice;

    @FindBy(xpath = "//*[@class='title']")
    private WebElementFacade productName;

    @FindBy(xpath = "//span[contains(text(),'Get cozy with our new pillow!')]")
    private WebElementFacade productTag;

    @FindBy(xpath = "//*[@class=\"desc\"]/i")
    private WebElementFacade productDesc;

    @FindBy(xpath = "//a[@data-slide=\"next\"]")
    private WebElementFacade imagePrev;

    @FindBy(xpath = "//a[@data-slide=\"next\"]")
    private WebElementFacade imageNext;

    @FindBy(xpath = "//*[@class=\"btn buy\"]")
    private WebElementFacade buyNowButton;

    @FindBy(xpath = "//div[@class=\"item active\"]")
    private WebElementFacade imageActive;

    @FindBy(xpath = "//td[@class='amount']")
    private WebElementFacade cartTotalPrice;

    @FindBy(xpath = "//tr[1]//td[2]//input[1]")
    private WebElementFacade cartOutName;

    @FindBy(xpath = "//tr[2]//td[2]//input[1]")
    private WebElementFacade cartEmail;

    @FindBy(xpath = "//tr[5]//td[2]/textarea")
    private WebElementFacade cartAddress;

    @FindBy(xpath = "//div[@class='cart-checkout']")
    private WebElementFacade checkoutbtn;

    @FindBy(xpath = "//*[@class='text-amount-amount']")
    private WebElementFacade checkoutPrice;

    @FindBy(xpath = "//*[@class='item-name']")
    private WebElementFacade checkoutItemName;

    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    private WebElementFacade framemMidTransApp;

    @FindBy(xpath = "//span[contains(text(),'shipping details')]")
    private WebElementFacade checkoutShippingTab;

    @FindBy(xpath = "//div[@class='col-xs-6'][1]/div[@class='text-block'][1]/div[2]")
    private WebElementFacade checkoutName;

    @FindBy(xpath = "//div[@class='col-xs-6'][1]/div[@class='text-block'][3]/div[2]")
    private WebElementFacade checoutEmail;

    @FindBy(xpath = "//div[@class='button-main show']")
    private WebElementFacade continueCheckout;

    @FindBy(xpath = "//div[@id='payment-list']/div/a[@href='#/credit-card']")
    private WebElementFacade creditCardOption;

    @FindBy(xpath = "//input[@name='cardnumber']")
    private WebElementFacade inputCardnumber;

    @FindBy(xpath = "//div[@class='input-group col-xs-7']/input")
    private WebElementFacade inputExpiry;

    @FindBy(xpath = "//div[@class='input-group col-xs-5']/input")
    private WebElementFacade inputCVV;

    @FindBy(xpath = "//div[@class='button-main show']")
    private WebElementFacade paynowBtn;

    @FindBy(xpath = "//input[@id='PaRes']")
    public WebElementFacade inputOTP;

    @FindBy(xpath = "//span[contains(text(),'Invalid card number')]")
    private WebElementFacade invalidCradMessage;

    public String get_ProductPrice() {
        return productPrice.getText();
    }

    public String get_ProductName() {
        return productName.getText();
    }

    public String get_ProductDesc() {
        return productDesc.getText();
    }

    public String get_ProductTag() {
        return productTag.getText();
    }

    public String get_cartPrice() {
        return cartTotalPrice.getText();
    }

    public String get_cartName() {
        return cartOutName.getAttribute("value");
    }

    public String get_cartEmail() {
        return cartEmail.getAttribute("value");
    }

    public String get_cartAddress() {
        return cartAddress.getText();
    }

    public String get_checkoutPrice() {
        return checkoutPrice.getText();
    }

    public String get_checkoutItem() {
        return checkoutItemName.getText();
    }

    public String get_checkoutName() {
        return checkoutName.getText();
    }

    public String get_checoutEmail() {
        return checoutEmail.getText();
    }

    public String get_invalidCardMessage() {
        return invalidCradMessage.getText();
    }

    public void clickShippingTab() {

        checkoutShippingTab.click();
    }

    public void clickBuynow() {
        buyNowButton.click();
    }

    public void clickcheckoutbtn() {
        checkoutbtn.click();
    }

    public void clickContinueCheckoutbtn() {
        continueCheckout.click();
    }

    public void clickCreditcardOption() {
        creditCardOption.click();
    }

    public void clickPaynow() {
        paynowBtn.click();
    }

    public void clickImagePrev() {
        imagePrev.click();
    }

    public void clickImageNext() {
        imageNext.click();
    }

    public void switch_framemMidTransApp() {
        getDriver().switchTo().frame(framemMidTransApp);
    }

    public void enter_Cardnumeber(String cardnumber){
        inputCardnumber.sendKeys(cardnumber);
    }

    public void enter_Expiry(String expiry){
        inputExpiry.sendKeys(expiry);
    }

    public void enter_CVV(String cvv){
        inputCVV.sendKeys(cvv);
    }

    public void enter_OTP(String otp){
        inputOTP.click();
        inputOTP.sendKeys(otp);
//        Action moveToOTP = utils.performAction(inputOTP,otp);
//        moveToOTP.perform();
    }

    public String getStyleImageActive() {
        return imageActive.getAttribute("style");
    }

}
