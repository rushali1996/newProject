package parallelExecution;

import org.testng.annotations.Test;

public class testClass4 {
	 @Test(groups="featureOne")
	  public void testOne() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test one in test Class 4..... "+ id);
	  }
	  
	  @Test(groups="featureTwo")
	  public void testTwo() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test two in test Class 4..... "+ id);
	  }
	  
	  @Test(groups="featureThree")
	  public void testThree() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test three in test Class 4..... "+ id);
	  }
	  @Test(groups="featureFour")
	  public void testFour() {
		  long id = Thread.currentThread().getId();
		  System.out.println("Test four in test Class 4..... "+ id);
	  }
}
