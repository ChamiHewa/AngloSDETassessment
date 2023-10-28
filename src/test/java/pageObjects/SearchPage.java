package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    By txt_search = By.id("filter_keyword");
    By ddl_productType = By.id("search-category");
    By btn_search = By.xpath("//*[@id=\"search_form\"]/div/div/i");
    By searchResults = By.xpath("//*[@id=\"maincontainer\"]");
    By alrt_msg = By.xpath("//*[@id=\"maincontainer\"]//*[contains(text(),'There is no product that matches the search criteria.')]");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectSearch(){
        driver.findElement(txt_search).click();
    }
    public void enterSearch(String product){
        driver.findElement(txt_search).sendKeys(product);
    }
    public void selectDropdown(){
        driver.findElement(ddl_productType);
    }
    public void clickSearch(){
        driver.findElement(btn_search).click();
    }
    public void resultsList(){
        driver.findElement(searchResults);
    }
    public void checkResultsMsg(){
        driver.findElement(alrt_msg);
    }
}
