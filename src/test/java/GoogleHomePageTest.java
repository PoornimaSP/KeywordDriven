import org.testng.annotations.Test;

import ExecutionEngine.ExecutionEngine;

public class GoogleHomePageTest {
 
	public ExecutionEngine ee ;
	
	@Test
	public void HomePageTest()
	{
	ee=new ExecutionEngine();
	ee.startexecution("Google");
	//comment
	
	
	}
	
}
