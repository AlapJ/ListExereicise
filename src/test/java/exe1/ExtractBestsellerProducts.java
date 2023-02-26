package exe1;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtractBestsellerProducts {
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.get("http://122.170.14.195:8080/uth/gadgetsgallery/catalog/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void testBestsellerProduct()
	{
		WebElement BestSellers = driver.findElement(By.xpath("//*[@id=\"right_sidebar\"]/div[2]/div[2]"));
		List<WebElement> BestSellerlinks= BestSellers.findElements(By.tagName("a"));
		
		for (int count=0;count<BestSellerlinks.size();count++)
		{
			System.out.println(BestSellerlinks.get(count).getText());
			BestSellerlinks.get(count).click();
			driver.getTitle();
			System.out.println("Title is-->"+driver.getTitle()+"Product price is -->"+driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/form/div[1]/h1[1]")).getText());
			driver.navigate().back();
			BestSellers = driver.findElement(By.xpath("//*[@id=\"right_sidebar\"]/div[2]/div[2]"));
			BestSellerlinks= BestSellers.findElements(By.tagName("a"));
			
		}
	}

	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
