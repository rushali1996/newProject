package testScripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtils.Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class GooglePageTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	

	
	//@BeforeMethod
	//@BeforeTest
	//@Parameters("browser")
//	 public void setup(String strBrowser) {
//		if(strBrowser.equalsIgnoreCase("chrome")) {
//	        driver = new ChromeDriver();
//		}
//		else if(strBrowser.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		}
//	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
	@BeforeTest
	public void setupExtent() {
		extentReports =new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
	}
	
  @Test
  public void javaSearchTest() {
	  driver = new ChromeDriver();
	    extentTest= extentReports.createTest("java search test");	
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement schBox =driver.findElement(By.name("qa"));
		schBox.sendKeys("java tutorial");
		schBox.submit();
		Assert.assertEquals(driver.getTitle(),"java tutorial - Google Search");
  }
  
  @Test
  public void seleniumSearchTest() {
	  driver = new ChromeDriver();
	    extentTest= extentReports.createTest("selenium search test");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
        WebElement schBox =driver.findElement(By.name("qa"));
		schBox.sendKeys("selenium tutorial");
		schBox.submit();
		Assert.assertEquals(driver.getTitle(),"selenium tutorial - Google Search");
		  
  }
  
  @Test (alwaysRun= true, dependsOnMethods="seleniumSearchTest")
  public void appiumSearchTest() {
	  driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
        WebElement schBox =driver.findElement(By.name("qa"));
		schBox.sendKeys("appium tutorial");
		schBox.submit();
		Assert.assertEquals(driver.getTitle(),"appium tutorial - Google Search");
		  
  }
  
  @AfterTest
  public void finishExtent() {
	  extentReports.flush();
  }
  
  @AfterMethod
  public void generateReport(ITestResult result) {
	  if(result.getStatus()== ITestResult.FAILURE) {
		  extentTest.fail(result.getThrowable().getMessage());
		  // add screenshot
		  String path = Utility.getScreenshotPath(driver);
		  extentTest.addScreenCaptureFromPath(path);
		
         }
	  
  driver.close();
  
//  @AfterMethod
//   public void tearDown()
//   {
//	driver.quit();

}

}
