package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Base {
	
	public static ChromeDriver driver;
	
	
	@BeforeMethod
	@Parameters({"username", "password"})
	public void login(String username, String password) {	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	//options.setHeadless(true);
	
	driver = new ChromeDriver(options);
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("Login")).click();
}
	@AfterMethod
	public void close() {
		
	}

}
