package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_17 
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
	public void remove_product()
	{
		// 8. Add products to cart
		dr.findElement(By.xpath("//a[text()=' Products']")).click();
		dr.findElement(By.xpath("//a[@data-product-id='1']")).click();
		
		//9. Click 'Cart' button
		dr.findElement(By.xpath("//a[text()=' Cart']")).click();
		
		// verify cart page
		boolean verify_cart_page=dr.findElement(By.xpath("//li[text()='Shopping Cart']")).isDisplayed();
		assertTrue(verify_cart_page,"Shopping Cart");
		//7. Click 'X' button corresponding to particular product
		dr.findElement(By.xpath("//a[@class='cart_quantity_delete']")).click();
		//8. Verify that product is removed from the cart
		boolean verify_product_remove= dr.findElement(By.xpath("//b[text()='Cart is empty!']")).isDisplayed();
		assertTrue(verify_product_remove,"Cart is empty!");
		
		
	}
	
}
	