import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SecondTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//SEARCH AMZON ON GOOGLE
		WebElement r = driver.findElement(By.name("q"));
	      r.sendKeys("amazon");
	      r.sendKeys(Keys.RETURN);
	      
	    driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).click();
	    
	    //VERIFY THE PAGE TITLE
	    String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		//VERIFY THE COMPNAY LOGO
		boolean flag = driver.findElement(By.xpath("//a[@href='/ref=nav_logo'][contains(.,'.us')]")).isDisplayed();
		Assert.assertTrue(flag);
		
		//SELECT THE ADDRESS POPUP CONFIGURATIONS
		 driver.findElement(By.xpath("//span[contains(@id,'glow-ingress-line2')]")).click();
		
		//driver.findElement(By.xpath("//span[@class='a-button-text a-declarative'][contains(.,'Ship outside the US')]")).click();
		 
		// driver.findElement(By.xpath("(//a[@tabindex='-1'][contains(@id,'210')][contains(.,'Sri Lanka')])[2]")).click();
		 
		 driver.findElement(By.xpath("//button[@name='glowDoneButton'][contains(.,'Done')]")).click();
		 Thread.sleep(2000);
		
		 //SERACH TEDDY BEARS 
		 WebElement a = driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]"));
		 a.sendKeys("Teddy Bears");
		 a.sendKeys(Keys.RETURN);
		 Thread.sleep(2000);
//		WebElement b = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base'][contains(.,'Amazon’s Choice')]"));
//		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", b);
//		 
//		 driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']")).click();
		
		
		//CLICKED ON SELECTED PRODUCT
		driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(.,'DOLDOA Giant Teddy Bear Soft Stuffed Animals Plush Big Bear Toy for Kids, Girlfriend 35.4 inch(Beige)')]")).click();
	
		//CHANGE THE QTY
		driver.findElement(By.xpath("//span[@class='a-dropdown-label'][contains(.,'Qty:')]")).click();
		driver.findElement(By.xpath("//a[contains(@id,'quantity_3')]")).click();
		
		//CLICK ON TERMS AND CONDITIONS AND CLOSE
		driver.findElement(By.xpath("(//a[@href='javascript:void(0)'][contains(.,'Terms')])[2]")).click();
		Thread.sleep(1000);
		
		WebElement x = driver.findElement(By.xpath("//li[contains(.,'Vouchers must not be used in conjunction with any other promotional discounts.')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", x);
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//button[contains(@class,' a-button-close a-declarative')]")).click();
		Thread.sleep(1000);
		
		//ADD PRODUCT TO THE CART
		driver.findElement(By.xpath("//input[contains(@id,'add-to-cart-button')]")).click();
		Thread.sleep(1000);
		
		//VERIFY THE ADDED FUNCTIONALITY
		 if(driver.getPageSource().contains("Added to Cart"))
	      {
	    	  System.out.println("Pass");
	      }
	      
	      else {
	    	  System.out.println("Fail");
	      }
		 Thread.sleep(1000);
		 
		 //EXPAND AND COLLAPSSED 
//		 driver.findElement(By.xpath("//i[contains(@id,'nav-ewc-expand-collapse-button-icon')]")).click();
//		 driver.findElement(By.xpath("//i[contains(@id,'nav-ewc-expand-collapse-button-icon')]")).click();
//		 driver.findElement(By.xpath("//i[contains(@id,'nav-ewc-expand-collapse-button-icon')]")).click();
//		 
		// driver.findElement(By.xpath("//input[contains(@title,'Delete')]")).click();
		 
		 //CLICK ON THE THIS IS A GIFT CHECK BOX
		 driver.findElement(By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc'][contains(.,'Go to Cart')]")).click();
		 driver.findElement(By.xpath("(//input[contains(@type,'checkbox')])[2]")).click();
		 
		
		 
		
		 
		
	}
	

}
