package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testClass2 {
  @Test
  
  public void cypressSearchTest() {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get("https://www.google.com/");
		 driver.manage().window().maximize();
		 WebElement schBox =driver.findElement(By.name("qa"));
		 schBox.sendKeys("cypress tutorial");
		 schBox.submit();
		 Assert.assertEquals(driver.getTitle(),"cypress tutorial - Google Search");
		 driver.close();
  }
}
