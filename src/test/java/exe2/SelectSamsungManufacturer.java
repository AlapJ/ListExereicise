package exe2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectSamsungManufacturer {
	
WebDriver driver;
	
	@BeforeTest
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.get("http://122.170.14.195:8080/uth/gadgetsgallery/catalog/");
		driver.manage().window().maximize();
	}
	@Test
	public void testsamsungmanufacturer() throws Exception
	{
		WebElement manufacturers = driver.findElement(By.xpath("//*[@id=\"left_sidebar\"]/div[2]/div[2]/form/select"));
		List<WebElement> manufactureresLink = manufacturers.findElements(By.tagName("option"));
		int size = manufactureresLink.size();
		System.out.println(size);
		manufactureresLink.get(16).click();
		System.out.println("Page title is--->"+driver.getTitle());
		Thread.sleep(5000);
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
