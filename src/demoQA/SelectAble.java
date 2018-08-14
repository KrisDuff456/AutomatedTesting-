package demoQA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectAble {
	
	static WebDriver driver;

	@Before 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/External Application/chrome_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void testSelectable() {
		driver.get("http://demoqa.com/");
		WebElement selBtn = driver.findElement(By.xpath("//*[@id=\"menu-item-142\"]/a"));
		           selBtn.click();
		WebElement serializeBtn = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
		           serializeBtn.click();
		WebElement item3 = driver.findElement(By.xpath("//*[@id=\"selectable-serialize\"]/li[3]"));
		           item3.click();
		WebElement checkItem = driver.findElement(By.xpath("//*[@id=\"select-result\"]"));
		
		assertEquals("#3",checkItem.getText());
	}
}
