package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Case_22 
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
	public void add_recommended_product()
	{
		
		//3. Scroll to bottom of page
		dr.findElement(By.xpath("//a[text()=' Cart']")).click();
		JavascriptExecutor js=(JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		
		//4. Verify 'RECOMMENDED ITEMS' are visible
		String verify_recomm=dr.findElement(By.xpath("//h2[text()='recommended items']")).getText();
		assertEquals(verify_recomm,"RECOMMENDED ITEMS");
		
		//5. Click on 'Add To Cart' on Recommended product
		dr.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a")).click();
		
		//6. Click on 'View Cart' button
		dr.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		
		
		//7. Verify that product is displayed in cart page
		String verify_cart=dr.findElement(By.xpath("//li[text()='Shopping Cart']")).getText();
		assertEquals(verify_cart,"Shopping Cart");
		
	}
	
	
}