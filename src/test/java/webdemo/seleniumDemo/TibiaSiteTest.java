package webdemo.seleniumDemo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TibiaSiteTest {
	
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testTitlePage() {
		driver.get("https://secure.tibia.com/account/?subtopic=accountmanagement");
    	assertEquals("Tibia - Free Multiplayer Online Role Playing Game - Account", driver.getTitle());
	}
	
	@Test
	public void testPlayNow(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement gameButton = driver.findElement(By.name("Play Now"));
		assertNotNull(gameButton);
	}
	
	
	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
