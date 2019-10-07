package Pages;

import Properties.WebProperties;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MidTransHome extends PageObject {

    @Autowired
    WebProperties webProperties;

    @FindBy(xpath = "//*[@class=\"price\"]/span[2]" )
    private WebElementFacade productPrice;

    @FindBy(xpath = "//*[@class=\"title\"]")
    private WebElementFacade productName;

    @FindBy(xpath = "//*[@class=\"desc\"]/span")
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

    public String get_ProductPrice(){
       return productPrice.getText();
    }

    public String get_ProductName(){
        return productName.getText();
    }

    public String get_ProductDesc(){
        return productName.getText();
    }

    public String get_ProductTag(){
        return productName.getText();
    }

    public String buyNow_text(){
        return buyNowButton.getText();
    }

    public void clickBuynow(){
        buyNowButton.click();
    }

    public void clickImagePrev(){
        buyNowButton.click();
    }

    public void clickImageNext(){
        buyNowButton.click();
    }

}
