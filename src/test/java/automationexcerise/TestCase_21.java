package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_21 
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
	public void add_review()
	{
		
		//3. Click on 'Products' button
		dr.findElement(By.xpath("//a[text()=' Products']")).click();
		
		//4. Verify user is navigated to ALL PRODUCTS page successfully
		String All_product=dr.findElement(By.xpath("//h2[text()='All Products']")).getText();
		assertEquals(All_product,"ALL PRODUCTS");
		
		//5. Click on 'View Product' button
		dr.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
		
		//6. Verify 'Write Your Review' is visible
		String write_review=dr.findElement(By.xpath("//a[text()='Write Your Review']")).getText();
		assertEquals(write_review,"WRITE YOUR REVIEW");
		
		//7. Enter name, email and review
		dr.findElement(By.id("name")).sendKeys("Vaibhav");
		dr.findElement(By.id("email")).sendKeys("Vaibhav12@gmail.com");
		dr.findElement(By.id("review")).sendKeys("This is a review of this product and this product is good in quality!!!");
		
		//8. Click 'Submit' button
		dr.findElement(By.id("button-review")).click();
		
		//9. Verify success message 'Thank you for your review.'
		 String verify_review_msg=dr.findElement(By.xpath("//div[@class='alert-success alert']//span")).getText();
		 assertEquals(verify_review_msg,"Thank you for your review.");
		 
		
	}
	
}