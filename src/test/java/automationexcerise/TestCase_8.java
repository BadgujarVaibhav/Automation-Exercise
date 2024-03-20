package automationexcerise;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_8 
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
		//6. The products list is visible
		Thread.sleep(2000);
		//7. Click on 'View Product' of first product
		dr.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
		//8. User is landed to product detail page
		String productname=dr.findElement(By.xpath("//h2[text()='Blue Top']")).getText();
		assertEquals(productname,"Blue Top");
		ArrayList<Object> ar= new ArrayList<Object>();
		ar.add("Category: Women > Tops");
		ar.add("Availability: In Stock");
		ar.add("Condition: New");
		ar.add("Brand: Polo");
		//9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
		List<WebElement> details=(List<WebElement>) dr.findElement(By.xpath("//div[@class='product-information']//p"));
		for(int i=0;i<details.size();i++)
		{
			System.out.println(details.get(i).getText());
		assertEquals(details.get(i).getText(),ar.get(i));
		}
		
		
	}
	
}
