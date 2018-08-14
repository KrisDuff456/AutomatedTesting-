package demoQA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropAndDrag {
	 
	static WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/External Application/chrome_driver/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void quit() {
		driver.quit();
	}
	
	@Test
	public void testDropable() {
		driver.get("http://demoqa.com/");
		WebElement dropBtn = driver.findElement(By.xpath("//*[@id=\"menu-item-141\"]/a"));
	               dropBtn.click();
	               
	    WebElement dragAble = driver.findElement(By.xpath("//*[@id=\"draggableview\"]"));
	    WebElement dropAble = driver.findElement(By.xpath("//*[@id=\"droppableview\"]"));
	    
	    Actions act = new Actions(driver);
	    act.dragAndDrop(dragAble,dropAble).perform();
	    WebElement checkDrop = driver.findElement(By.xpath("//*[@id=\"droppableview\"]/p"));
	    assertEquals("Dropped!",checkDrop.getText());
	}
	
	
}
