package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateOpportunitywithoutmandatoryfields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//options.setHeadless(true);
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("jayaprakash1803@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Jp@180393");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//div[@role='navigation']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement opportunity = driver.findElement(By.xpath("//h2[text()='App Launcher']/following::p[text()='Opportunities']"));
		Actions a = new Actions(driver);
		a.moveToElement(opportunity).click().build().perform();
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/27/2022");

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		int size = driver.findElements(By.xpath("//ul[contains(@class,'errorsList')]/li")).size();
		
		for(int i=1;i<=size;i++) {
			String errorDetails = driver.findElement(By.xpath("//ul[contains(@class,'errorsList')]/li["+i+"]/a")).getText();
			System.out.println(errorDetails);
		}

		
		


		
		
		


	}

}
