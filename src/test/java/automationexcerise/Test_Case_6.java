package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Case_6
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
	public void Contact_us()
	{
		dr.findElement(By.xpath("//a[text()=' Contact us']")).click();
		String text= dr.findElement(By.xpath("//h2[text()='Get In Touch']")).getText();
		assertEquals(text, "GET IN TOUCH");
		//6. Enter name, email, subject and message

		dr.findElement(By.name("name")).sendKeys("vaibhav");
		dr.findElement(By.name("email")).sendKeys("vaibhavb@gmail.com");
		dr.findElement(By.name("subject")).sendKeys("This is a contact us page!!");
		dr.findElement(By.id("message")).sendKeys("We really appreciate your response to our website.");
		//7. Upload file
		
		dr.findElement(By.name("upload_file")).sendKeys("E:\\Photos\\E learning\\images.jpg");
		//8. Click 'Submit' button
		dr.findElement(By.name("submit")).click();
		//9. Click OK button
		dr.switchTo().alert().accept();
		//10.Verify success message 'Success! Your details have been submitted successfully.' is visible
		String success=dr.findElement(By.xpath("//div[@class='contact-form']//div[2]")).getText();
		assertEquals(success,"Success! Your details have been submitted successfully.");
		//11. Click 'Home' button and verify that landed to home page successfully
		dr.findElement(By.xpath("//span[text()=' Home']")).click();
		HomePagetitleVerification();
		
	}
	
}

	