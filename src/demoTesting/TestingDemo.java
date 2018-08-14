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
		driver.manage().window().maximize();
	}
	
	@After
	public void quitDriver() {
		driver.quit();
	}
	
	@Test 
	public void testDemoSite() {
		driver.get("http://thedemosi te.co.uk/index.php");
	}
	@Test
	public void testCreate(){
		driver.get("http://thedemosite.co.uk/addauser.php");
		driver.findElement(By.name("username")).sendKeys("Frezia");
		driver.findElement(By.name("password")).sendKeys("pass");
		WebElement subButton = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
        subButton.submit();
	}
	
	@Test
	public void testAccess(){
		driver.get("http://thedemosite.co.uk/login.php");
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys("Frezia");
	    driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys("pass");
	    WebElement subButton = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
	               subButton.submit();
    }
}

