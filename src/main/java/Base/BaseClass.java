package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	
	
	public WebDriver init_driver(String BrowserName)
	{
		if (BrowserName.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver","C://uday//geckodriver/geckodriver.exe");
		    driver = new FirefoxDriver();
		    
		}
		else
		{
			System.setProperty("webdriver.chrome.driver","C://uday//ChromeDriver/chromedriver.exe");
		    driver = new ChromeDriver();
		}
			driver.manage().window().maximize();
			
			return driver;
	}
	

	/*public static void main (String args[])
	{
		BaseClass bc= new BaseClass();
		driver = bc.init_driver("ff");
		driver.get("https://www.google.com");
		
	}*/
	}
	

