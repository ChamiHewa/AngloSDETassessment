package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.SearchPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Search {
    private WebDriver driver;
    //String url = "https://automationteststore.com/";
    SearchPage search;

//    @Before
//    public void browserInitialization(){
//        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
//
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(url);
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//    }
    @Given("that I am on the Home page")
    public void that_i_am_on_the_home_page() {
        search = new SearchPage(driver);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        String expected = "A place to practice your automation skills!";

        if (actual.equals(expected)) {
            System.out.println("Title is similar. Test case is Pass");
        }
    }
    @When("^I select the (.*)$")
    public void i_select_the_product_type(String product_type){
        search.selectSearch();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Get the items of the dropdown to a list
        List<WebElement> ddl = driver.findElements(By.id("Search-category"));
        //the option user wants to select
        String option = product_type;

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Iterate the list using for loop
        for (int i = 0; i < ddl.size(); i++) {
            if (ddl.get(i).getText().contains(option)) {
                ddl.get(i).click();
                System.out.println(option+" product type is selected");
                break;
            }
        }
    }
    @When("^I add (.*) to the Search box$")
    public void i_add_product_to_the_search_box(String product) {
        search.enterSearch(product);
    }
    @When("click the Search Button")
    public void click_the_search_button() {
        search.clickSearch();
    }
    @Then("^I should be able to see all the relevant Search results according to the (.*)$")
    public void i_should_be_able_to_see_all_the_relevant_search_results_according_to_the_product(String product) {
        //Fetch all the links Title
        List<WebElement> collection_product_links =
                driver.findElements(By.xpath("//*[@id=\"maincontainer\"]"));

        //Validate if Search result is displayed corresponding to the string which was searched
        for(int i = 0; i<collection_product_links.size();i++) {
            String temp = collection_product_links.get(i).getText();

            if ((temp.toLowerCase().contains(product.toLowerCase()))){
                Assert.assertTrue(true, product +" is displayed on product title. Product Title: " + temp + ". Hence Search results are correct");
            }else {
                Assert.assertTrue(false, product + " is not displayed on product title. Product Title: " + temp + ". Hence Search results are incorrect");
            }
        }
    }
    @Then("I should be able to see a text with No such Results")
    public void i_should_be_able_to_see_a_text_with_no_such_results() {
        search.checkResultsMsg();
    }
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
