package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import org.junit.Assert;


public class Steps 
{
	WebDriver driver;
	@Given("the user is on the democart login page")
	public void the_user_is_on_the_nopcommerce_login_page() 
	{
	    driver=new ChromeDriver();
	   driver.get("https://tutorialsninja.com/demo/");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.manage().window().maximize();
	   driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	   driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
	}

	@When("the user enters the valid credentials \\(username: {string} , password: {string})")
	public void the_user_enters_the_valid_credentials_username_password(String user, String pwd) 
	{
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
	    
	    
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() 
	{
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("the user should be redirected to MyAccount Page")
	public void the_user_should_be_redirected_to_my_account_page() 
	{
		Boolean status=driver.findElement(By.xpath("//span[normalize-space()='My Account']")).isDisplayed();
		Assert.assertEquals(status,true);
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() 
	{
		Boolean welcometxt=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		Assert.assertEquals(welcometxt, true);
		driver.quit();
	}
	
}
