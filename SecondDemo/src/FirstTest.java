import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
	
	WebDriver driver;
	
	
	@BeforeMethod 
	
	public void setup()
	{
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement r = driver.findElement(By.name("q"));
	      r.sendKeys("amazon");
	      r.sendKeys(Keys.RETURN);
	      
	    driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();
		
	}
	
	@Test
	
	public void VerifyTitle()
	{
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@Test
	
	public void VerifyLogo()
	{
		boolean flag = driver.findElement(By.xpath("//a[@href='/ref=nav_logo'][contains(.,'.us')]")).isDisplayed();
		
		Assert.assertTrue(flag);
	}
	
	@Test
	
	public void SearchTest()
	{
		driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]")).sendKeys("Teddy Bears");
		
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}

}
