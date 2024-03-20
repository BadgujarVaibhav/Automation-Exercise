package automationexcerise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_10 
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
	public void Subsciption_Verification() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		String Text=dr.findElement(By.xpath("//h2[text()='Subscription']")).getText();
		assertEquals(Text,"SUBSCRIPTION");
		dr.findElement(By.id("susbscribe_email")).sendKeys("vaibhavb@gmail.com");
		Thread.sleep(2000);
		dr.findElement(By.id("subscribe")).click();
		String Text1= dr.findElement(By.id("success-subscribe")).getText();
		assertEquals(Text1,"You have been successfully subscribed!");
		
	}
	
	
	
}
