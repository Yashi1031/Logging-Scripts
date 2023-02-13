import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Logging {

	@Test(dataProvider = "credentials")
	public void verifylogging(String scenario, String UserName, String Password)
	{
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("submit")).click();
		
		if(scenario.equals("Bothcorrect")) {
			WebElement e = driver.findElement(By.xpath("//h1[@class='post-title'][contains(.,'Logged In Successfully')]"));
			Assert.assertTrue(e.isDisplayed());
		}
		
		else if (scenario.equals("CorrectUserName")) {
			String errormesage = driver.findElement(By.xpath("//div[@class='show'][contains(.,'Your password is invalid!')]")).getText();
			Assert.assertEquals(errormesage,"Your password is invalid!");
		}
		
		else {
			String errormesage = driver.findElement(By.xpath("//div[@class='show'][contains(.,'Your username is invalid!')]")).getText();
			Assert.assertEquals(errormesage,"Your username is invalid!");
		}
		
		driver.quit();
	}
	
	
	@DataProvider(name="credentials")
	public Object [][] getData() 
	{
		return new Object [][] {
			
			{"Bothcorrect","student","Password123"},
			{"CorrectUserName","student","Password123asd"},
			{"CorrectPassword","studentasd","Password123"}
			
		};
		
	}
	
}
