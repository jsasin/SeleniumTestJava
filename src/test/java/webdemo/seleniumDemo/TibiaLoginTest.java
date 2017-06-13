package webdemo.seleniumDemo;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by sasin on 12.06.2017.
 */
public class TibiaLoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Before
    public void before(){
        WebDriverWait wait = new WebDriverWait(driver, 2);
        driver.get("https://secure.tibia.com/account/?subtopic=accountmanagement");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Login")));
    }


    @Test
    public void loginBadLogin(){
        WebElement login = driver.findElement(By.name("loginname"));
        WebElement password = driver.findElement(By.name("loginpassword"));
        WebElement btn = driver.findElement(By.name("Login"));
        login.sendKeys("zepsutylogin");
        password.sendKeys("tester01");
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("Bulbator Bulbasek"));
    }

    @Test
    public void loginBadPass() {
        WebElement login = driver.findElement(By.name("loginname"));
        WebElement password = driver.findElement(By.name("loginpassword"));
        WebElement btn = driver.findElement(By.name("Login"));
        login.sendKeys("testowytest");
        password.sendKeys("zepsutehaslo");
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        String pageSource = driver.getPageSource();
        Assert.assertNotNull(driver.findElement(By.name("Login")));
    }

    @Test
    public void loginSuccess() {
        WebElement login = driver.findElement(By.name("loginname"));
        WebElement password = driver.findElement(By.name("loginpassword"));
        WebElement btn = driver.findElement(By.name("Login"));
        login.sendKeys("testowytest");
        password.sendKeys("tester01");
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Bulbator Bulbasek"));
    }

}
