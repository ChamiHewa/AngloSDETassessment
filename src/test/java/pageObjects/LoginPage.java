package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    WebDriver uiDriver;

    By loginNavLnk = By.xpath(".//a[text()='Login or register']");
    By mnu_accounts = By.xpath(".//span[text()='Account'][1]");
    By mnu_login = By.xpath("//*[@id='main_menu_top']/li[2]/ul/li[1]/a/span");
    By txt_username = By.id("loginFrm_loginname");
    By txt_password = By.id("loginFrm_password");
    By btn_login = By.xpath("//*[@id='loginFrm']/fieldset/button");
    By alrt_error = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div[1]");
    By alrt_welcome_msg = By.xpath("//*[@id=\"maincontainer\"]/div/div[2]/div[1]/h2");

    //creating a constructor as the same name as the class and define driver object here, so that we can use it in stepDef file
    public LoginPage (WebDriver driver){
        this.uiDriver = driver;
    }

    public void gotoLoginPage() {
        WebElement LoginNavigation = uiDriver.findElement(loginNavLnk);
        LoginNavigation.click();
    }
    public void enterUsername(String username){
        uiDriver.findElement(txt_username).sendKeys(username);
    }
    public void enterPassword(String password){

        uiDriver.findElement(txt_password).sendKeys(password);
    }
    public void clickLogin(){

        uiDriver.findElement(btn_login).click();
    }
    public void checkWelcmMsg(){
        WebElement welcomMsg = uiDriver.findElement(alrt_welcome_msg);
        if(welcomMsg.getText().contains("MY ACCOUNT")){
            System.out.println("Logged in successfully with valid credentials. Test case Pass");
        }
        else {
            System.out.println("Login fail. Testcase is Fail");
        }
    }
    public void checkErrorMsg(){
        WebElement errorMsg = uiDriver.findElement(alrt_error);
        if(errorMsg.getText().contains("Error: Incorrect login or password provided.")){
            System.out.println("Incorrect login or password provided. Login Failed. Test case Pass");
        }
        else {
            System.out.println("Login fail. Testcase is Fail");
        }
    }
}
