package exe3;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MenuLinks {

WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.get("http://122.170.14.195:8080/uth/gadgetsgallery/catalog/");
		driver.manage().window().maximize();
	}
	@Test
	public void testmenulink() throws Exception
	{
		WebElement topmenu = driver.findElement(By.id("top_menu"));
		List <WebElement> menulinks =topmenu.findElements(By.tagName("a"));
		//System.out.println(catvalue.get(2).getText()); ----> to print value of 2nd item from the category list
		//System.out.println(category.getText());
		for (int count = 0 ; count<menulinks.size(); count++) 
		{
			
			System.out.println(menulinks.get(count).getText()+driver.getCurrentUrl()+driver.getTitle());
			menulinks.get(count).click();
			
			
			Thread.sleep(5000);
			
			driver.navigate().back();
			
			
			topmenu = driver.findElement(By.id("top_menu"));;
			
			menulinks =topmenu.findElements(By.tagName("a"));
			
		}
			
		}
		
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
