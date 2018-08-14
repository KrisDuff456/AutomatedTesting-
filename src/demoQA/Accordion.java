package demoQA;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Accordion {
	
	static WebDriver driver;
	static ExtentReports extent;
	static String webAddress;
	
	@BeforeClass
	public void systemCheck(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/External Application/chrome_driver/chromedriver.exe");
		extent = new ExtentReports("C://Users//Admin//Testing//TestingReports//extentReport.html", true);
		ExtentTest initialistationInformation = extent.startTest("initialistation");
		
		try (FileInputStream file = new FileInputStream("C:/Users/Admin/Testing/TestingReports/test.xlsx");
		XSSFWorkbook myBook = new XSSFWorkbook(file);) {
			initialistationInformation.log(LogStatus.INFO,"WorkBook Found");
			webAddress = myBook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
			initialistationInformation.log(LogStatus.INFO, "Web Address found, value: " + webAddress);
			initialistationInformation.log(LogStatus.PASS, "Pass");
		}catch(FileNotFoundException e) {
			initialistationInformation.log(LogStatus.FATAL, "WorkBook not Found");
			initialistationInformation.log(LogStatus.INFO, "File is here: C:/Users/Admin/Testing/TestingReports/test.xlsx");
		}catch(IOException e) {
			initialistationInformation.log(LogStatus.FATAL, "Could not create workbook");
		}
		
	}
	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	 
	@After
	public void quit() {
		driver.quit();
		extent.flush();
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
