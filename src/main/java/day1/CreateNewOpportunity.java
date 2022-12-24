package day1;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOpportunity {

	public static void main(String[] args) throws InterruptedException, ParseException {
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
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Jayaprakash");
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/27/2022");
//		driver.findElement(By.xpath("//input[@name='CloseDate']/following::button[text()='Today']")).click();

		driver.findElement(By.xpath("//button[@type='button'][@role='combobox']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		String opp = driver.findElement(By.xpath("(//span[text()='Opportunity Name'])[2]/following::lightning-formatted-text")).getText();
		
		if(opp.equals("Salesforce Automation by Jayaprakash")) {
			System.out.println("opp created successfully");
		}else {
			System.out.println("opp not created successfully");
		}
		
		

	}

}

