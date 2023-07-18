package testScripts;

import org.testng.annotations.Test;

public class testClass3 {
  @Test(groups="featureOne")
  public void testOne() {
	  System.out.println("Test class 3 : method 1");
  }
  
  @Test(groups="featureTwo")
  public void testTwo() {
	  System.out.println("Test class 3 : method 2");
  }
  
  @Test(groups="featureThree")
  public void testThree() {
	  System.out.println("Test class 3 : method 3");
  }
  @Test(groups="featureFour")
  public void testFour() {
	  System.out.println("Test class 3 : method 4");
  }
}
