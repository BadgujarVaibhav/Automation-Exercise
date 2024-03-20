package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Case_3
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
	
	@Test(priority=1)
	public void SignUpText()
	{
		//4. Click on 'Signup / Login' button
		dr.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		// Verify 'New User Signup!' is visible
		boolean SignUpText=dr.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		assertTrue(SignUpText,"New User Signup! is not visible");		
	}
	
	@Test(priority=2)
	public void LoginText()
	{
		//5. Verify 'Login to your account' is visible
		 String LoginText =dr.findElement(By.xpath("//h2[contains(text(),'Login to')]")).getText();
		 assertEquals(LoginText, "Login to your account"); 
		 
	}
	
	@Test(priority=3)
	public void Invalid_user()
	{
		 //6. Enter incorrect email address and password
		 
		 dr.findElement(By.xpath("//input[@name='email'][@data-qa='login-email']")).sendKeys("QA1@gmail.com");
		 dr.findElement(By.xpath("//input[@name='password']")).sendKeys("test1234");
		 //7. Click 'login' button
		 dr.findElement(By.xpath("//button[text()='Login']")).click();
		 boolean error= dr.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).isDisplayed();
		 assertTrue(error,"Your email or password is incorrect!");	
	}
}