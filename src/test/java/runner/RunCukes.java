package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;  
import org.testng.annotations.AfterTest;

@CucumberOptions(features="src/test/resources/feature",glue= {"test.stepDefs"},tags="@addPlace",dryRun=true)

public class RunCukes extends AbstractTestNGCucumberTests {
	

	@BeforeTest
	public void beforeTesst() {
		System.out.println("This will run before execution");
	}
	
	@Test(enabled=false)
	public void Test() {}
	
	@AfterTest
	public void afterTest() {
		System.out.println("this is will run after the test");
	}
	
}
