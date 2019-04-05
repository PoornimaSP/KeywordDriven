package ExecutionEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class ExecutionEngine {
	
	String LocatorName=null;
	
	String LocatorValue=null;
	public WebDriver driver;
	public BaseClass baseclass;
	
	public Workbook book;
	public Sheet sheet;
	
	public final String Sce_sheet = "C:\\Users\\welcome\\workspace\\KeywordDriven\\src\\main\\java\\Excel\\ExecutionExcel.xlsx";
	
	public void startexecution(String sheetname)
	{
		/*String LocatorName=null;
	
		String LocatorValue=null;*/
		FileInputStream fs = null;
		try
		{
			 fs = new FileInputStream(Sce_sheet);
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try
		{
		book = WorkbookFactory.create(fs);
		
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		int k=0;
		
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			try {
		String	Celllocator= sheet.getRow(i+1).getCell(k+1).toString().trim();
		
		
	    String  action = sheet.getRow(i+1).getCell(k+2).toString().trim();
	    String value =   sheet.getRow(i+1).getCell(k+3).toString().trim();
	    
	    if (!Celllocator.equalsIgnoreCase("NA"))
		{
		 
	 	this.LocatorName= Celllocator.split("==")[0].trim();
 	    this.LocatorValue= Celllocator.split("==")[1].trim();
 	   	    
 	   switch(LocatorName)
	    {
	    case "sendkeysxpath":
	    	
	    	WebElement element = driver.findElement(By.xpath(LocatorValue));
	    	element.sendKeys(value);
	    	
	    	break;
	    	
	    case "clickxpath":
	    	WebDriverWait wait = new WebDriverWait(driver,30);
	    	WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(LocatorValue))));
	    	WebElement welement = driver.findElement(By.xpath(LocatorValue));
	    	    	
	    	welement.click();
	    	
	    	default:
	    	
	    		break;
	    }
		}
	    
	    switch (action)
	    {
	    case "open browser":
	    	baseclass= new BaseClass();
	    	
	    	driver = baseclass.init_driver(value);
	    	
	    	break;
	    	
	    case "launch URL":
	    	
	    	driver.get("https://www.google.com");
	    	
	    	break;
	    	
	    case "browserback" :
	    	
	    	driver.navigate().back();
	    	
	   /* case "close browser":
	    	
	    	driver.quit();*/
	    	
	    default:
    		
    		break;
	    		    	
		}
	    
	  
		
		
	}
	
			catch(Exception e)
			{
			e.printStackTrace();
			}
	}
	}
}
