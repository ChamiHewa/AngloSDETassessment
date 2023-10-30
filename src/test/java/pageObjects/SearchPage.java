package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class SearchPage {
    WebDriver uiDriver;

    By txt_search = By.id("filter_keyword");
    By ddl_productType = By.id("Search-category");
    By btn_search = By.xpath(".//i[@class=\"fa fa-search\"]");
    By searchResults = By.xpath("//*[@id=\"maincontainer\"]");

    public SearchPage(WebDriver driver){

        this.uiDriver = driver;
    }
    public void selectSearch(){

        uiDriver.findElement(txt_search).click();
    }
    public void enterSearch(String product){

        uiDriver.findElement(txt_search).sendKeys(product);
    }
    public void selectDropdown(){

        uiDriver.findElement(ddl_productType);
    }
    public void clickSearch(){

        uiDriver.findElement(btn_search).click();
    }
    public void resultsList(){

        uiDriver.findElement(searchResults);
    }
}
