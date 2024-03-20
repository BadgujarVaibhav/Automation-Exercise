package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Case_16 
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
	public void Login_before_Checkout()
	{
		//5. Verify 'Login to your account' is visible
		 String LoginText =dr.findElement(By.xpath("//h2[contains(text(),'Login to')]")).getText();
		 assertEquals(LoginText, "Login to your account");
		 //6. Enter correct email address and password
		 dr.findElement(By.xpath("//input[@name='email'][@data-qa='login-email']")).sendKeys("QA1@gmail.com");
		 dr.findElement(By.xpath("//input[@name='password']")).sendKeys("test1234");
		 //7. Click 'login' button
		 dr.findElement(By.xpath("//button[text()='Login']")).click();
		 
		 //8. Verify that 'Logged in as username' is visible
		String Username= dr.findElement(By.xpath("//a[text()=' Logged in as ']/b[Text()='QA']")).getText();
		 assertEquals(Username,"QA","Successful");
		 
		// 8. Add products to cart
			dr.findElement(By.xpath("//a[text()=' Products']")).click();
			dr.findElement(By.xpath("//a[@data-product-id='1']")).click();
			
		//9. Click 'Cart' button
		dr.findElement(By.xpath("//a[text()=' Cart']")).click();
			
		// 13. Click 'Proceed To Checkout' button
		dr.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
			
		//14. Verify Address Details and Review Your Order
		
     boolean Verify_address=dr.findElement(By.xpath("//h2[text()='Address Details']")).isDisplayed();
     if(Verify_address)
		{
			System.out.println("Address details is visible");
		}
		else
		{
			System.out.println("Address details is not visible");
			
		}
     
		//15. Enter description in comment text area and click 'Place Order'
     dr.findElement(By.id("message")).sendKeys("Please deliver my product on time and check the billing address for the same");
     dr.findElement(By.xpath("//a[text()='Place Order']")).click();
     
     //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
     dr.findElement(By.name("name_on_card")).sendKeys("Vaibhav");
     dr.findElement(By.name("card_number")).sendKeys("1234-5678-5621");
     dr.findElement(By.name("cvc")).sendKeys("852");
     dr.findElement(By.name("expiry_month")).sendKeys("12");
     dr.findElement(By.name("expiry_year")).sendKeys("2026");
     
     //17. Click 'Pay and Confirm Order' button
     dr.findElement(By.id("submit")).click();
     
     //18. Verify success message 'Your order has been placed successfully!'
   String verify_message=  dr.findElement(By.xpath("(//div[@class='alert-success alert'])[1]")).getText();
    assertEquals(verify_message,"Your order has been placed successfully!");
    
    //19. Click 'Delete Account' button
    dr.findElement(By.xpath("//a[text()=' Delete Account']")).click();
	
    //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    
    boolean accountDeleted=dr.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
		if(accountDeleted)
		{
			System.out.println("User account is Deleted");
		}
		else
		{
			System.out.println("User account is not Deleted");
			
		}
		
		dr.findElement(By.xpath("//a[text()='Continue']")).click();

	}
}

