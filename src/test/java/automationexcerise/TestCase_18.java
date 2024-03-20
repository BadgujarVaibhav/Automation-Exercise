package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_18 
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
	public void verify_cat_product()
	{
		// click on product page
		dr.findElement(By.xpath("//a[text()=' Products']")).click();
		
		//3. Verify that categories are visible on left side bar
		String verify_cat= dr.findElement(By.xpath("//h2[text()='Category']")).getText();
		assertEquals(verify_cat,"CATEGORY");
		
		//4. Click on 'Women' category
		dr.findElement(By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")).click();
		
		//5. Click on any category link under 'Women' category, for example: Dress
		dr.findElement(By.linkText("//*[@id=\"Women\"]/div/ul/li[1]/a")).click();
		
		//6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
		String Verify_women_product=dr.findElement(By.xpath("//h2[text()='Women - Dress Products']")).getText();
		assertEquals(Verify_women_product,"WOMEN - DRESS PRODUCTS");
		
		//7. On left side bar, click on any sub-category link of 'Men' category
		dr.findElement(By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a")).click();
		// clicked on t-shirt
		dr.findElement(By.xpath("//*[@id=\"Men\"]/div/ul/li[1]/a")).click();
		
		//8. Verify that user is navigated to that category page
		String verify_mens_cat=dr.findElement(By.xpath("//h2[text()='Men - Tshirts Products']")).getText();
		assertEquals(verify_mens_cat,"MEN - TSHIRTS PRODUCTS");
	}
	
}
	