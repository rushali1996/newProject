package testScripts;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class GooglePageTest {
	WebDriver driver;
	

	@BeforeMethod
	 public void setup() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
  @Test
  public void javaSearchTest() {
	
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement schBox =driver.findElement(By.name("qa"));
		schBox.sendKeys("java tutorial");
		schBox.submit();
		Assert.assertEquals(driver.getTitle(),"java tutorial - Google Search");
  }
  
  @Test
  public void seleniumSearchTest() {
		 
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
        WebElement schBox =driver.findElement(By.name("qa"));
		schBox.sendKeys("selenium tutorial");
		schBox.submit();
		Assert.assertEquals(driver.getTitle(),"selenium tutorial - Google Search");
		  
  }
  
  @Test (alwaysRun= true, dependsOnMethods="seleniumSearchTest")
  public void appiumSearchTest() {
		 
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
        WebElement schBox =driver.findElement(By.name("qa"));
		schBox.sendKeys("appium tutorial");
		schBox.submit();
		Assert.assertEquals(driver.getTitle(),"appium tutorial - Google Search");
		  
  }
  
  @AfterMethod
   public void tearDown()
   {
	driver.quit();

}

}
