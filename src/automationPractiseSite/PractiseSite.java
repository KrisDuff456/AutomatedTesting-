package automationPractiseSite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PractiseSite {
	
	static WebDriver driver;
	
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/External Application/chrome_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@After
	public void quitDriver() {
		driver.quit();
	}
	
	@Test
	public void testSearch() {
		driver.get("http://automationpractice.com/index.php"); 
		driver.findElement(By.id("search_query_top")).sendKeys("t-shirt");
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		           searchButton.submit();
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
		assertEquals("Faded Short Sleeve T-shirts",checkElement.getText());
	}
	

	
}
