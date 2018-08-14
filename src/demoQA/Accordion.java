package demoQA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Accordion {
	
	static WebDriver driver;
	
	@Before 
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/External Application/chrome_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void testAccord() {
		driver.get("http://demoqa.com/");
		WebElement accordBtn = driver.findElement(By.xpath("//*[@id=\"menu-item-144\"]/a"));
	               accordBtn.click();
	    WebElement custIcon = driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]"));
	               custIcon.click();
	               
	    WebElement toggle = driver.findElement(By.xpath("//*[@id=\"toggle\"]/span"));
	               toggle.click();
	    WebElement checkIcon = driver.findElement(By.xpath("//*[@id=\"ui-id-12\"]"));
	    
	    assertEquals("Icon is disabled",checkIcon.isEnabled(),true);
	}
}
