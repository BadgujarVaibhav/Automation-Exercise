package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_13
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
	public void VerifyProduct_Quantity() throws InterruptedException
	{
		dr.findElement(By.xpath("//a[@href='/product_details/1']")).click();
		dr.findElement(By.id("quantity")).clear();
		dr.findElement(By.id("quantity")).sendKeys("4");
		dr.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		String Quantity=dr.findElement(By.xpath("//td[@class='cart_quantity']")).getText();
		assertEquals(Quantity,"4");
		
	}
	
	
	
}