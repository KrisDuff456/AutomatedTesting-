package demoTesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingDemo {
	
	static WebDriver driver;
	
	@Before
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/External Application/chrome_driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void quitDriver() {
		driver.quit();
	}
	
	@Test
	public void testDemoSite() {
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/login.php");
	}
	
	@Test
	public void testUserAccount(){
		WebElement userName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys(Frezia);
	}
	
	@Test 
	public void testPassword() {
		 WebElement passWord = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys(password);
	}
	
	@Test
	public void testButton() {
		WebElement subButton = driver.findElement(By.id("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
	               subButton.submit();
	}

}

