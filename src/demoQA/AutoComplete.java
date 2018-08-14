package demoQA;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoComplete {
	
	static WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/External Application/chrome_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void quit() {
		//driver.quit();
	}
	@Test
	public void testAuto() {
		driver.get("http://demoqa.com/");
		WebElement autoBtn = driver.findElement(By.xpath("//*[@id=\"menu-item-145\"]/a"));
		           autoBtn.click();
		WebElement tagBtn = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));
		           tagBtn.click();
		WebElement textBox = driver.findElement(By.xpath("//*[@id=\"tagsss\"]"));
		textBox.sendKeys("Java");
		textBox.sendKeys(Keys.ARROW_DOWN);
		textBox.sendKeys(Keys.ENTER);	
	}

}
