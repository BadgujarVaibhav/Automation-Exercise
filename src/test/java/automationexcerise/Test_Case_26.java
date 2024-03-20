package automationexcerise;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Case_26 
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
	public void verify_scrollup_withoutarrows()
	{
		//4. Scroll down page to bottom
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		
		//5. Verify 'SUBSCRIPTION' is visible
		String verify_sub= dr.findElement(By.xpath("//h2[text()='Subscription']")).getText();
		assertEquals(verify_sub,"SUBSCRIPTION");
		
		//6. Scroll up page to top
		JavascriptExecutor js1 = (JavascriptExecutor) dr;
		js1.executeScript("window.scrollBy(0,-250)", "");
		
		//7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
		String verify_text= dr.findElement(By.xpath("(//h2[text()='Full-Fledged practice website for Automation Engineers'])[1]")).getText();
		assertEquals(verify_text,"Full-Fledged practice website for Automation Engineers");
		
	}
	
}