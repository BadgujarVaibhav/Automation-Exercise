package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_9 
{
	public WebDriver dr;
	
	@BeforeClass
	public void setup()
	{
		
		WebDriverManager.chromedriver().setup();
		dr= new ChromeDriver(); // 1. Launch browser

		dr.manage().window().maximize();
		dr.get("https://automationexercise.com/"); // Navigate to url 'http://automationexercise.com'

	}
	
	@Test(priority=1)
	public void HomePagetitleVerification()
	{
		String title= dr.getTitle(); // Verify that home page is visible successfully
		System.out.println(title);
		assertEquals(title,"Automation Exercise","Incorrect Title");
		
	}
	
	@Test(priority=2)
	public void VerifyAllProduct() throws InterruptedException
	{
		//4. Click on 'Products' button
		dr.findElement(By.xpath("//a[text()=' Products']")).click();
		//5. Verify user is navigated to ALL PRODUCTS page successfully
		String Allproduct=dr.findElement(By.xpath("//h2[text()='All Products']")).getText();
		assertEquals(Allproduct,"ALL PRODUCTS");
		Thread.sleep(2000);
		dr.findElement(By.id("id=\"search_product\"")).sendKeys("Jeans");
		dr.findElement(By.id("submit_search")).click();
		String Text=dr.findElement(By.xpath("//h2[text()='Searched Products']")).getText();
		assertEquals(Text,"Searched Products");
		List <WebElement> Items=(List<WebElement>) dr.findElement(By.xpath("//div[contains(@class,'productinfo')]//p"));
		for(int i=0;i<Items.size();i++)
		{
			assertTrue(Items.get(i).getText().contains("Jeans"));
		}
		
	}
	
	
}
