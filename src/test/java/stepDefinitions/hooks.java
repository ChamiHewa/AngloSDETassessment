//package stepDefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class hooks {
//    WebDriver driver;
//    String url = "https://automationteststore.com/";
//
//    @Before
//    public void browserInitialization(){
//        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
//
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(url);
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}
