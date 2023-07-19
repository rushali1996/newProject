package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class loginPageTest {
	WebDriver driver;
	Properties prop;
	
@BeforeTest
	
public void setup() throws FileNotFoundException {
prop = new Properties();

String path = System.getProperty("user.dir")+ 
						"//src//test//resources//configFile//config.properties";
FileInputStream fin = new FileInputStream(path);	
try {
	prop.load(fin);
}catch (IOException e) {
	e.printStackTrace();
}
String strBrowser= prop.getProperty("browser");
if(strBrowser.equalsIgnoreCase("chrome")) {
    driver = new ChromeDriver();
}
else if(strBrowser.equalsIgnoreCase("edge")) {
	driver = new EdgeDriver();
}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
}
  @Test(dataProvider="loginData")
  public void validLogin(String strUser, String strPwd) {
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.cssSelector("#username")).sendKeys(strUser);;
	  driver.findElement(By.id("password")).sendKeys(strPwd);
	  driver.findElement(By.className("radius")).click();
  }
  
  @DataProvider(name="loginData")
  public Object[][] ReadData() throws CsvValidationException, IOException  {
	  String path1 = System.getProperty("user.dir")+ 
				"//src//test//resources//dataFiles//userData.csv";
	  
	  CSVReader readercsv = new CSVReader(new FileReader(path1));
	  String cols[] ;
	  
	  ArrayList<Object> dataList = new ArrayList<Object>();
	  
	  while ((cols = readercsv.readNext())!= null) {
		  Object record[]= {cols[01], cols[1]};
	  dataList.add(record);
	  }
	  return dataList.toArray(new Object[dataList.size()][]);
  }
}