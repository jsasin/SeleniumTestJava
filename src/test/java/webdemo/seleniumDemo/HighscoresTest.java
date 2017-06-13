package webdemo.seleniumDemo;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by sasin on 13.06.2017.
 */
public class HighscoresTest {
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
        driver.get("https://secure.tibia.com/community/?subtopic=highscores");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
    }


    @Test
    public void searchForLevelHighscores() {
        new Select(driver.findElement(By.name("world"))).selectByVisibleText("Secura");
        new Select(driver.findElement(By.name("profession"))).selectByVisibleText("Druids");
        new Select(driver.findElement(By.name("list"))).selectByVisibleText("Experience Points");
        WebElement btn = driver.findElement(By.name("Submit"));
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Malutki Haffi"));
    }


    @Test
    public void newAccNotInHighscores() {
        new Select(driver.findElement(By.name("world"))).selectByVisibleText("Secura");
        new Select(driver.findElement(By.name("profession"))).selectByVisibleText("Druids");
        new Select(driver.findElement(By.name("list"))).selectByVisibleText("Experience Points");
        WebElement btn = driver.findElement(By.name("Submit"));
        btn.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        String pageSource = driver.getPageSource();
        Assert.assertFalse(pageSource.contains("Bulbator Bulbasek"));
    }

}
