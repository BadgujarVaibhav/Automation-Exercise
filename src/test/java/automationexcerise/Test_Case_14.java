package automationexcerise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Case_14 
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
	public void add_to_cart() throws InterruptedException
	{
		dr.findElement(By.xpath("//a[text()=' Products']")).click();
		dr.findElement(By.xpath("//a[@data-product-id='1']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//a[@data-product-id='2']")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		List <WebElement> firstproduct= (List<WebElement>) dr.findElement(By.id("product-1"));
		List <WebElement> Secproduct=(List<WebElement>) dr.findElement(By.id("product-2"));
		HashMap<Integer,String> map= new HashMap<Integer,String>();
		map.put(1, "Blue Top");
		map.put(1, "Women > Tops");
		map.put(1, "Rs. 500");
		map.put(1, "1");
		map.put(1, "Rs. 500");
		map.put(2, "Men Tshirt");
		map.put(2, "Men > Tshirt");
		map.put(2, "Rs. 400");
		map.put(2, "1");
		map.put(2, "Rs. 400");
		for(int i=0;i<firstproduct.size();i++)
		{
			assertTrue(firstproduct.get(i).getText().contains(map.get(1)));
			assertTrue(Secproduct.get(i).getText().contains(map.get(2)));	
		}
		
		//7. Click Proceed To Checkout
		
		dr.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
		
		//8. Click 'Register / Login' button
		dr.findElement(By.xpath("//a//u[text()='Register / Login']")).click();

		//9. Fill all details in Signup and create account
		dr.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		// Verify 'New User Signup!' is visible
		boolean SignUpText=dr.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		if(SignUpText)
		{
			System.out.println("New User Signup! is visible");
		}
		else
		{
			System.out.println("New User Signup! is not visible");
			
		}
		
		
		dr.findElement(By.xpath("//input[@name='name']")).sendKeys("QA1");
		dr.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("QA1@gmail.com");
		
		// Click 'Signup' button
		
		dr.findElement(By.xpath("//button[text()='Signup']")).click();
		
		//  Verify that 'ENTER ACCOUNT INFORMATION' is visible
		
		boolean AccountText=dr.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();
		if(AccountText)
		{
			System.out.println("AccountText is visible");
		}
		else
		{
			System.out.println("AccountText is not visible");
			
		}
		
		//  Fill details: Title, Name, Email, Password, Date of birth
		dr.findElement(By.xpath("//input[@id='id_gender1']")).click();
		dr.findElement(By.id("password")).sendKeys("test1234");
		WebElement Days=dr.findElement(By.id("days"));
		Select DaysDropDown = new Select(Days);
		DaysDropDown.selectByVisibleText("13");
		
		WebElement month=dr.findElement(By.id("months"));
		Select monthDropDown = new Select(month);
		monthDropDown.selectByVisibleText("June");
		
		WebElement Years=dr.findElement(By.id("years"));
		Select YearDropDown = new Select(Years);
		YearDropDown.selectByVisibleText("1999");
		
		
		//10. Select checkbox 'Sign up for our newsletter!'
		
		dr.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		//11. Select checkbox 'Receive special offers from our partners!'
		
		dr.findElement(By.xpath("//input[@id='optin']")).click();
		
		//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
		
		dr.findElement(By.xpath("//input[@id='first_name']")).sendKeys("QA");
		dr.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Tester");
		dr.findElement(By.xpath("//input[@id='company']")).sendKeys("Excel R Company");
		dr.findElement(By.xpath("//input[@id='address1']")).sendKeys("India");
		dr.findElement(By.xpath("//input[@id='address2']")).sendKeys("Pune");
		
		WebElement Country= dr.findElement(By.id("country"));
		Select CountryDropDown = new Select (Country);
		CountryDropDown.selectByVisibleText("India");
		
		dr.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
		dr.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
		dr.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("411048");
		dr.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1234567896");
		
		//13. Click 'Create Account button'
		dr.findElement(By.xpath("//button[text()='Create Account']")).click();
		
		//14. Verify that 'ACCOUNT CREATED!' is visible
		
		boolean AccountVisible=dr.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
		if(AccountVisible)
		{
			System.out.println("Account Created!");
		}
		else
		{
			System.out.println("Account Text is not visible");
			
		}
		
		//15. Click 'Continue' button
		
		dr.findElement(By.xpath("//a[text()='Continue']")).click();
		
		//dr.findElement(By.xpath("//*[@id=\"dismiss-button\"]/div")).click();
		
		//16. Verify that 'Logged in as username' is visible
		
		boolean Uservisible=dr.findElement(By.xpath("//a[text()=' Logged in as ']/b[text()='QA1']")).isDisplayed();
		if(Uservisible)
		{
			System.out.println("User Text is visible");
		}
		else
		{
			System.out.println("User Text is not visible");
			
		}
		
		// click on cart button
		
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
