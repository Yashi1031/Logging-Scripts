import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fileupload {

public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		
		driver.findElement(By.xpath("//input[contains(@id,'uploadfile_0')]")).sendKeys("C:\\Users\\yashodha_107402\\Downloads\\TestUpload.pdf");

		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/screen.png"));
		
		driver.findElement(By.xpath("//button[contains(@id,'submitbutton')]")).click();
		Thread.sleep(2000);
		driver.quit();
}
}
