package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Case_12 
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
		dr.findElement(By.xpath("//a[@data-product-id='1']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//a[@data-product-id='2']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		List <WebElement> firstproduct= (List<WebElement>) dr.findElement(By.id("product-1"));
		List <WebElement> Secproduct=(List<WebElement>) dr.findElement(By.id("product-2"));
		HashMap<Integer,String> map= new HashMap<Integer,String>();
		map.put(1, "Blue Top");
		map.put(1, "Women > Tops");
		map.put(1, "Rs. 500");
		map.put(1, "1");
		map.put(1, "Rs. 500");
		map.put(2, "Men Tshirt");
		map.put(2, "Men > Tshirt");
		map.put(2, "Rs. 400");
		map.put(2, "1");
		map.put(2, "Rs. 400");
		for(int i=0;i<firstproduct.size();i++)
		{
			assertTrue(firstproduct.get(i).getText().contains(map.get(1)));
			assertTrue(Secproduct.get(i).getText().contains(map.get(2)));	
		}
		
		
	}
}

