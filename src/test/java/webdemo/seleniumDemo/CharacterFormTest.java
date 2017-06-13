package webdemo.seleniumDemo;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;

/**
 * Created by sasin on 13.06.2017.
 */
public class CharacterFormTest {

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
        driver.get("https://secure.tibia.com/community/?subtopic=characters");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
    }


    @Test
    public void searchForUnexistingCharacter() {
        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys("Jacek Tomasz Sasin Tester");
        WebElement btn = driver.findElement(By.name("Submit"));
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Could not find character"));
    }


    @Test
    public void searchForExistingCharacter() {
        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys("Bulbator Bulbasek");
        WebElement btn = driver.findElement(By.name("Submit"));
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement viewCharacterSpecs = driver.findElement(By.name("View Bulbator Bulbasek"));
        Assert.assertNotNull(viewCharacterSpecs);
    }


}
