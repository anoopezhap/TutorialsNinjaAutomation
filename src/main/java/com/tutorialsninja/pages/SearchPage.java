package com.tutorialsninja.pages;

import com.tutorialsninja.base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends PageBase {
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "search")
    private WebElement search;
    @FindBy(xpath = "//i[@class=\"fa fa-search\"]")
    private WebElement enterSearch;

    @FindBy(xpath = "//div[@class=\"product-thumb\"]//a" )
    private List<WebElement> productlist;

    @FindBy(xpath = "//*[@id=\"content\"]/p[2]")
    private WebElement noProduct;


    public void enterProduct(String enteredProduct)
    {
        search.sendKeys(enteredProduct);
        enterSearch.click();
    }

    public boolean validProduct(String enteredProduct)
    {
        enterProduct(enteredProduct);
       for(WebElement product : productlist)
       {
           if(product.getText().toLowerCase().contains(enteredProduct.toLowerCase()))
           {
               return true;
           }

       }
        return false;
    }

    public boolean invalidProduct(String enteredProduct)
    {
        enterProduct(enteredProduct);
        return noProduct.isDisplayed();
    }

}
