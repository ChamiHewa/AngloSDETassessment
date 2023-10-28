package stepDefinitions;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    LoginPage login;
    String url = "https://automationteststore.com/";

    @Before
    public void browserInitialization(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        login = new LoginPage(driver);
        login.gotoLoginPage();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        String expected = "Account Login";

        if (actual.equals(expected)) {
            System.out.println("Title is similar. Test case is Pass");
        }
    }
    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        login.enterUsername(username);
        login.enterPassword(password);
    }
    @When("clicks on Login button")
    public void clicks_on_login_button() {
        login.clickLogin();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }
    @Then("user is navigates to the landing page successfully")
    public void user_is_navigates_to_the_landing_page_successfully() {
        login.checkWelcmMsg();
    }
    @Then("user gets a valid error message")
    public void user_gets_a_valid_error_message() {
        login.checkErrorMsg();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}