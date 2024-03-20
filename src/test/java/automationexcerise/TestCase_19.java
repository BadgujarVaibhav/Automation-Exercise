package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_19
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
	public void verify_cart_brand_product()
	{
		//3. Click on 'Products' button
		dr.findElement(By.xpath("//a[text()=' Products']")).click();
		
		//4. Verify that Brands are visible on left side bar
		String verify_brands=dr.findElement(By.xpath("//h2[text()='Brands']")).getText();
		assertEquals(verify_brands,"BRANDS");
		
		//5. Click on any brand name(clicked on polo T-shirts)
		dr.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[1]/div/div[2]/div/ul/li[1]/a")).click();
		
		//6. Verify that user is navigated to brand page and brand products are displayed
		String Verify_polo_product=dr.findElement(By.xpath("//h2[text()='Brand - Polo Products']")).getText();
		assertEquals(Verify_polo_product,"BRAND - POLO PRODUCTS");
		
		//7. On left side bar, click on any other brand link (Clicked on H & M)
		dr.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div[1]/div[2]/div/ul/li[2]/a")).click();
		
		//8. Verify that user is navigated to that brand page and can see products
		String Verify_HM_product= dr.findElement(By.xpath("//h2[text()='Brand - H&M Products']")).getText();
		assertEquals(Verify_HM_product,"BRAND - H&M PRODUCTS");
		
		
	}
	
}
