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

public class FindTest {
	
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://secure.tibia.com/account/?subtopic=accountmanagement");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void findLoginBtn() {
		WebElement element = driver.findElement(By.name("Login"));
		assertNotNull(element);
	}
	
	@Test
	public void findXPathLoginForm() {
		WebElement element = driver.findElement(By.xpath(".//*[@id='accountmanagement']/div[5]/div/div/div[1]/table/tbody/tr/td/div/table/tbody/tr[1]/td/div[2]/div/table/tbody/tr/td/table/tbody/tr[1]/td[2]/input"));
		assertNotNull(element);
	}
	
	@Test
	public void findMediumButtonFormPresent() {
		WebElement element = driver.findElement(By.className("MediumButtonForm"));
		assertNotNull(element);
	}




}
