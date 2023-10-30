package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class Login {

    WebDriver driver;
    LoginPage loginPage;

    public LoginPage getLoginPage() {
        return loginPage;}

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage = this.getLoginPage();
        loginPage.gotoLoginPage();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actual = driver.getTitle();
        String expected = "Account Login";

        if (actual.equals(expected)) {
            System.out.println("Title is similar. Test case is Pass");
        }
    }
    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("clicks on Login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }
    @Then("user is navigates to the landing page successfully")
    public void user_is_navigates_to_the_landing_page_successfully() {
        loginPage.checkWelcmMsg();
    }
    @Then("user gets a valid error message")
    public void user_gets_a_valid_error_message() {
        loginPage.checkErrorMsg();
    }

}